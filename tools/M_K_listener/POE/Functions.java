import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long time2 = Long.parseLong(Config.read("time2"));

    public static long temp1=0;

    public static Thread t1;

    static {
        t1 = new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                    if(new Date().getTime() - temp1 <= time2) {
                        robot.keyPress(KeyEvent.VK_E);
                        robot.keyRelease(KeyEvent.VK_E);
                        pause(baseDelay);
                    } else {
                        robot.keyPress(KeyEvent.VK_W);
                        robot.keyRelease(KeyEvent.VK_W);
                        pause(baseDelay);
                    }
                }
            }
        }.thread;

        t1.suspend();
    }

    //按下键盘空格键触发
    @ListenMouseKeyboard(value = 69, immediately = true, intercept = true)
    private static void f1() {
        // TODO Auto-generated method stub
        temp1 = new Date().getTime();
        t1.resume();

    }

    @ListenMouseKeyboard(value = 87, immediately = true, intercept = true)
    private static void f2() {
        // TODO Auto-generated method stub
        temp1=0;
        t1.resume();

    }

    @ListenMouseKeyboard(value = 513, immediately = true)
    @ListenMouseKeyboard(value = 82, immediately = true)
    @ListenMouseKeyboard(value = 32, immediately = true)
    private static void f3() {
        // TODO Auto-generated method stub
        t1.suspend();

    }


}
