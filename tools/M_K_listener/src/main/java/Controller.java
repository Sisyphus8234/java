import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller {

	public static Map<String, Utiliy> mapJna=new HashMap<String,Utiliy>();
	public static Map<String, Utiliy> mapJintellitype=new HashMap<String,Utiliy>();
	
	public static long refreshtime=3000;

	public static Do do1=new Do(refreshtime);
	
	public Controller(Class class1) {
		
		MyJFrame.run();

		ScanFunction.run(class1,mapJna,mapJintellitype);

		//mouse
		new Thread() {
			@Override
			public void run() {
            
			MouseHook mouseHook =new MouseHook();
			mouseHook.run();
            
            }}.start();
            
            
        //keyboard    
        new Thread() {
            @Override
    		public void run() {            
            
            KeyboardHook keyboardHook=new KeyboardHook();
            keyboardHook.run();
                
        }}.start();

		//Jintellitype
		new Thread() {
			@Override
			public void run() {

				JintellitypeRegisterAndListener jintellitypeRegisterAndListener =new JintellitypeRegisterAndListener();
				jintellitypeRegisterAndListener.run();

			}}.start();
        
	}

}
