package custom;

import base.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;

public class Functions佣兵 extends IFunctions {

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
//		threadPressOrRelease(VK_W,false,true);
	}

	@ListenMouseKeyboard(key = "c",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "c", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 关(InputInfo inputInfo) {
		CommonUtil.customConditionSet.remove(run);
//		threadPressOrRelease(VK_W,false,false);

		robot.keyRelease(VK_A);
		robot.keyRelease(VK_W);
		robot.keyRelease(VK_D);
		robot.keyRelease(VK_S);
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
				pause(100L);

			}
		}
	};

	public static MyThread 自动中键 = new MyThread(MyThread.State.on) {
		@Override
		public void run() {
			while (true) {
				if(CommonUtil.customConditionSet.contains(run)&&!CommonUtil.customConditionSet.contains(滚轮)){
					robot.mousePress(BUTTON1_DOWN_MASK);
					robot.mouseRelease(BUTTON1_DOWN_MASK);
					pause(200L);

				}else {

				}
			}
		}
	};





	public static final String 滚轮 ="b1up";

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



		if(CommonUtil.customConditionSet.contains(右键)){
			wasd=1;
		}else {
			threadPressOrRelease(VK_F,false,false);
			wasd=0;
		}


	}



	public static String 右键 ="gl";
	@ListenMouseKeyboard(intercept = true,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键按下",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	public static void aaa(){

		threadPressOrRelease(VK_F,false,true);
		wasd=1;
		CommonUtil.customConditionSet.add(右键);
	}



	@ListenMouseKeyboard(intercept = true,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	@ListenMouseKeyboard(intercept = true,userInput = false,key = "右键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = run)
	public static void 滚轮(InputInfo inputInfo) {


		CommonUtil.customConditionSet.remove(右键);

		if(CommonUtil.customConditionSet.contains(滚轮)){
			wasd=2;
		}else {
			threadPressOrRelease(VK_F,false,false);
			wasd=0;
		}

	}


	public static int wasd=0;
	public static void calculateAngle(Point a, Point b) {
		// 计算向量 (a.x - b.x, a.y - b.y)
		double deltaX = a.x - b.x;
		double deltaY = a.y - b.y;

		// 使用 atan2 计算角度，atan2 返回的是弧度值
		double angleInRadians = Math.atan2(deltaY, deltaX);

		// 将弧度转换为度数
		double angleInDegrees = Math.toDegrees(angleInRadians);

		// 如果需要让角度范围是 [0, 360)，可以进行如下调整：
		if (angleInDegrees < 0) {
			angleInDegrees += 360;
		}


		if(wasd==1){
			robot.keyRelease(VK_A);
			robot.keyRelease(VK_W);
			robot.keyRelease(VK_D);
			robot.keyRelease(VK_S);
			return;
		}

		if (wasd == 2) {
			angleInDegrees = angleInDegrees + 180;
			if (angleInDegrees > 360) {
				angleInDegrees = angleInDegrees - 360;
			}
		}

		// 计算区间编号
		int direction = (int)((angleInDegrees + 22.5) / 45) % 8;

		switch (direction) {
			case 0: // -22.5 到 22.5 (左)
				robot.keyPress(VK_A);
				robot.keyRelease(VK_W);
				robot.keyRelease(VK_D);
				robot.keyRelease(VK_S);
				break;
			case 1: // 22.5 到 67.5 (左前)
				robot.keyPress(VK_A);
				robot.keyPress(VK_W);
				robot.keyRelease(VK_D);
				robot.keyRelease(VK_S);
				break;
			case 2: // 67.5 到 112.5 (前)
				robot.keyRelease(VK_A);
				robot.keyPress(VK_W);
				robot.keyRelease(VK_D);
				robot.keyRelease(VK_S);
				break;
			case 3: // 112.5 到 157.5 (右前)
				robot.keyRelease(VK_A);
				robot.keyPress(VK_W);
				robot.keyPress(VK_D);
				robot.keyRelease(VK_S);
				break;
			case 4: // 157.5 到 202.5 (右)
				robot.keyRelease(VK_A);
				robot.keyRelease(VK_W);
				robot.keyPress(VK_D);
				robot.keyRelease(VK_S);
				break;
			case 5: // 202.5 到 247.5 (右后)
				robot.keyRelease(VK_A);
				robot.keyRelease(VK_W);
				robot.keyPress(VK_D);
				robot.keyPress(VK_S);
				break;
			case 6: // 247.5 到 292.5 (后)
				robot.keyRelease(VK_A);
				robot.keyRelease(VK_W);
				robot.keyRelease(VK_D);
				robot.keyPress(VK_S);
				break;
			case 7: // 292.5 到 337.5 (左后)
				robot.keyPress(VK_A);
				robot.keyRelease(VK_W);
				robot.keyRelease(VK_D);
				robot.keyPress(VK_S);
				break;
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






}