package custom;

import base.*;

import static java.awt.event.KeyEvent.*;


public class Functions召唤 extends Functions公共 {


	@ListenMouseKeyboard(intercept = true,key = "v",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(intercept = true,key = "v", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 开(InputInfo inputInfo) {
		CommonUtil.customConditionSet.add(start);
//		threadPressOrRelease(VK_W,false,true);
	}





	public static MyThread 自动 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(CommonUtil.customConditionSet.contains(start)&&!CommonUtil.customConditionSet.contains(滚轮)){
					robot.mousePress(BUTTON1_DOWN_MASK);
					robot.mouseRelease(BUTTON1_DOWN_MASK);
					pause(200L);
				}else {

				}
			}
		}
	};





	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+ start)
	public static void 移动1(){
		CommonUtil.customConditionSet.add(右键按下);
		threadPressOrRelease(VK_1,false,true);
		threadPressOrRelease(VK_1,false,false);
		threadPressOrRelease(VK_2,false,true);
		threadPressOrRelease(VK_2,false,false);
	}


//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(press = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+ start)
	@ListenMouseKeyboard(press = false,userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+ start)
	public static void 移动(){
		CommonUtil.customConditionSet.remove(右键按下);
	}




	@ListenMouseKeyboard(immediately = false,key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = start,timeInterval = 600L)
	@ListenMouseKeyboard(immediately = false,key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = start,timeInterval = 600L)
	public static void aaa(){

		if (CommonUtil.customConditionSet.contains(滚轮)) {
//			robot.keyRelease(VK_T);
//			robot.keyPress(VK_0);
//			pause(800L);
//			robot.keyRelease(VK_0);
//			robot.keyPress(VK_T);

			threadPressOrRelease(VK_T,false,true);
			threadPressOrRelease(VK_0,false,false);
			pause(1400L);
			threadPressOrRelease(VK_0,false,true);
		} else {
			threadPressOrRelease(VK_T,false,true);
			pause(500L);
			threadPressOrRelease(VK_0,false,true);
		}
		CommonUtil.customConditionSet.add(滚轮);

	}


	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start,timeInterval = 1000L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = start,timeInterval = 1000L)
	public static void 滚轮(InputInfo inputInfo) {
		if(!CommonUtil.customConditionSet.contains(滚轮)){
			threadPressOrRelease(VK_Q,false,true);
			threadPressOrRelease(VK_Q,false,false);
		}else {
			Do.taskInfoList.clear();
			threadPressOrRelease(VK_T,false,false);
			threadPressOrRelease(VK_0,false,false);
		}
		CommonUtil.customConditionSet.remove(滚轮);

	}

}