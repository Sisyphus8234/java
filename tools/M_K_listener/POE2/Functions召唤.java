package custom;

import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;


public class Functions召唤 extends IFunctions {

	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "home";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "end";



	public static final String run="run";
	static {
//		CommonUtil.customConditionSet.add(run);
	}
	@ListenMouseKeyboard(key = "v",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "v", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 开(InputInfo inputInfo) {
		CommonUtil.customConditionSet.add(run);
		threadPressOrRelease(VK_W,false,true);
	}

	@ListenMouseKeyboard(key = "c",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "c", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 关(InputInfo inputInfo) {
		CommonUtil.customConditionSet.remove(run);
		threadPressOrRelease(VK_W,false,false);
	}



	public static MyThread 自动 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(CommonUtil.customConditionSet.contains(run)&&!CommonUtil.customConditionSet.contains(gl)){
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
//		threadPressOrRelease(VK_W,false,false);

//		CommonUtil.customConditionSet.remove(gl);
//		threadPressOrRelease(VK_0,false,false);

		threadPressOrRelease(VK_1,false,true);
		threadPressOrRelease(VK_1,false,false);
	}


//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	public static void 移动(){
		CommonUtil.customConditionSet.remove(右键按下);
//		threadPressOrRelease(VK_W,false,true);
	}

	public static String gl="gl";

	@ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	public static void aaa(){

//		robot.keyRelease(VK_0);

		queue1.clear();
		if (CommonUtil.customConditionSet.contains(gl)) {
			queue1.add(new ArrayList<>(Arrays.asList(VK_T, LocalDateTime.now().plus(Duration.ofMillis(1200L)))));
		} else {
			queue1.add(new ArrayList<>(Arrays.asList(VK_T, LocalDateTime.now().plus(Duration.ofMillis(600L)))));
			queue1.add(new ArrayList<>(Arrays.asList(VK_0, null)));
		}

		CommonUtil.customConditionSet.add(gl);

	}

	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run)
	public static void 滚轮(InputInfo inputInfo) {
		CommonUtil.customConditionSet.remove(gl);
		queue1.clear();
		threadPressOrRelease(VK_T,false,false);
		threadPressOrRelease(VK_0,false,false);



	}


	public static BlockingQueue<List<Object>> queue1 = new LinkedBlockingQueue<>() {
    };
	public static MyThread t自动技能 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {//---
				try {
					List<Object> temp = queue1.take();
					robot.keyRelease((int)temp.get(0));
					robot.keyPress((int)temp.get(0));
					if(temp.get(1)!=null) {
						while (LocalDateTime.now().compareTo((LocalDateTime) temp.get(1)) <= 0) {

						}
						robot.keyRelease((int) temp.get(0));
					}
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
	};




}