import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions {

	public static boolean Jna=true;

	public static boolean jintellitype=false;
	
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


	

	//按下鼠标左键触发
	@ListenMouseKeyboard(value=513,immediately=true)
	private static void sample1() {
		System.out.println("程序模拟键盘依次按下h，i");
		// TODO Auto-generated method stub
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);

		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);


		}


	//按下键盘空格键触发
	@ListenMouseKeyboard(value=32,immediately=true)
	private static void sample2() {
		// TODO Auto-generated method stub
		System.out.println("程序模拟鼠标右键一次");
		robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);

	}
	
	//按下键盘空格键触发
	@JintellitypeListen(identifier =1,modifier = 0,keycode = 32)
	private static void sample3() {
		// TODO Auto-generated method stub
		System.out.println("Jintellitype监听到了空格");
	}

}
