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

	public static boolean space =false;

	static {

		new Thread() {
		@Override
		public void run() {
			while (true) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (space == true) {
					System.out.println("按下space");
					robot.keyPress(KeyEvent.VK_SPACE);
				}
			}

		}
	}.start();
	}


	@ListenMouseKeyboard(value=522)
	private static void sample1() {
		space=true;
		}

	@ListenMouseKeyboard(value=32)
	private static void sample2() {
		space=false;
//		robot.keyRelease(KeyEvent.VK_SPACE);
//		robot.keyPress(KeyEvent.VK_SPACE);
	}

}
