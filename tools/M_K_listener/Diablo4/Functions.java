import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static boolean temp1 = false;
    public static boolean temp2 = false;
    public static boolean isRelease = true;


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;

    static {
        t1 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    if(temp2==true){
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

                        pause(baseDelay);
                    }
                    else
                     {
                         if(isRelease ==true){
                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);}
                         this.mySuspend();
                         isRelease =true;
                         pause(baseDelay);
                    }
                }
            }
        };
        t1.myResume();

    }


    @ListenMouseKeyboard(value = 69, intercept = true,keyboardOrMouse = 0)
    public static void e() {

//        if(temp2==false){
            temp2=true;
            t1.myResume();
//        }else {
//            temp2 = false;
//            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//        }
    }

//    @ListenMouseKeyboard(value = 82 , intercept = true,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 514 ,keyboardOrMouse = 1)
    public static void 左键() {
        temp2 = false;
    }

    @ListenMouseKeyboard(value = 87 ,keyboardOrMouse = 0)
    public static void w() {
        isRelease =false;
        temp2 = false;
    }

    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
    public static void 右键() {
        if(temp2==true){
            temp1=true;
        }
        temp2 = false;
    }

    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = 0)
    public static void 右键1() {
        if(temp1==true){
            temp2 = true;
            t1.myResume();
        }
        temp1=false;
    }










}
