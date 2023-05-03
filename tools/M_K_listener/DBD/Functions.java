import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Functions extends IFunctions{

	@ListenBar(off = false)
	public static int on =36;

	@ListenBar()
	public static int off =35;

	@ListenBar(threadList=true)
	public static ArrayList<Thread> threadList=new ArrayList();

	public static Thread t1;
	public static boolean b1 =false;

	public static Config config=new Config();
	public static Long time1;




	static {

		time1= Long.valueOf(config.prop.getProperty("Time1"));

		t1=new CreateThread(		){
			public void myFunction() {
				while (true) {
					if(b1==true) {

						robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
						robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//						robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
						pause(time1);
					}else {
						t1.suspend();
					}
				}


			};
		}.thread;
		t1.suspend();
		threadList.add(t1);






	}


	@ListenMouseKeyboard(value=516,immediately=true)
	private static void 奔跑() {
		// TODO Auto-generated method stub
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SHIFT);
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

//	@ListenMouseKeyboard(value=192,immediately=true)
//	@ListenMouseKeyboard(value=191,immediately=true)
//	private static void 点血网() {
//		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//	}


	@ListenMouseKeyboard(value=191)
	private static void 点血网() {
		b1=true;
		t1.resume();
	}


	@ListenMouseKeyboard(value=190)
	private static void 点血网1() {
b1=false;
	}


	@ListenMouseKeyboard(value=84,immediately=true)
	private static void 能力键1_space() {
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_SPACE);
	}

	@ListenMouseKeyboard(value=48,immediately=true)
	private static void 属性1增加() {
		config.write("Time1", String.valueOf(time1+20));
		time1= Long.valueOf(config.prop.getProperty("Time1"));

	}

	@ListenMouseKeyboard(value=57,immediately=true)
	private static void 属性1减少() {
		config.write("Time1", String.valueOf(time1-20));
		time1= Long.valueOf(config.prop.getProperty("Time1"));
	}

}
