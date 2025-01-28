package custom;

import addition.PixelColor;
import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;

import static addition.PixelColor.getPixelColorHSB;
import static base.CommonUtil.customConditionSet;
import static java.awt.event.KeyEvent.*;

public class Functions召唤0 extends Functions公共 {

    static {
        初始化set.add(回蓝开启);
//		初始化set.add(回血开启);
        初始化set.add(start);
    }

    public static Point 回盾potin = new Point(171, 1064);
    public static MyThread 回盾 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (CommonUtil.customConditionSet.contains(start)) {

                    float[] temp = getPixelColorHSB(回盾potin.x, 回盾potin.y);
                    if (temp[2] <= 0.18) {
                        robot.keyPress(VK_1);
                        robot.keyRelease(VK_1);
                        pause(300L);
                    }
                }
                pause(300L);

            }
        }
    };


    public static Point 怒炎 = new Point(1773, 1000);
    public static Point 怒炎1 = new Point(1800, 940);


    public static MyThread 自动左键 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (customConditionSet.contains(start)) {

//                    pause(50L);
//

                    if (!customConditionSet.contains(滚轮)) {
                        robot.mousePress(BUTTON1_DOWN_MASK);
                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                    }


                    if (customConditionSet.contains(右键按下)) {
                        robot.keyPress(VK_Q);
                        robot.keyRelease(VK_Q);
                        pause(800L);
                        robot.keyPress(VK_E);
                        robot.keyRelease(VK_E);
                        pause(800L);

                    }

                    robot.keyRelease(VK_PAGE_DOWN);
                    robot.keyPress(VK_PAGE_DOWN);

                    pause(150L);
                }

            }
        }
    };


    public static MyThread t滚轮 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

//            LocalDateTime temp = LocalDateTime.now();
//            int temp1 = VK_F;
//            boolean temp2 = false;
            while (true) {

                if (this.checkBlock() == false) {
                    myKeyRelease(VK_F);
                    myKeyRelease(VK_6);
//                    temp2=true;
                }

                this.getBlock();


//                if (LocalDateTime.now().compareTo(temp) > 0 && PixelColor.getPixelColorHSB(怒炎.x, 怒炎.y)[2] <= 0.21F) {
//                    myKeyPress(VK_T);
//                    myKeyRelease(VK_T);
//                    temp = LocalDateTime.now().plus(Duration.ofMillis(1000L));
//                }

//				if (PixelColor.getPixelColorHSB(怒炎1.x, 怒炎1.y)[1] >= 0.62F) {
//					myKeyPress(VK_6);
//
//
//					myKeyRelease(VK_F);
//
//				}else {
////					myKeyPress(VK_R);
////					myKeyRelease(VK_R);
//
//					myKeyPress(VK_F);
//
//
//					myKeyRelease(VK_6);
//
//
//
//				}


//
//                if(LocalDateTime.now().isAfter(temp)) {
//                    pause(300L);
//                    myKeyPress(VK_6);
//
//                    myKeyRelease(VK_6);
//
//                    temp = LocalDateTime.now().plus(Duration.ofMillis(6500));
//                }else {

                if(basePoint.distance(getPointFix())<150){
                    myKeyPress(VK_6);

                    myKeyRelease(VK_6);
                    pause(300L);
                }else {

                }
                myKeyPress(VK_F);
//                }


                pause(300L);
            }
        }
    };


    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮下() {

        wasd = 2;

        customConditionSet.add(滚轮);

        t滚轮.nonBlock();


//		threadPressOrRelease(
//
//		_DOWN_MASK, true, true);
//		threadPressOrRelease(BUTTON2_DOWN_MASK, true, false);
//
//		if(PixelColor.getPixelColorHSB(怒炎.x, 怒炎.y)[2]<=0.21F){
//			threadPressOrRelease(VK_R, false, true);
//			threadPressOrReleaseWithDelay(VK_R, false, false,300);
//		}
//
//
//
//		threadPressOrRelease(VK_F, false, true);


    }


    @ListenMouseKeyboard(key = "滚轮", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮上(InputInfo inputInfo) {



        if (!customConditionSet.contains(滚轮)) {
            threadPressOrReleaseWithDelay(VK_0, false, true, 0);
            threadPressOrReleaseWithDelay(VK_0, false, false, 200);

            threadPressOrReleaseWithDelay(VK_SPACE, false, true, 0);
            threadPressOrReleaseWithDelay(VK_SPACE, false, false, 0);

            threadPressOrReleaseWithDelay(VK_9, false, true, 0);
            threadPressOrReleaseWithDelay(VK_9, false, false, 0);


        } else {
            customConditionSet.remove(滚轮);
            t滚轮.block();

            if (customConditionSet.contains(右键按下)) {
                wasd = 1;
            } else {
//				threadPressOrRelease(VK_F, false, false);
//				threadPressOrRelease(VK_R, false, false);
                wasd = 0;
            }
            threadPressOrRelease(VK_F, false, false);
            threadPressOrRelease(VK_T, false, false);
        }
    }


//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start+",!"+滚轮,timeInterval = 800L)
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start+",!"+滚轮,timeInterval = 800L)
//	public static void 滚轮上1(){
//
//
//		CommonUtil.customConditionSet.remove(滚轮);
//	}


    //	@ListenMouseKeyboard(intercept = true,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
//	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
    public static void aaa() {

        threadPressOrRelease(VK_F, false, true);
        wasd = 1;
        customConditionSet.add(右键按下);
    }


    //	@ListenMouseKeyboard(intercept = true,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
//	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
    public static void 滚轮(InputInfo inputInfo) {


        if (customConditionSet.contains(滚轮)) {
            wasd = 2;
        } else {
            threadPressOrRelease(VK_F, false, false);
            wasd = 0;
        }


        customConditionSet.remove(右键按下);

    }


    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + 右键按下 + "," + start)
    @ListenMouseKeyboard(userInput = false, key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + 右键按下 + "," + start)
    public static void 右键() {
        customConditionSet.add(右键按下);
//		threadPressOrRelease(VK_1,false,true);
//		threadPressOrRelease(VK_1,false,false);
//		threadPressOrRelease(VK_Q,false,true);
//		threadPressOrRelease(VK_Q,false,false);
//		threadPressOrRelease(VK_E,false,true);
//		threadPressOrRelease(VK_E,false,false);

//		threadPressOrRelease(VK_Q,false,true);
//		threadPressOrRelease(VK_E,false,true);

    }


    //
    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = 右键按下 + "," + start)
    @ListenMouseKeyboard(userInput = false, key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = 右键按下 + "," + start)
    public static void 右键1() {
        customConditionSet.remove(右键按下);
//		threadPressOrRelease(VK_Q,false,false);
//		threadPressOrRelease(VK_E,false,false);

    }


}