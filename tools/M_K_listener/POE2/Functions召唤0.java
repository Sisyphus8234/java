package custom;

import addition.PixelColor;
import base.*;

import java.awt.*;

import static base.CommonUtil.customConditionSet;
import static java.awt.event.KeyEvent.*;

public class Functions召唤0 extends Functions公共 {

	@ListenMouseKeyboard(intercept = true,key = "v",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(intercept = true,key = "v", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 开(InputInfo inputInfo) {
		customConditionSet.add(start);
	}


	public static Point basePoint =new Point(957,495);
	public static Point 怒炎 =new Point(1773,1000);

	public static boolean b =false;
	public static MyThread t移动 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(customConditionSet.contains(start)){


					Point temp=getPointFix();
					calculateAngle(basePoint,temp);



				}
				pause(150L);

			}
		}
	};

	public static MyThread 自动左键 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {



				if(customConditionSet.contains(start)&&!customConditionSet.contains(滚轮)){

					robot.mousePress(BUTTON1_DOWN_MASK);
					robot.mouseRelease(BUTTON1_DOWN_MASK);

				}else {

				}

				pause(150L);
			}
		}
	};







	@ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = start,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = start,timeInterval = 800L)
	public static void 滚轮下(){

		wasd = 2;
		if(PixelColor.getPixelColorHSB(怒炎.x, 怒炎.y)[2]<=0.21F){
			threadPressOrRelease(VK_R, false, true);
			threadPressOrReleaseWithDelay(VK_R, false, false,300);
		}
		threadPressOrRelease(VK_F, false, true);


		customConditionSet.add(滚轮);
	}




	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start,timeInterval = 800L)
	public static void 滚轮上(){
		if(customConditionSet.contains(滚轮)) {
			if (customConditionSet.contains(右键按下)) {
				wasd = 1;
			} else {
				threadPressOrRelease(VK_F, false, false);
				threadPressOrRelease(VK_R, false, false);
				wasd = 0;
			}
		}else {
//			robot.keyPress(VK_BACK_QUOTE);
//			robot.keyRelease(VK_BACK_QUOTE);
//
//			robot.keyPress(VK_SHIFT);
//			robot.keyRelease(VK_SHIFT);

			robot.keyPress(VK_R);
			robot.keyRelease(VK_R);
		}

		customConditionSet.remove(滚轮);
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
	public static void aaa(){

		threadPressOrRelease(VK_F,false,true);
		wasd=1;
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


	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+ start)
	public static void 右键(){
		customConditionSet.add(右键按下);
		threadPressOrRelease(VK_1,false,true);
		threadPressOrRelease(VK_1,false,false);
		threadPressOrRelease(VK_2,false,true);
		threadPressOrRelease(VK_2,false,false);
		threadPressOrRelease(VK_Q,false,true);
		threadPressOrRelease(VK_Q,false,false);
	}


	//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(press = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(press = false,userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+ start)
	public static void 右键1(){
		customConditionSet.remove(右键按下);
	}






}