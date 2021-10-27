import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Functions {
	
	public static Robot robot;
	static {

		System.out.println("Functions类加载");

		try {
			robot=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Robot创建完成");
	}


	

	
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


}
