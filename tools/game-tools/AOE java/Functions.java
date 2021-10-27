import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions {
	
	public static Robot robot;
	static {		
		try {
			robot=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void run(String s) {
		
		switch(s) {
		
		case "AOE":
			AOE();
			break;	

			}
	
		}
	


	
	public static void AOE(){
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int x =MouseInfo.getPointerInfo().getLocation().x;
		int y =MouseInfo.getPointerInfo().getLocation().y;
		
		robot.mouseMove(281, 641);
		
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		
		robot.mouseMove(x, y);

		}
	
	
	


}
