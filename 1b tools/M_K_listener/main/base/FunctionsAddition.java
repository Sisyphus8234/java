package base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

                        stringBuilder.append("min and max of");
                        stringBuilder.append(" H: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[0])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[0])).append(")");
                        Collections.sort(HSBList, comparator1);
                        stringBuilder.append(" S: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[1])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[1])).append(")");
                        Collections.sort(HSBList, comparator2);
                        stringBuilder.append(" B: ").append("(").append(valueOfFormatFloat(HSBList.get(0)[2])).append(" ").append(valueOfFormatFloat(HSBList.get(HSBList.size() - 1)[2])).append(")");
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

    public static class TopLevelBoxDrawer {
        static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        static int screenWidth = (int) screenSize.getWidth();
        static int screenHeight = (int) screenSize.getHeight();

        public static JFrame frame=new JFrame("");;

        public static boolean show=false;

        public static class Argument {
            public Color color;
            public float lineWidth;
            public double x;
            public double y;
            public double w;
            public double h;
        }

        public static void createOutline(List<Argument> argumentList) {
            SwingUtilities.invokeLater(() -> {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(screenWidth, screenHeight);
                frame.setUndecorated(true); // 设置为无边框窗口
                frame.setAlwaysOnTop(true); // 设置为最上层窗口
                frame.setBackground(new Color(0, 0, 0, 0)); // 设置窗口背景透明

                for (Argument argument : argumentList) {
                    JPanel panel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.setColor(argument.color);
                            g2d.setStroke(new BasicStroke(argument.lineWidth)); // 设置线宽
                            g2d.draw(new Rectangle2D.Double(argument.x, argument.y, argument.w, argument.h)); // 绘制红色线框
                        }
                    };
                    panel.setOpaque(false); // 设置面板背景透明
                    frame.add(panel);
                    System.out.println("222222222222222222");
                    System.out.println(argument.x);
                }
                frame.setVisible(true);

                show=true;
            });
        }

        public static void closeFrame(){
            frame.dispose();
            show=false;
        }

//        public static void aaa() {
//            List<Argument> aaa=new ArrayList<>();
//
//            FunctionsAddition.TopLevelBoxDrawer.Argument argument=new FunctionsAddition.TopLevelBoxDrawer.Argument();
//            argument.color=Color.RED;
//            argument.x=1000;
//            argument.y=850;
//            argument.w=20;
//            argument.h=20;
//            argument.lineWidth=3;
//            aaa.add(argument);
//
//            FunctionsAddition.TopLevelBoxDrawer.Argument argument1=new FunctionsAddition.TopLevelBoxDrawer.Argument();
//            argument1.color=Color.RED;
//            argument1.x=1200;
//            argument1.y=850;
//            argument1.w=20;
//            argument1.h=20;
//            argument1.lineWidth=3;
//            aaa.add(argument1);
//
//            createOutline(aaa);
//        }
    }

}