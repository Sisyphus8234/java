package base;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FunctionsAddition extends IFunctions {
    public static class PixelColor {
        public boolean b = false;
        public String folderName = "record";
        public ArrayList<float[]> HSBList = new ArrayList<>();
        public int pixelXForThread0;
        public int pixelYForThread0;
        public StringBuilder stringBuilder = new StringBuilder();
        public Color pixelColor;
        public float[] pixelColorHSB;


        public MyThread thread0 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (b == true) {

                        float[] HSB = getPixelColor(pixelXForThread0, pixelYForThread0);
                        HSBList.add(HSB);
                        stringBuilder.append("H: (").append(String.format("%.8f", HSB[0])).append(")S: (").append(String.format("%.8f", HSB[1])).append(")B: (").append(String.format("%.8f", HSB[2])).append(")\n");


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

                        stringBuilder.append("max and min of ");
                        stringBuilder.append("H: ").append("(").append(HSBList.get(0)[0]).append("   ").append(HSBList.get(HSBList.size() - 1)[0]).append(")");
                        Collections.sort(HSBList, comparator1);
                        stringBuilder.append("S: ").append("(").append(HSBList.get(0)[1]).append("   ").append(HSBList.get(HSBList.size() - 1)[1]).append(")");
                        Collections.sort(HSBList, comparator2);
                        stringBuilder.append("B: ").append("(").append(HSBList.get(0)[2]).append("   ").append(HSBList.get(HSBList.size() - 1)[2]).append(")");
                        stringBuilder.append("\n");


                        // 将内容保存到文件
                        String fileName = folderName + "/("+ pixelXForThread0+","+pixelYForThread0+")"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss")) + ".txt";
                        try {
                            FileWriter writer = new FileWriter(fileName);
                            writer.write(stringBuilder.toString());
                            writer.close();
                            System.out.println("content saved to: " + fileName);
                        } catch (IOException e) {
                            System.out.println("errors occurred while saving the file: " + e.getMessage());
                        }


                        this.mySuspend();
                    }
                    pause(200);
                }


            }
        };


        public float[] getPixelColor(int pixelX, int pixelY) {
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

    }

}