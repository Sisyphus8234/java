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

	public static boolean temp1 =true;

//	static {
//
//		new Thread() {
//		@Override
//		public void run() {
//			while (true) {
//
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				if (space == true) {
//					System.out.println("按下space");
//					robot.keyPress(KeyEvent.VK_SPACE);
//				}
//			}
//
//		}
//	}.start();
//	}


	@ListenMouseKeyboard(value=32)
	private static void sample1() {
		if(temp1==true){
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_L);
		temp1=false;}
		}

	@ListenMouseKeyboard(value=32,press = false)
	private static void sample2() {
		temp1=true;
	}

}
