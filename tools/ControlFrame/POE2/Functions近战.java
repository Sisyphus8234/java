package custom;

import base.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;


public class Functions近战 extends IFunctions {

	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "home";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "end";



	public static final String run="run";
	static {
		CommonUtil.customConditionSet.add(run);
	}
	@ListenMouseKeyboard(key = "f",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "f", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 开(InputInfo inputInfo) {
		CommonUtil.customConditionSet.add(run);
		threadPressOrRelease(VK_W,false,true);
	}

	@ListenMouseKeyboard(key = "d",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "d", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 关(InputInfo inputInfo) {
		CommonUtil.customConditionSet.remove(run);
		threadPressOrRelease(VK_W,false,false);
	}



	public static boolean b =false;
	public static MyThread t按住右键时 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(b==true){
//					robot.mousePress(BUTTON1_DOWN_MASK);
//					pause(50L);
//					robot.mouseRelease(BUTTON1_DOWN_MASK);
					pause(200L);
				}else {
					this.mySuspend();
				}

			}
		}
	};

	public static MyThread 自动中键 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(getKeyStatus(VK_W)){
					robot.mousePress(BUTTON1_DOWN_MASK);
					robot.mouseRelease(BUTTON1_DOWN_MASK);
					pause(200L);

				}else {

				}
			}
		}
	};


	public static final String 右键按下 ="b1up";


	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+run)
	public static void 移动1(){
		CommonUtil.customConditionSet.add(右键按下);

		threadPressOrRelease(VK_W,false,false);


//		b=true;
//		t按住右键时.myResume();
	}


//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	public static void 移动(){
		CommonUtil.customConditionSet.remove(右键按下);

		threadPressOrRelease(VK_W,false,true);

		threadPressOrRelease(VK_T,false,false);
		threadPressOrRelease(VK_R,false,false);

//		b=false;
	}

	@ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	public static void aaa(){
		queue1.clear();
		if(CommonUtil.customConditionSet.contains(右键按下)){
//			threadPressOrRelease(VK_E,false,true);
			queue1.add(new ArrayList<>(Arrays.asList(VK_T, LocalDateTime.now().plus(Duration.ofMillis(1300L)))));
		}else {
			queue1.add(new ArrayList<>(Arrays.asList(VK_R, LocalDateTime.now().plus(Duration.ofMillis(500L)))));

		}
	}


	public static BlockingQueue<List<Object>> queue1 = new LinkedBlockingQueue<>() {
    };
	public static MyThread t自动技能 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {//---
				try {
					List<Object> temp = queue1.take();
					robot.keyPress((int)temp.get(0));
					while(LocalDateTime.now().compareTo((LocalDateTime)temp.get(1))<=0){

					}
					robot.keyRelease((int)temp.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
	};

//	@ListenMouseKeyboard(key = "左键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
//	@ListenMouseKeyboard(key = "左键按下", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
//	public static void 取消(InputInfo inputInfo) {
//		myKeyRelease(VK_W);
//
//	}




		@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run)
	public static void 滚轮(InputInfo inputInfo) {
			robot.keyPress(VK_1);
			robot.keyRelease(VK_1);
	}
//
//	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//	public static void 滚轮1(InputInfo inputInfo) {
//
//		robot.keyPress(VK_1);
//		robot.keyRelease(VK_1);
//	}

}