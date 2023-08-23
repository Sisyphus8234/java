package base;

import custom.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

	public static boolean listehSwitch=true;

	public static ArrayList<MyThread> threadList=new ArrayList<>();
	public static Map<InputInfo, Utiliy> mapJna=new HashMap<>();
	public static Map<String, Utiliy> mapJintellitype=new HashMap<>();
	public static Map<Integer, Integer> mapListenBar=new HashMap<>();
	
	public static long refreshtime=3000;

	public static Do do1=new Do(refreshtime);
	
	public Controller(Class myFunctionClass,Class baseFunctionClass) {
		
		MyJFrame.run();

		ScanFunction.run(myFunctionClass,baseFunctionClass);

		if(Functions.Jna==true) {
			//mouse
			new Thread() {
				@Override
				public void run() {

					MouseHook mouseHook = new MouseHook();
					mouseHook.run();

				}
			}.start();


			//keyboard
			new Thread() {
				@Override
				public void run() {

					KeyboardHook keyboardHook = new KeyboardHook();
					keyboardHook.run();

				}
			}.start();
		}

		if(Functions.jintellitype==true) {
			//Jintellitype
			new Thread() {
				@Override
				public void run() {

					JintellitypeRegisterAndListener jintellitypeRegisterAndListener = new JintellitypeRegisterAndListener();
					jintellitypeRegisterAndListener.run();

				}
			}.start();
		}
        
	}

}
