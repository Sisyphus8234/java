package custom;

import base.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {

	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "f1";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "f2";


	public static boolean b0=false;
	public static MyThread t按住右键时 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true){
				if(b0==true){
//					robot.keyPress(VK_W);
					robot.keyPress(VK_T);
					robot.keyRelease(VK_T);
				}

				pause(200L);
			}
		}
	};




	public static String b1up="b1up";


	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!b1up")
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!b1up")
	public static void 移动1(){
		threadPressOrRelease(VK_W,false,false);
b0=true;

		CommonUtil.customConditionSet.add(b1up);

	}


//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
	public static void 移动(){
		threadPressOrRelease(VK_W,false,true);
		b0=false;


		CommonUtil.customConditionSet.remove("b1up");
	}

	@ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
	@ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
	public static void aaa(){
		queue1.clear();
		queue1.add(new ArrayList<>(Arrays.asList(VK_Q,5)));
	}


	public static BlockingQueue<List<Integer>> queue1 = new LinkedBlockingQueue<>() {
    };
	public static MyThread t自动技能 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {//---
				try {
					List<Integer> temp = queue1.take();
					for (int i = 1; i <= temp.get(1); i++) {
						robot.keyPress(temp.get(0));
//						pause(50);
						robot.keyRelease(temp.get(0));
						pause(100L);
					}//---
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
	};



	//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
//	public static void 滚轮(InputInfo inputInfo) {
//		robot.keyPress(VK_0);
//		robot.keyRelease(VK_0);
//	}
//
//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
	public static void 滚轮1(InputInfo inputInfo) {

		robot.keyPress(VK_0);
		robot.keyRelease(VK_0);
	}

}