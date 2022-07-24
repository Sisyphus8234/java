import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Functions extends IFunctions{

	
	@ListenMouseKeyboard(value=516,immediately=true)
	private static void DBD1() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SHIFT);

		}

	@ListenMouseKeyboard(value=71,immediately=true)
	private static void DBD2() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyPress(KeyEvent.VK_F);	}

	@ListenMouseKeyboard(value=160,immediately=true,userInput = false)
	@ListenMouseKeyboard(value=160,immediately=true)
	private static void DBD3() {
		robot.keyRelease(KeyEvent.VK_F);
		}

	@ListenMouseKeyboard(value=70,immediately=true,userInput = false)
	@ListenMouseKeyboard(value=70,immediately=true)
	private static void DBD4() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_SHIFT);
		}

}
