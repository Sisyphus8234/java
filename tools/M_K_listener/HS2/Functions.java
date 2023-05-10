import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static int on = 36;

    @ListenBar
    public static int off = 35;
    @ListenBar(threadList = true)
    public static List<Thread> list=new ArrayList<>();

    static Boolean temp1=false;

    public static Point pointOriginal;
    public static Point pointUser;
    public static Point pointSlider;

    public static int sliderChange=1;

    static {

    }

    @ListenMouseKeyboard(value = 81,intercept = true)
    private static void q() {
        pointSlider=MouseInfo.getPointerInfo().getLocation();
    }

    @ListenMouseKeyboard(value = 69,intercept = true)
    @ListenMouseKeyboard(value = 87,intercept = true)
    private static void e_w() {
robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(100);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        pause(100);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @ListenMouseKeyboard(value = 82,intercept = true)
    @ListenMouseKeyboard(value = 83,intercept = true)

    private static void r_s() {
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(100);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        pause(100);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

//    @ListenMouseKeyboard(value = 87,intercept = true)
//    private static void w() {
//        pointUser=MouseInfo.getPointerInfo().getLocation();
//        robot.mouseMove(pointSlider.x, pointSlider.y);
//        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//    }
//
//    @ListenMouseKeyboard(value = 83,intercept = true)
//    private static void s() {
//        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//        pointSlider=MouseInfo.getPointerInfo().getLocation();
//        robot.mouseMove(pointUser.x, pointUser.y);
//    }

    @ListenMouseKeyboard(value = 65,intercept = true)
    private static void a() {
        pointUser=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointSlider.x, pointSlider.y);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        pause(100);
        robot.mouseMove(pointSlider.x-sliderChange, pointSlider.y );
        pointSlider=MouseInfo.getPointerInfo().getLocation();
        pause(100);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pointSlider=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointUser.x, pointUser.y);

    }

    @ListenMouseKeyboard(value = 68,intercept = true)
    private static void d() {
        pointUser=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointSlider.x, pointSlider.y);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        pause(100);
        robot.mouseMove(pointSlider.x+sliderChange, pointSlider.y );
        pointSlider=MouseInfo.getPointerInfo().getLocation();
        pause(100);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pointSlider=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointUser.x, pointUser.y);
    }


}
