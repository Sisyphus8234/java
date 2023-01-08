import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions{

	@ListenBar(off = false)
	public static int on =36;

	@ListenBar()
	public static int off =35;

	
	@ListenMouseKeyboard(value=516,immediately=true)
	private static void 奔跑() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_SPACE);
		// robot.keyRelease(KeyEvent.VK_F);
		}

	@ListenMouseKeyboard(value=71,immediately=true)
	private static void 修机() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyPress(KeyEvent.VK_F);	}

	// @ListenMouseKeyboard(value=160,immediately=true)
	// private static void 奔跑2() {
	// 	robot.keyRelease(KeyEvent.VK_F);
	// 	}

//	@ListenMouseKeyboard(value=70,immediately=true,userInput = false)
//	@ListenMouseKeyboard(value=70,immediately=true)
//	private static void 修机2() {
//		// TODO Auto-generated method stub
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		}

	@ListenMouseKeyboard(value=192,immediately=true)
	@ListenMouseKeyboard(value=191,immediately=true)
	private static void 点血网() {
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
	}


	@ListenMouseKeyboard(value=84,immediately=true)
	private static void 能力键1() {
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SHIFT);
	}

}
