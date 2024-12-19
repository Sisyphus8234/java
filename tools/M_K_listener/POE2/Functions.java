package custom;

import base.*;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {

	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "home";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "end";

//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
//	public static void 滚轮(InputInfo inputInfo) {
//		robot.keyPress(VK_0);
//		robot.keyRelease(VK_0);
//	}
//
//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//	public static void 滚轮1(InputInfo inputInfo) {
//		//---
//
//		robot.keyPress(VK_9);
//		robot.keyRelease(VK_9);
//	}

	public static boolean b0=false;
	public static MyThread t移动 = new MyThread(MyThread.State.off) {
		@Override
		public void run() {
			while (true){
				if(b0==true){
					robot.mousePress(BUTTON1_DOWN_MASK);

				}else {
					robot.mouseRelease(BUTTON1_DOWN_MASK);

				}
//				pause(200L);
				this.mySuspend();
			}
		}
	};

	public static MyThread t自动技能 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true){
				if(CommonUtil.customConditionSet.contains(b1up)){


					robot.keyPress(VK_T);
					robot.keyRelease(VK_T);
				}
				pause(500L);
			}
		}
	};

	public static String b1up="b1up";



	@ListenMouseKeyboard(key = "e",customCondition = "!b1up",timeInterval = 200L)
	@ListenMouseKeyboard(key = "e",userInput = false,customCondition = "!b1up",timeInterval = 200L)
	@ListenMouseKeyboard(key = "c")
	@ListenMouseKeyboard(key = "c",userInput = false)
	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!b1up")
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!b1up")
	public static void 移动1(){

//		b0=false;
//		t移动.myResume();

//		robot.mouseRelease(BUTTON1_DOWN_MASK);

		threadPressOrRelease(BUTTON1_DOWN_MASK,true,false);

		CommonUtil.customConditionSet.add("b1up");

	}


	@ListenMouseKeyboard(key = "e", press = false)
	@ListenMouseKeyboard(key = "e",userInput = false, press = false)
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
	public static void 移动(){
//		b0=true;
//		t移动.myResume();
//		robot.mousePress(BUTTON1_DOWN_MASK);

		threadPressOrRelease(BUTTON1_DOWN_MASK,true,true);


		CommonUtil.customConditionSet.remove("b1up");


	}






}