package custom;

import addition.PixelColor;
import base.*;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "home";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "end";



	public static final String run="run";
	static {
//		CommonUtil.customConditionSet.add(run);
	}

	public static final String 滚轮 ="b1up";
	public static final String 右键按下 ="b1up";

	@ListenMouseKeyboard(intercept = true,key = "x",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(intercept = true,key = "x", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "c",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "c", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "b", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "u",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "u", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "i",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "i", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(key = "esc", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 关(InputInfo inputInfo) {
		CommonUtil.customConditionSet.remove(run);

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


	@ListenMouseKeyboard(key = "f7",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(userInput = false,key = "f7",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 读取颜色0(InputInfo inputInfo) {
		PixelColor.读取颜色(0);

	}

	@ListenMouseKeyboard(key = "f8",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(userInput = false,key = "f8",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 读取颜色1(InputInfo inputInfo) {

		PixelColor.读取颜色(1);
	}


	@ListenMouseKeyboard(key = "f9",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	@ListenMouseKeyboard(userInput = false,key = "f9",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
	public static void 读取颜色2(InputInfo inputInfo) {

		PixelColor.读取颜色1();
	}


}