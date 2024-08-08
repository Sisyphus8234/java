package addition;

import base.Config;
import base.Controller;
import base.IFunctions;
import base.MyThread;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class FunctionsAddition extends IFunctions {
    public static class PixelColor {

        public static Robot robot;

        static {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean b = false;
        public static String folderName = "record";

        public ArrayList<float[]> HSBList = new ArrayList<>();
        public int pixelXForThread0;
        public int pixelYForThread0;
        public StringBuilder stringBuilder = new StringBuilder();
        public Color pixelColor;
        public float[] pixelColorHSB;
        public boolean active;


        public static HSB activeHSB=new HSB();
        public static HSB notActiveHSB=new HSB();

        public MyThread thread0 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (b == true) {

                        float[] HSB = getPixelColorHSB(pixelXForThread0, pixelYForThread0);
                        HSBList.add(HSB);
                        stringBuilder.append("H: (").append(valueOfFormatFloat(HSB[0])).append(") S: (").append(valueOfFormatFloat(HSB[1])).append(") B: (").append(valueOfFormatFloat(HSB[2])).append(")\n");


                    } else {

                        File directory = new File(folderName);
                        if (!directory.exists()) {
                            directory.mkdirs(); // 创建目标文件夹及其父文件夹（如果不存在）
                        }

                        // 自定义一个 Comparator 来根据第一个元素降序排序
                        Comparator<float[]> comparator = (arr1, arr2) -> Float.compare(arr1[0], arr2[0]);
                        Comparator<float[]> comparator1 = (arr1, arr2) -> Float.compare(arr1[1], arr2[1]);
                        Comparator<float[]> comparator2 = (arr1, arr2) -> Float.compare(arr1[2], arr2[2]);

                        // 使用 Collections.sort() 进行排序
                        Collections.sort(HSBList, comparator);

                        HSB hsb=new HSB();
                        hsb.point=new Point(pixelXForThread0,pixelYForThread0);
                        hsb.active=active;

                        stringBuilder.append("min and max of");
                        stringBuilder.append(" H: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[0])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[0])).append(")");
                        ArrayList<Float> minAndMaxOfH=new ArrayList<>(Arrays.asList(HSBList.get(0)[0],HSBList.get(HSBList.size() - 1)[0]));
                        hsb.colorList.add(minAndMaxOfH);

                        Collections.sort(HSBList, comparator1);
                        stringBuilder.append(" S: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[1])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[1])).append(")");
                        ArrayList<Float> minAndMaxOfS=new ArrayList<>(Arrays.asList(HSBList.get(0)[1],HSBList.get(HSBList.size() - 1)[1]));
                        hsb.colorList.add(minAndMaxOfS);

                        Collections.sort(HSBList, comparator2);
                        stringBuilder.append(" B: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[2])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[2])).append(")");
                        ArrayList<Float> minAndMaxOfB=new ArrayList<>(Arrays.asList(HSBList.get(0)[2],HSBList.get(HSBList.size() - 1)[2]));
                        hsb.colorList.add(minAndMaxOfB);

                        stringBuilder.append("\n");

                        // 将内容保存到文件
                        String fileName = folderName + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss")) + " (" + pixelXForThread0 + "," + pixelYForThread0 + ")" + ".txt";
                        try {
                            FileWriter writer = new FileWriter(fileName);
                            writer.write(stringBuilder.toString());
                            writer.close();
                            System.out.println("content saved to: " + fileName);
                        } catch (IOException e) {
                            System.out.println("errors occurred while saving the file: " + e.getMessage());
                        }





                        if(active==true){
                            activeHSB=hsb;
                        }else {
                            notActiveHSB=hsb;
                        }



                        result();

                        this.mySuspend();
                    }
                    pause(200);
                }


            }
        };

        private String valueOfFormatFloat(float f) {
            return String.format("%.8f", f);
        }


        public float[] getPixelColorHSB(int pixelX, int pixelY) {
            pixelX=(int)(pixelX/screen_scale);
            pixelY=(int)(pixelY/screen_scale);
            pixelColor = robot.getPixelColor(pixelX, pixelY);
            pixelColorHSB = Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), null);
            return (pixelColorHSB);
        }

        public void threadOn(int pixelX, int pixelY) {
            this.pixelXForThread0 = pixelX;
            this.pixelYForThread0 = pixelY;
            HSBList.clear();
            stringBuilder.setLength(0);

            b = true;
            thread0.myResume();
        }

        public void threadOff() {
            b = false;
        }

        public void result() {
            if(Objects.equals(activeHSB.point,notActiveHSB.point)) {

                String name = pixelXForThread0 + "," + pixelYForThread0 + ",";


                for (int i = 0; i < activeHSB.colorList.size(); i++) {
                    ResultClass resultClass = compareLists(activeHSB.colorList.get(i), notActiveHSB.colorList.get(i));
                    String symbol = "";
                    String average = "";
                    if (resultClass.large == null) {

                    } else if (resultClass.large) {
                        symbol = "前者>后者";
                        average = String.valueOf(resultClass.average);

                    } else if (resultClass.large == false) {
                        symbol = "前者<后者";
                        average = String.valueOf(resultClass.average);
                    }
                    Config.writeWithPrefix(name + i + ",symbol", symbol);


                    Config.writeWithPrefix(name + i + ",average", average);

                }
            }







        }

        public static ResultClass compareLists(List<Float> a, List<Float> b) {
            ResultClass resultClass=new ResultClass();

            // 检查两个列表是否可比较
            boolean aIsGreaterThanB = a.stream().allMatch(ai -> ai > b.get(0) && ai > b.get(1));
            boolean bIsGreaterThanA = b.stream().allMatch(bi -> bi > a.get(0) && bi > a.get(1));

            if (aIsGreaterThanB || bIsGreaterThanA) {
                // 取大的列表的最小值和小的列表的最大值的平均值
                double average = (Math.min(a.get(0), b.get(1)) + Math.max(a.get(1), b.get(0))) / 2.0;

                // 判断哪个列表是大的
                boolean aIsGreater = aIsGreaterThanB;

                resultClass.average = (float) average;
                resultClass.large=aIsGreater;

                System.out.println("Min of larger list and max of smaller list average: " + average);

                // 返回是哪个列表较大
                return resultClass;
            } else {

                resultClass.large=null;
                resultClass.average=null;
                // 两个列表不可比较
                return resultClass;
            }
        }

    }


    public static class HSB implements Serializable {
        public Point point;
        public boolean active;
        public List<List<Float>> colorList=new ArrayList<>();

    }

    static class ResultClass {
        public Boolean large;

        public Float average;
    }



}