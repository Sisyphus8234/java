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

	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
	public static void 滚轮(InputInfo inputInfo) {
		robot.keyPress(VK_CONTROL);
		robot.keyPress(VK_Q);
		robot.keyRelease(VK_Q);
		robot.keyRelease(VK_CONTROL);
	}

	@ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
	@ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
	public static void 滚轮1(InputInfo inputInfo) {
		//---

		robot.keyPress(VK_CONTROL);
		robot.keyPress(VK_E);
		pause(100);
		robot.keyRelease(VK_E);
		robot.keyRelease(VK_CONTROL);
	}


}