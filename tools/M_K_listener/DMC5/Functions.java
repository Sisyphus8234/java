import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static int on = 36;

    @ListenBar
    public static int off = 35;


    static {

    }


    private static Long time = 30L;


    public static boolean attack = false;

    //滚轮
    @ListenMouseKeyboard(value = 522)
    private void f6() {
        attack = true;
    }

    @ListenMouseKeyboard(value = 88)
    @ListenMouseKeyboard(value = 50)
    private void f5() {

        robot.keyPress(KeyEvent.VK_ALT);
        pause(time);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        pause(time);
        robot.keyRelease(KeyEvent.VK_S);

        pause(time);

        robot.keyPress(KeyEvent.VK_W);
        pause(time);
        robot.keyRelease(KeyEvent.VK_W);


        if (attack == false) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            pause(time);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            pause(time);
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
            attack = false;
        }


    }

    @ListenMouseKeyboard(value = 90)
    @ListenMouseKeyboard(value = 49)
    private void f2() {

        robot.keyPress(KeyEvent.VK_A);
        pause(time);
        robot.keyRelease(KeyEvent.VK_A);

        pause(time);

        robot.keyPress(KeyEvent.VK_D);
        pause(time);
        robot.keyRelease(KeyEvent.VK_D);

        if (attack == false) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            pause(time);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            pause(time);
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
            attack = false;
        }


    }

    @ListenMouseKeyboard(value = 67)
    @ListenMouseKeyboard(value = 51)
    private void f3() {

        robot.keyPress(KeyEvent.VK_D);
        pause(time);
        robot.keyRelease(KeyEvent.VK_D);

        pause(time);

        robot.keyPress(KeyEvent.VK_A);
        pause(time);
        robot.keyRelease(KeyEvent.VK_A);


        if (attack == false) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            pause(time);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            pause(time);
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
            attack = false;
        }

    }


    @ListenMouseKeyboard(value = 9)
    private void f4() {

        robot.keyPress(KeyEvent.VK_A);
        pause(time);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_S);
        pause(time);
        robot.keyRelease(KeyEvent.VK_S);

        robot.keyPress(KeyEvent.VK_D);
        pause(time);
        robot.keyRelease(KeyEvent.VK_D);


        robot.keyPress(KeyEvent.VK_W);
        pause(time);
        robot.keyRelease(KeyEvent.VK_W);


        pause(time);
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(time);
        robot.keyRelease(KeyEvent.VK_SHIFT);

    }

    @ListenMouseKeyboard(value = 71)
    private void f7() {

robot.keyRelease(KeyEvent.VK_F);
robot.keyPress(KeyEvent.VK_F);

    }

}
