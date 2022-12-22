import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static int on=36;

    @ListenBar
    public static int off=35;


    static {

    }



    private static Long time=30L;
@ListenMouseKeyboard(value = 88)
@ListenMouseKeyboard(value = 50)
private void f5(){

    robot.keyPress(KeyEvent.VK_ALT);
    pause(time);

    robot.keyPress(KeyEvent.VK_S);
    pause(time);
    robot.keyRelease(KeyEvent.VK_S);

    pause(time);

    robot.keyPress(KeyEvent.VK_W);
    pause(time);
    robot.keyRelease(KeyEvent.VK_W);

//    pause(time);

    robot.keyPress(KeyEvent.VK_SHIFT);
    pause(time);
    robot.keyRelease(KeyEvent.VK_SHIFT);
    robot.keyRelease(KeyEvent.VK_ALT);
//        robot.keyRelease(KeyEvent.VK_SPACE);

}

    @ListenMouseKeyboard(value = 90)
    @ListenMouseKeyboard(value = 49)
    private void f2(){

        robot.keyPress(KeyEvent.VK_A);
        pause(time);
        robot.keyRelease(KeyEvent.VK_A);

        pause(time);

        robot.keyPress(KeyEvent.VK_D);
        pause(time);
        robot.keyRelease(KeyEvent.VK_D);

        pause(time);
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(time);
        robot.keyRelease(KeyEvent.VK_SHIFT);


    }

    @ListenMouseKeyboard(value = 67)
    @ListenMouseKeyboard(value = 51)
    private void f3(){

        robot.keyPress(KeyEvent.VK_D);
        pause(time);
        robot.keyRelease(KeyEvent.VK_D);

        pause(time);

        robot.keyPress(KeyEvent.VK_A);
        pause(time);
        robot.keyRelease(KeyEvent.VK_A);
        pause(time);

        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(time);
        robot.keyRelease(KeyEvent.VK_SHIFT);



    }

    @ListenMouseKeyboard(value = 9)
    private void f4(){

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

//        robot.keyRelease(KeyEvent.VK_SPACE);

    }





}
