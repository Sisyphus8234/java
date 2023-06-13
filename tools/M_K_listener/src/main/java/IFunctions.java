import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

public class IFunctions {

    public static boolean Jna = true;

    public static boolean jintellitype = false;

    public static Robot robot;

    @ListenBar(off = false)
    public static Integer on=33;

    @ListenBar(off = true)
    public static Integer off=34;

    @ListenBar(threadList = true)
    public static List<Thread> threadList=new ArrayList<>();

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

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    class CreateThread {
//        public Thread thread;
//        public void myFunction() {
//        };
//        public CreateThread() {
//            thread = new Thread() {
//                @Override
//                public void run() {
//                    myFunction();
//                }
//            };
//            thread.start();
//            try {
//                thread.wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            threadList.add(thread);
//        }
//    }

}


