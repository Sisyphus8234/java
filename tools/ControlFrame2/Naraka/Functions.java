package custom;

import base.*;

import java.awt.event.KeyEvent;
class Run extends MainClass {


}
public class Functions extends IFunctions {


    public static boolean temp1 = false;
    public static boolean temp2 = false;
    public static boolean temp3 = false;





    public static Long spaceDelay=Long.parseLong(Config.read("SpaceDelay"));
    public static Long EDelay=Long.parseLong(Config.read("EDelay"));

    public static MyThread  t1=new MyThread() {
            @Override
            public void run() {
                while (true) {

//                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));
                    if (temp1 == true) {
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.keyPress(KeyEvent.VK_SPACE);
                        pause(spaceDelay);
                    }
                    else{
                        t1.mySuspend();
                    }
                }
            }
        };

    public static MyThread t2=new MyThread(){
            @Override
            public void run() {
                while (true) {
//                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));
					if (temp2 == true) {
						robot.keyRelease(KeyEvent.VK_T);
						robot.keyPress(KeyEvent.VK_T);
//						robot.keyRelease(KeyEvent.VK_T);
						pause(EDelay);
					}else if(temp3==true){
//                        pause(300);
                        robot.keyRelease(KeyEvent.VK_5);
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                        pause(100);
                        robot.keyRelease(KeyEvent.VK_4);
                        robot.keyPress(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_4);

                    }
					else{
                        t2.mySuspend();
                    }

				}
			}
        };



    @ListenMouseKeyboard(key = "space",intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space() {
        temp1 = true;
        t1.myResume();

//        t2.suspend();
        temp3=false;
    }

    @ListenMouseKeyboard(key = "space",press = false,intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space2() {
//        robot.keyRelease(KeyEvent.VK_SPACE);
        temp1 = false;
    }

//    @ListenMouseKeyboard(value = 81,press = false)
//    private static void q() {
//        robot.keyRelease(KeyEvent.VK_T);
//    }
//
//



    //拾取物品
//    @ListenMouseKeyboard(value = 84, intercept = true
    @ListenMouseKeyboard(key = "t",intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e() {
        temp2 = true;
        t2.myResume();
    }
//    @ListenMouseKeyboard(value = 84, press = false, intercept = true)
    @ListenMouseKeyboard(key = "t",press = false,intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)

    public static void e2() {
        temp2 = false;
    }




//    //拉人 T
//    @ListenMouseKeyboard(value = 84, intercept = true)
//    private static void t() {
//        robot.keyPress(KeyEvent.VK_E);
//    }
//    @ListenMouseKeyboard(value = 84, press = false, intercept = true)
//    private static void t2() {
//        robot.keyRelease(KeyEvent.VK_E);
//    }

    //换武器 G
//    @ListenMouseKeyboard(value = 71, inter cept = true)
//    private static void g() {
//        robot.keyRelease(KeyEvent.VK_TAB);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//        pause(40);
//        robot.mouseMove(1794,622);
////        pause(1000);
//        robot.mousePress(MouseEvent.BUTTON1_MASK);
//        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
//
//        pause(40);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//    }


//    public static boolean ctrl=false;
//    @ListenMouseKeyboard(value = 162)
//    private static void ctrl(){
//        ctrl=true;
//    }
//    @ListenMouseKeyboard(value = 162,press = false)
//    private static void ctrl2(){
//        ctrl=false;
//    }
//
//
//    private static void writeProp(String s1,Long l1){
//        if(ctrl==false){
//        Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))+l1));}
//        else{
//            Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))-l1));
//        }
//        setClipboardString(Config.prop.toString());
//    }
//
//    /**
//     * 把文本设置到剪贴板（复制）
//     */
//    private static void setClipboardString(String text) {
//        // 获取系统剪贴板
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        // 封装文本内容
//        Transferable trans = new StringSelection(text);
//        // 把文本内容设置到系统剪贴板
//        clipboard.setContents(trans, null);
//    }
//
//    //9
//    @ListenMouseKeyboard(value = 57)
//    private static void SpaceDelay(){
//        writeProp("SpaceDelay", 50L);
//        spaceDelay=Long.parseLong(Config.read("SpaceDelay"));
//    }
//
//    //8
//    @ListenMouseKeyboard(value = 56)
//    private static void EDelay(){
//        writeProp("EDelay", 50L);
//        spaceDelay=Long.parseLong(Config.read("EDelay"));
//    }

//    @ListenMouseKeyboard(value = 67,press = false,intercept = true)
//    private static void yao(){
//        temp3=true;
//        t2.resume();
//    }

//    @ListenMouseKeyboard(value = 160,press = true,intercept = true)
    @ListenMouseKeyboard(key = "shift左",intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 短闪1(){
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    @ListenMouseKeyboard(key = "shift左",press = false,intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)

    public static void 短闪2(){
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

//    @ListenMouseKeyboard(value = 18)
//    private static void yao2(){
//        System.out.println(1234);
//        temp3=false;
//    }


//    @ListenMouseKeyboard(value = 81)
//    private static void test(){
//        robot.keyPress(KeyEvent.VK_1);
//        robot.keyRelease(KeyEvent.VK_1);
//    }





}
