package addition;

import base.IFunctions;
import base.JsonUtil;
import base.MyThread;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HSB {


    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    public static String prefix = "HSB_";


    static class Compare {

        public ArrayList<float[]> minMax0 = new ArrayList<>();
        public ArrayList<float[]> minMax1 = new ArrayList<>();


        public ArrayList<float[]> list0 = new ArrayList<>();
        public ArrayList<float[]> list1 = new ArrayList<>();


    }


    public static Compare compare = new Compare();

    public static BlockingQueue<Integer> queue0 = new LinkedBlockingQueue<>();
    public static MyThread thread0 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                try {
                    Integer temp = queue0.take();
                    queue0.put(temp);

                    if (HSBState == 0) {
                        compare.list0.add(getPixelColorHSB(point.x, point.y));
                    } else if (HSBState == 1) {
                        compare.list1.add(getPixelColorHSB(point.x, point.y));
                    }
                } catch (InterruptedException e) {
                    //---
                    e.printStackTrace();
                }

                IFunctions.pause(200L);
            }
        }
    };


    public static void compareHSB() {

        JsonUtil.writeJsonFile("test", compare);

        for (int i = 0; i <= 2; i++) {
            final int index = i;
            Optional<Float> min = compare.list0.stream().map(color -> color[index]).min(Float::compare);

            Optional<Float> max = compare.list0.stream().map(color -> color[index]).max(Float::compare);

            float[] temp = {min.get(), max.get()};
            compare.minMax0.add(temp);
        }

        for (int i = 0; i <= 2; i++) {
            final int index = i;
            Optional<Float> min = compare.list1.stream().map(color -> color[index]).min(Float::compare);

            Optional<Float> max = compare.list1.stream().map(color -> color[index]).max(Float::compare);

            float[] temp = {min.get(), max.get()};
            compare.minMax1.add(temp);
        }


    }


    public static float[] getPixelColorHSB(int pixelX, int pixelY) {

        pixelX = (int) (pixelX / IFunctions.screenScale);
        pixelY = (int) (pixelY / IFunctions.screenScale);
        Color pixelColor = robot.getPixelColor(pixelX, pixelY);
        float[] pixelColorHSB = Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), null);

        return pixelColorHSB;
    }


    public static Point point = new Point();
    public static int HSBState = -1;

    public static void 读取颜色(int state) {
        if (IFunctions.clipboardIsString()) {
            String text = IFunctions.readClipboard().replaceAll(" ", "");
            String[] parts = text.split(",");
            point.x = Integer.parseInt(parts[0]);
            point.y = Integer.parseInt(parts[1]);
            IFunctions.writeClipboard(point.x + "," + point.y);
            HSBState = state;
            if (HSBState == 0) {
                compare = new Compare();
            } else if (HSBState == 1) {
                compare.list1 = new ArrayList<>();
            }

            try {
                queue0.put(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void 读取颜色1() {
        queue0.clear();

        if (HSBState == 1) {
            compareHSB();
            JsonUtil.writeJsonFile(prefix + point.x + "," + point.y + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss")) + ".json", compare);
        }


    }
}
