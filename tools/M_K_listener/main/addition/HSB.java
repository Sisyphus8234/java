package addition;

import base.IFunctions;
import base.InputInfo;
import base.JsonUtil;
import base.MyThread;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static java.awt.event.KeyEvent.VK_F7;
import static java.awt.event.KeyEvent.VK_F8;

public class HSB {


    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    public static String folderName = "record";


    static class Compare {



        public ArrayList<ArrayList<Float>> list0=new ArrayList<>();
        public ArrayList<ArrayList<Float>> list1=new ArrayList<>();

        public ArrayList<ArrayList<Float>> minMax0=new ArrayList<>();
        public ArrayList<ArrayList<Float>> minMax1=new ArrayList<>();


    }


    public static Compare compare=new Compare();

    public static BlockingQueue<Integer> queue0 = new LinkedBlockingQueue<>();
    public static MyThread thread0 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                try {
                    Integer temp=queue0.take();
                    queue0.put(temp);

                    if(HSBState==0){
                        compare.list0.add(getPixelColorHSB(point));
                    }else if(HSBState==1) {
                        compare.list1.add(getPixelColorHSB(point));
                    }
                } catch (InterruptedException e) {
                    //---
                    e.printStackTrace();
                }
            }
        }
    };



    public static void compareHSB(){

        for(int i=0;i<=2;i++){
            final int index=i;
            Optional<Float> min = compare.list0.stream()
                    .map(color -> color.get(index))  // 提取 R 通道
                    .min(Float::compare);

            Optional<Float> max = compare.list0.stream()
                    .map(color -> color.get(index))  // 提取 R 通道
                    .max(Float::compare);

            compare.minMax0.add(new ArrayList<>(Arrays.asList(min.get(),max.get())));
        }

        for(int i=0;i<=2;i++){
            final int index=i;
            Optional<Float> min = compare.list1.stream()
                    .map(color -> color.get(index))  // 提取 R 通道
                    .min(Float::compare);

            Optional<Float> max = compare.list1.stream()
                    .map(color -> color.get(index))  // 提取 R 通道
                    .max(Float::compare);

            compare.minMax1.add(new ArrayList<>(Arrays.asList(min.get(),max.get())));
        }


    }


    public static ArrayList<Float> getPixelColorHSB(Point point) {

        int pixelX= point.x;
        int pixelY=point.y;

        pixelX=(int)(pixelX/ IFunctions.screenScale);
        pixelY=(int)(pixelY/ IFunctions.screenScale);
        Color pixelColor = robot.getPixelColor(pixelX, pixelY);
        float[] pixelColorHSB = Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), null);

        ArrayList<Float> res=new ArrayList<>();
        for(float enty:pixelColorHSB){
            res.add(enty);
        }

        return res;
    }




    public static Point point=new Point();
    public static int HSBState=-1;

    public static void 读取颜色(int state) {
        if (IFunctions.clipboardIsString()) {
            String text = IFunctions.readClipboard().replaceAll(" ", "");
            String[] parts = text.split(",");
            point.x = Integer.parseInt(parts[0]);
            point.y = Integer.parseInt(parts[1]);
            IFunctions.writeClipboard(point.x + "," + point.y);
            HSBState=state;
            if(HSBState==0){
                compare=new Compare();
            }else if(HSBState==1){
                compare.list1=new ArrayList<>();
            }

            try {
                queue0.put(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void 读取颜色1() {

        if(HSBState==1){
            JsonUtil.writeJsonFile("aaa",compare);
        }


    }
}
