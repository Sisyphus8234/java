import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;

public class Functions {
	
	public static Robot robot;
	public static boolean handgan_knife =false;
	public static boolean leftbuttom =false;

	static {

		System.out.println("Functions类加载");

		try {
			robot=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Robot创建完成");

		new Thread() {
			@Override
			public void run() {

				while (true){

					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if(handgan_knife &&leftbuttom){

						System.out.println("连点");
						robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

					}
				}

			}}.start();
	}


	@ListenMouseKeyboard(value=69,immediately=true)
	@ListenMouseKeyboard(value=50,immediately=true)
	private static void KF2_1() {
		// TODO Auto-generated method stub
		handgan_knife =true;
	}

	@ListenMouseKeyboard(value=81,immediately=true)
	private static void KF2_2() {
		// TODO Auto-generated method stub
		handgan_knife =false;
		leftbuttom =false;
	}

	@ListenMouseKeyboard(value=69,immediately=true)
	@ListenMouseKeyboard(value=513,immediately=true)
	private static void KF2_3() {
		// TODO Auto-generated method stub
		leftbuttom =true;
	}

	@ListenMouseKeyboard(value=514,immediately=true)
	private static void KF2_4() {
		// TODO Auto-generated method stub
		leftbuttom =false;
	}






}
