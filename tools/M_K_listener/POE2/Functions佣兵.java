package custom;

import base.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;

public class Functions佣兵 extends Functions公共 {

	@ListenMouseKeyboard(key = "v",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "v", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 开(InputInfo inputInfo) {
		CommonUtil.customConditionSet.add(run);
	}


	public static Point basePoint =new Point(960,473);

	public static boolean b =false;
	public static MyThread t移动 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(CommonUtil.customConditionSet.contains(run)){


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



				if(CommonUtil.customConditionSet.contains(run)&&!CommonUtil.customConditionSet.contains(滚轮)){

					robot.mousePress(BUTTON1_DOWN_MASK);
					robot.mouseRelease(BUTTON1_DOWN_MASK);

				}else {

				}

				pause(200L);
			}
		}
	};







	@ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",customCondition = run,timeInterval = 800L)
	public static void 移动1(){
		CommonUtil.customConditionSet.add(滚轮);

		threadPressOrRelease(VK_F,false,true);

		wasd=2;
	}




	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run,timeInterval = 800L)
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",customCondition = run,timeInterval = 800L)
	public static void 移动(){
		CommonUtil.customConditionSet.remove(滚轮);

		if(CommonUtil.customConditionSet.contains(右键按下)){
			wasd=1;
		}else {
			threadPressOrRelease(VK_F,false,false);
			wasd=0;
		}

	}




//	@ListenMouseKeyboard(intercept = true,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
//	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	public static void aaa(){

		threadPressOrRelease(VK_F,false,true);
		wasd=1;
		CommonUtil.customConditionSet.add(右键按下);
	}



//	@ListenMouseKeyboard(intercept = true,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
//	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	public static void 滚轮(InputInfo inputInfo) {


		CommonUtil.customConditionSet.remove(右键按下);

		if(CommonUtil.customConditionSet.contains(滚轮)){
			wasd=2;
		}else {
			threadPressOrRelease(VK_F,false,false);
			wasd=0;
		}

	}


	@ListenMouseKeyboard(key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+ 右键按下 +","+run)
	public static void 右键(){
		CommonUtil.customConditionSet.add(右键按下);
		threadPressOrRelease(VK_1,false,true);
		threadPressOrRelease(VK_1,false,false);
		threadPressOrRelease(VK_2,false,true);
		threadPressOrRelease(VK_2,false,false);
	}


	//
	@ListenMouseKeyboard(key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	@ListenMouseKeyboard(press = false,userInput = false,key = "e",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 右键按下 +","+run)
	public static void 右键1(){
		CommonUtil.customConditionSet.remove(右键按下);
	}






}