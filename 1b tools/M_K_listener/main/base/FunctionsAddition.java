package base;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FunctionsAddition extends IFunctions {


    public static class gatherPixelColorHSB{

        public static MyThread thread;
        public static boolean b = false;
        public static String folderName="record";

        public static ArrayList<float[]> HSBList=new ArrayList<>();

        public static int pixelX;
        public static int pixelY;
        public static StringBuilder stringBuilder=new StringBuilder();


        static {
            thread = new MyThread(MyThread.State.off) {
                @Override
                public void run() {
                    while (true) {
                        if (b == true) {

                            float[] HSB= getPixelColor(pixelX,pixelY);
                            HSBList.add(HSB);
                            stringBuilder.append("\nH: (").append(String.format("%.8f",HSB[0])).append(")S: (").append(String.format("%.8f",HSB[1])).append(")B: (").append(String.format("%.8f",HSB[2])).append(")");


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

                            stringBuilder.append("\nmax and min of");
                            stringBuilder.append(" H: ").append("(").append(HSBList.get(0)[0]).append("   ").append(HSBList.get(HSBList.size()-1)[0]).append(")");
                            Collections.sort(HSBList, comparator1);
                            stringBuilder.append(" S: ").append("(").append(HSBList.get(0)[1]).append("   ").append(HSBList.get(HSBList.size()-1)[1]).append(")");
                            Collections.sort(HSBList, comparator2);
                            stringBuilder.append(" B: ").append("(").append(HSBList.get(0)[2]).append("   ").append(HSBList.get(HSBList.size()-1)[2]).append(")");






                            // 将内容保存到文件
                            String fileName = folderName + "/"+ LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + ".txt";
                            try {
                                FileWriter writer = new FileWriter(fileName);
                                writer.write(stringBuilder.toString());
                                writer.close();
                                System.out.println("内容已保存到 " + fileName);
                            } catch (IOException e) {
                                System.out.println("保存文件时出现错误：" + e.getMessage());
                            }


                            this.mySuspend();
                        }
                        pause(200);
                    }


                }
            };


        }


        public static float[] getPixelColor(int x, int y) {
            Color pixelColor = robot.getPixelColor(x, y);
            float[] pixelColorHSB = Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), null);
            return (pixelColorHSB);
        }

        public static void threadOn(int x,int y) {
            pixelX=x;
            pixelY=y;
            HSBList.clear();
            stringBuilder.setLength(0);

            b =true;
            thread.myResume();

        }

        public static void threadOff() {
            b =false;
        }


    }



}