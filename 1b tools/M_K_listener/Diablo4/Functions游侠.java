package custom;


import base.FunctionsAddition;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;



public class Functions游侠 extends Functions公共 {

//    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelay = 150L;


    public static boolean t3Temp = false;

    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean w或者左键 = false;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    public static 筛选装备_游侠 筛选装备_游侠 = new 筛选装备_游侠();


    public static final int rgby1= 980;
    public static final int rgby2= 995;
    public static final float value1= 0.624F;
    public static final float value2= 0.661F;
    public static int rgbx=1313;
    public static int rgby=rgby1;
    public static float value= value1;

    public static FunctionsAddition.PixelColor pixelColor =new FunctionsAddition.PixelColor();
    public static FunctionsAddition.PixelColor pixelColor1 =new FunctionsAddition.PixelColor();
    public static float[] myHSB资源;


    public static boolean t1Temp = false;
    public static boolean t1Temp1 = false;
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1Temp == true) {

                    if(是否基础技能) {

                        myHSB资源 = pixelColor.getPixelColor(rgbx,rgby);
                        if(myHSB资源[0]<value)
                        {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                            robot.mousePress(BUTTON1_DOWN_MASK);
                        }else {
                        }


                    }
                    robot.keyRelease(VK_5);
                    robot.keyPress(VK_5);

                    t1Temp1=true;

                } else {
                    if(t1Temp1==true){
                        robot.keyRelease(VK_5);
                        if(w或者左键==false) {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                        }
                        t1Temp1=false;
                    }
                }
                pause(baseDelay);
            }
        }
    };

    public static boolean t2Temp = false;
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t2Temp == true) {
                    robot.keyPress(VK_G);
                    robot.keyRelease(VK_G);
                }
                pause(baseDelay);

            }
        }
    };

    public static MyThread t3=new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (t1Temp == true ) {

                    if(pixelColor1.getPixelColor(804,982)[1]<0.47f)
                    {
                    }else {
                        robot.keyPress(KeyEvent.VK_6);
                        robot.keyRelease(KeyEvent.VK_6);
                    }

                    if(t3Temp==true) {
//                        robot.keyPress(VK_8);
//                        robot.keyRelease(VK_8);
                        robot.keyPress(VK_7);
                        robot.keyRelease(VK_7);

                    }
                } else {
                }
                pause(1000);

            }
        }
    };

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        t1Temp = false;
//        Functions公共.自动喝药=false;
        t2Temp = true;
    }
    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {

        w或者左键 = true;
        t1Temp = false;
        Functions公共.自动喝药=false;
        t2Temp = false;
    }
    @ListenMouseKeyboard(value = 514,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }


    @ListenMouseKeyboard(note = "e",value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        rgby=rgby2;
        value=value2;

        t1Temp = true;
        t2Temp = false;
        Functions公共.自动喝药=true;
        Functions公共.t1.myResume();


    }
    @ListenMouseKeyboard(note = "e",value = 69,press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
        rgby=rgby1;
        value=value1;

        t1Temp = true;
        t2Temp = false;
    }

    @ListenMouseKeyboard(note = "右键",value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否基础技能=false;

    }

    @ListenMouseKeyboard(note = "右键",value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能=true;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse =     ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard )
    public static void 侧键_f() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp = false;
    }




    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;
        if (t1Temp == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1Temp = false;
    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
        }
        右键或者1234在t1运行时按下 = false;
    }

    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        t1Temp = true;
        t2Temp = false;
    }







//    @ListenMouseKeyboard(note="space",value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "alt",value = 164, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格() {
        t3Temp=true;
    }

//    @ListenMouseKeyboard(note="space",value = 32,press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "alt",value = 164,press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格1() {
        t3Temp=false;
    }



    public static boolean t捡东西B = false;


        public static MyThread t捡东西=new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.keyRelease(VK_V);
                        robot.keyPress(VK_V);
                        t捡东西B =true;
                    } else {

                        if(t捡东西B ==true){
                            robot.keyRelease(VK_V);
                            t捡东西B =false;
                        }

                    }
                    pause(baseDelay);

                }
            }
        };






    public static MyThread t4= new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if(筛选装备.是否标记 ==true){
                    筛选装备.run1();
                }else if(筛选装备.是否扫描和筛选 ==true){
                    筛选装备.run(robot,筛选装备_游侠);
                }

                this.mySuspend();
            }
        }
    };
    @ListenMouseKeyboard(note = "f1",value = 112, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.标记起点();
    }
    @ListenMouseKeyboard(note = "f2",value = 113, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 图像识别_装备1() {
        筛选装备.是否扫描和筛选 = true;
        筛选装备.是否标记 = false;
        t4.myResume();
    }
    @ListenMouseKeyboard(note = "f3",value = 114, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备2() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = true;
        t4.myResume();
    }
    @ListenMouseKeyboard(note = "f4",value = 115, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = false;
    }


}
