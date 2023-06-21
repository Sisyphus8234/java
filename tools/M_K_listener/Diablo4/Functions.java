import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions extends IFunctions {



    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));

    public static boolean temp1 = false;
    public static boolean temp2 = false;



    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;

    static {
        t1 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    if(temp2!=true){
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    pause(baseDelay);
                    }
                    else
                     {
                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        t1.mySuspend();
                    }

                }

            }
        };





    }


    @ListenMouseKeyboard(value = 71, intercept = true,keyboardOrMouse = 0)

    public static void g() {
        t1.myResume();
    }

    @ListenMouseKeyboard(value = 72 , intercept = true,keyboardOrMouse = 0)

    public static void h() {
        temp2 = true;
    }






}
