import com.melloware.jintellitype.JIntellitype;

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
	public static boolean temp2 =false;

	static {

		new Thread() {
		@Override
		public void run() {
			while (true) {

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (temp2 == true) {

					robot.keyRelease(KeyEvent.VK_E);
					robot.keyPress(KeyEvent.VK_E);
				}
			}

		}
	}.start();
	}


	@ListenMouseKeyboard(value=32)
	private static void space() {
		if(temp1==true){
		robot.keyRelease((int)'L');
		robot.keyPress((int)'L');
		temp1=false;
		}
	}
	@ListenMouseKeyboard(value=32,press = false)
	private static void space2() {
		temp1=true;
	}



	//拾取物品
	@ListenMouseKeyboard(value = 69)
	private static void e(){
		temp2=true;
	}
	@ListenMouseKeyboard(value = 69,press = false)
	private static void e2(){
		temp2=false;
	}


}