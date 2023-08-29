package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

public class IFunctions {

    public static boolean Jna = true;

    public static boolean jintellitype = false;

    public static Robot robot;

    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static Integer on=33;

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static Integer off=34;

    @ListenBar(threadList = true)
    public static List<MyThread> threadList=new ArrayList<>();

    static {
        System.out.println("IFunctions class loading");
        try {
            robot = new Robot();
            System.out.println("Robot instance created");
        } catch (AWTException e) {
            e.printStackTrace();
        }

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


