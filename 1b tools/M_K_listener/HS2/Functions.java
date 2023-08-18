import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Functions extends IFunctions {
    public static Integer valueOriginal;

    public static Point pointUser;
    public static Point pointInput;

    public static int sliderChange=4;

    public static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static Point pointForTryClothOriginal;
    public static Point cloth0=new Point(Integer.parseInt(Config.read("cloth0X","0")),Integer.parseInt(Config.read("cloth0Y","0")));
    public static Point cloth1=new Point(Integer.parseInt(Config.read("cloth1X","0")),Integer.parseInt(Config.read("cloth1Y","0")));
    public static Point cloth2=new Point(Integer.parseInt(Config.read("cloth2X","0")),Integer.parseInt(Config.read("cloth2Y","0")));
    public static Point 定位衣服按钮= new Point(Integer.parseInt(Config.read("定位衣服按钮X","0")),Integer.parseInt(Config.read("定位衣服按钮Y","0")));
    public static Integer whichCloth=0;

    public static Thread t1;

    public static Boolean temp0=false;

    static {
        t1=new CreateThread(){
            public void myFunction() {
                while (true) {

                    pointForTryClothOriginal = MouseInfo.getPointerInfo().getLocation();


                    switch (whichCloth) {
                        case 0:
                            robot.mouseMove(cloth0.x, cloth0.y);
                            break;
                        case 1:
                            robot.mouseMove(cloth1.x, cloth0.y);
                            break;
                        case 2:
                            robot.mouseMove(cloth2.x, cloth0.y);
                    }

                    pause(50);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

                    if (whichCloth == 0) {
                        pause(100);
                        robot.mouseMove(定位衣服按钮.x, 定位衣服按钮.y);
                        pause(400);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        pause(50);
                    }
                    whichCloth++;
                    if (whichCloth >= 3) {
                        pause(200);
                        robot.mouseWheel(1);
                        pause(200);
                        whichCloth = 0;
                    }

                    pause(50);

                    robot.mouseMove(pointForTryClothOriginal.x, pointForTryClothOriginal.y);




                    if(temp0==false){
                    this.thread.suspend();
                    }else {
                        pause(600);
                    }


                }

            };
        }.thread;

    }

    @ListenMouseKeyboard(value = 81,intercept = true)
    public static void q() {
        pointInput=MouseInfo.getPointerInfo().getLocation();
    }

    @ListenMouseKeyboard(value = 69,intercept = true)
    @ListenMouseKeyboard(value = 87,intercept = true)
    public static void e_w() {
        pointInput=MouseInfo.getPointerInfo().getLocation();

        CTRLCOrV(KeyEvent.VK_C);
        valueOriginal=getValue();

    }

    @ListenMouseKeyboard(value = 82,intercept = true)
    @ListenMouseKeyboard(value = 83,intercept = true)
    public static void r_s() {
        robot.mouseMove(pointInput.x, pointInput.y);
        setValue(valueOriginal);
        CTRLCOrV(KeyEvent.VK_V);
        robot.mouseMove(pointUser.x, pointUser.y);
    }



    @ListenMouseKeyboard(value = 65,intercept = true)
    public static void a() {

        changeValue(-sliderChange);



    }

    @ListenMouseKeyboard(value = 68,intercept = true)
    public static void d() {
        changeValue(sliderChange);

    }



    public static Integer getValue(){


        Integer value=null;
        // 检查剪贴板中是否有文本内容
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                // 获取剪贴板内容
                System.out.println(clipboard.getData(DataFlavor.stringFlavor));
                value = Integer.valueOf((String) clipboard.getData(DataFlavor.stringFlavor));
                System.out.println("获取原始值: " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static void setValue(Integer value){


        // 封装文本内容
        Transferable trans = new StringSelection(String.valueOf(value));
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);

        System.out.println("加之前的值: " + value);
    }

    public static void changeValue(Integer sliderChange){

        pointUser=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointInput.x, pointInput.y);

        Integer value=getValue();

        setValue(value+sliderChange);

        CTRLCOrV(KeyEvent.VK_V);

        pointInput=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointUser.x, pointUser.y);

    }

    public static void CTRLCOrV(Integer COrV){
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(COrV);
        pause(50);
        robot.keyRelease(COrV);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        pause(50);
    }

    @ListenMouseKeyboard(value = 74,intercept = true)
    public static void j() {
        cloth0 =MouseInfo.getPointerInfo().getLocation();

        Config.write("cloth0X", String.valueOf(cloth0.x));
        Config.write("cloth0Y", String.valueOf(cloth0.y));
    }
    @ListenMouseKeyboard(value = 75,intercept = true)
    public static void k() {
        cloth1 =MouseInfo.getPointerInfo().getLocation();
        Config.write("cloth1X", String.valueOf(cloth1.x));
        Config.write("cloth1Y", String.valueOf(cloth1.y));
    }
    @ListenMouseKeyboard(value = 76,intercept = true)
    public static void l() {
        cloth2 =MouseInfo.getPointerInfo().getLocation();
        Config.write("cloth2X", String.valueOf(cloth2.x));
        Config.write("cloth2Y", String.valueOf(cloth2.y));
    }

    @ListenMouseKeyboard(value = 186,intercept = true)
    public static void 冒号() {
        定位衣服按钮 =MouseInfo.getPointerInfo().getLocation();
        Config.write("定位衣服按钮X", String.valueOf(定位衣服按钮.x));
        Config.write("定位衣服按钮Y", String.valueOf(定位衣服按钮.y));
    }



    @ListenMouseKeyboard(value = 72,intercept = true)
    public static void h() {

        t1.resume();
        temp0=true;
    }

    @ListenMouseKeyboard(value = 72,press = false,intercept = true)
    public static void h1() {
        temp0=false;
    }



}
