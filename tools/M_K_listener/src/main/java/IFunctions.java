import java.awt.AWTException;
import java.awt.Robot;

public class IFunctions {

    public static boolean Jna = true;

    public static boolean jintellitype = false;

    public static Robot robot;

    static {

        System.out.println("Functions类加载");

        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Robot创建完成");
    }

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class createThread{
        public void myFunction(){};
        public createThread(){
            new Thread() {
                @Override
                public void run() {
                    myFunction();
                }
            }.start();
        }
    }

}


