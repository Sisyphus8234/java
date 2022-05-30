import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));

    public static boolean temp1 = false;
    public static boolean temp2 = false;

    public static Thread t1;

    static {
        t1 = new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {

                    if (temp1 == false) {

                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        temp1 =true;

                    } else if (temp2 ==true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        temp1=false;
                        temp2 =false;
                        t1.suspend();
                    }
                    pause(baseDelay);
                }

            }
        }.thread;
        t1.suspend();
    }


    @ListenMouseKeyboard(value = 27, intercept = true)
    public static void f() {
        t1.resume();
    }

    @ListenMouseKeyboard(value = 27, press = false, intercept = true)
    public static void f2() {
        temp2 = true;
    }

    @ListenMouseKeyboard(value = 112, intercept = true)
    public static void f3() {
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);

    }

    @ListenMouseKeyboard(value = 112,press = false, intercept = true)
    public static void f4() {

        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
    }

    @ListenMouseKeyboard(value = 113,intercept = true)
    public static void f5() {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @ListenMouseKeyboard(value = 114,intercept = true)
    public static void f6() {
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    @ListenMouseKeyboard(value = 115,intercept = true)
    public static void f7() {
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }

    @ListenMouseKeyboard(value = 33,intercept = true)
    public static void f8() {
        robot.mouseWheel(-6);
    }

    @ListenMouseKeyboard(value = 34,intercept = true)
    public static void f9() {
        robot.mouseWheel(6);
    }





}
