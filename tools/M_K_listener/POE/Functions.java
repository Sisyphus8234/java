import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static Integer on2=36;

    @ListenBar(off = true)
    public static Integer on1=8;

    @ListenBar(threadList = true)
    public static ArrayList<Thread> threadList=new ArrayList<>();

    public static Long time1=Long.parseLong(Config.read("Time1"));
    public static Long time2 = Long.parseLong(Config.read("Time2"));
    public static Long time3 = Long.parseLong(Config.read("Time3"));

    public static boolean temp1=false;

    public static Thread t1;
    public static Thread t2;
    public static Thread t3;
    public static Thread t4;
	static {
	    //连点右键
        t1=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
                        //pause(50);
                        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                        pause(time1);
                }
            }
        }.thread;
        t1.suspend();

        //连点左键
        t2=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    //robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    pause(time2);

                }
            }
        }.thread;
        t2.suspend();

        //按ctrl并连点左键
        t3=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    pause(time3);

                }
            }
        }.thread;
        t3.suspend();

        //e键走路放e
        t4=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    if(temp1==true){
                    robot.keyRelease(KeyEvent.VK_E);
                    robot.keyPress(KeyEvent.VK_E);
                    robot.keyRelease(KeyEvent.VK_E);
                    robot.keyPress(KeyEvent.VK_G);
                    robot.keyRelease(KeyEvent.VK_G);
                    pause(2000);}
                    else {
                        t4.suspend();
                    }
                }
            }
        }.thread;
        t4.suspend();

        threadList.add(t1);
        threadList.add(t2);
        threadList.add(t3);
        threadList.add(t4);

	}


    public static boolean trade = false;
    public static Integer count1 = 0;
    public static Integer count2 = 0;
    public static HashMap<Integer, String> map1=new HashMap<>();
    static {
        map1.put(0,"头");
        map1.put(1,"胸");
        map1.put(2,"手套");
        map1.put(3,"鞋");
        map1.put(4,"腰带");
        map1.put(5,"戒指");
//        map1.put(6,"戒指");
        map1.put(6,"护身符");
        map1.put(7,"武器|格挡几率");

//        map1.put(100,"\"物品等级: [0-5][0-9]|普通|魔法|传奇|\"!未鉴定\"\"");
        map1.put(100,"物品等级:[0-5][0-9]|普通|魔法|传奇");
        map1.put(101,"!未鉴定");
        map1.put(102,"\"物品等级: ([6][0-9]|[7][0-4])\"");
    }
    public static void 在搜索框粘贴(Integer integer, String s){
        if(trade==true){

            setClipboardString(map1.get(integer)+s);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_F);

            pause(50);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
        }
    };


    //F1
    @ListenMouseKeyboard(value = 112,intercept = true)
    private static void 按xxx开始处理成套装备模式(){
        trade=true;
        count1 = 0;
        count2 = 0;

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y =MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(491,105);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.mouseMove(x,y);
    }

    @ListenMouseKeyboard(value = 113,intercept = true)
    private static void 按xxx结束处理成套装备模式(){
        trade=false;
    }

    //esc
    //`
    @ListenMouseKeyboard(value = 27,intercept = false)
    @ListenMouseKeyboard(value = 192,intercept = false)
    private static void 按xxx结束所有(){
        trade=false;
        t1.suspend();
        t2.suspend();
        t3.suspend();
    }

    @ListenMouseKeyboard(value = 50,intercept = true)
    private static void 整套装备预筛选(){
        在搜索框粘贴(count1+100,"");
        count1++;
        if(count1>=3){
            count1=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);}

    }

    @ListenMouseKeyboard(value = 51,intercept = true)
    private static void 顺序获取整套装备(){

        在搜索框粘贴(count2,"");
        count2++;
        if(count2>=8){
            count2=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);}
    }

    @ListenMouseKeyboard(value = 53,intercept = true)
    private static void 顺序获取整套装备60到74级(){

        在搜索框粘贴(count2," 物品等级:\\s([6][0-9]|[7][0-4])");
        count2++;
        if(count2>=8){
            count2=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_5);
            robot.keyRelease(KeyEvent.VK_5);}
    }

    @ListenMouseKeyboard(value = 54,intercept = true)
    private static void 顺序获取整套装备大于74级(){

        在搜索框粘贴(count2," 物品等级:\\s([8-9][0-9]|[7][5-9])");
        count2++;
        if(count2>=8){
            count2=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_6);}
    }



//    @ListenMouseKeyboard(value = 84, immediately = true, intercept = true)
//    private static void 自动左键连点并且右键连点() {
//        t1.resume();
//        t2.resume();
//    }

//    @ListenMouseKeyboard(value = 513, immediately = true,userInput = true)
//    @ListenMouseKeyboard(value = 82, immediately = true)
//    private static void 结束连点左键和连点右键() {
//        t1.suspend();
//        t2.suspend();
//    }



    public static Integer 水银药剂 = 0;
    public static HashMap<Integer,Integer> 水银药剂map=new HashMap<>();
    static {
        水银药剂map.put(0,KeyEvent.VK_5);
        水银药剂map.put(1,KeyEvent.VK_4);
        水银药剂map.put(2,KeyEvent.VK_3);
    }
    @ListenMouseKeyboard(value = 52, intercept = true)
    private static void 喝水银药剂() {
        robot.keyPress(水银药剂map.get(水银药剂));
        robot.keyRelease(水银药剂map.get(水银药剂));
        水银药剂++;
        if(水银药剂>=3){水银药剂=0;}

    }


    @ListenMouseKeyboard(value = 49,intercept = false)
    private static void ctrl加左键连点(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        t3.resume();
    }
    @ListenMouseKeyboard(value = 49,press = false,intercept = false)
    private static void 退出ctrl加左键连点(){
        robot.keyRelease(KeyEvent.VK_CONTROL);
        t3.suspend();
    }


    @ListenMouseKeyboard(value = 190)
    private static void 市集下一页(){
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y =MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(541,177);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.mouseMove(x,y);
    }


    @ListenMouseKeyboard(value = 114,intercept = true)
    @ListenMouseKeyboard(value = 89,intercept = true)
    private static void 回城卷轴(){

        robot.keyPress(192);
        robot.keyRelease(192);

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y =MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(1295,824);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
        pause(50);

        robot.keyPress(192);
        robot.keyRelease(192);
        robot.mouseMove(x,y);
    }

//    public static boolean 捡东西=true;
//    @ListenMouseKeyboard(value = 32,press = true,intercept = true)
//    private static void 捡东西前原地站立(){
//        if(捡东西==true){
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_F);
//        robot.keyRelease(KeyEvent.VK_F);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        捡东西=false;
//        }
//    }
//    @ListenMouseKeyboard(value = 32,press = false,intercept = true)
//    private static void 捡东西(){
//        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//        捡东西=true;
//    }


    public static boolean ctrl=false;
    @ListenMouseKeyboard(value = 162)
    private static void ctrl(){
        ctrl=true;
    }
    @ListenMouseKeyboard(value = 162,press = false)
    private static void ctrl2(){
        ctrl=false;
    }
    private static void writeProp(String s1,Long l1){
        if(ctrl==false){
            Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))+l1));}
        else{
            Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))-l1));
        }
        setClipboardString(Config.prop.toString());
    }
    /**
     * 把文本设置到剪贴板（复制）
     */
    private static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }
//    @ListenMouseKeyboard(value = 57)
//    private static void adjustTime1(){
//        writeProp("Time1", 50L);
//        time1=Long.parseLong(Config.read("Time1"));
//    }



    //基础功能
    //---------------------------------------------------------------
    //各职业




//    @ListenMouseKeyboard(value = 69,intercept = true)
//    private static void 按e放r走路并放e() {
//        robot.keyPress(KeyEvent.VK_R);
//        temp1=true;
//        t4.resume();
//
//
//    }
    @ListenMouseKeyboard(value = 69)
    @ListenMouseKeyboard(value = 87)
    private static void 召唤魔侍魔卫放骨制战甲() {
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
    }

    public static boolean temp2=false;
    @ListenMouseKeyboard(value = 69,intercept = true,press = false)
    private static void 按住e() {
        if(temp2==true){
            robot.keyRelease(KeyEvent.VK_E);
        }
    }
    @ListenMouseKeyboard(value = 513)
    @ListenMouseKeyboard(value = 82)
    private static void 结束e() {
        temp2=true;
        robot.keyRelease(KeyEvent.VK_E);
    }
    @ListenMouseKeyboard(value = 514)
    @ListenMouseKeyboard(value = 82,press = false)
    private static void 结束e2() {
        temp2=false;
    }


//    @ListenMouseKeyboard(value =69 ,press = false,intercept = true)
//    private static void 按e放r走路并放e2() {
//        robot.keyRelease(KeyEvent.VK_R);
//        temp1=false;
//    }



//    @ListenMouseKeyboard(value = 87, immediately = true, intercept = true)
//    private static void f2() {
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_E);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_W);
//        robot.keyRelease(KeyEvent.VK_W);
//
//        robot.keyPress(KeyEvent.VK_5);
//        robot.keyRelease(KeyEvent.VK_5);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_Q);
//        robot.keyRelease(KeyEvent.VK_Q);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_5);
//        robot.keyRelease(KeyEvent.VK_5);
//
//    }


}
