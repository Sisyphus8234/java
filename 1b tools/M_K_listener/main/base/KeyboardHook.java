package base;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;

import com.sun.jna.platform.win32.WinUser.MSG;

 
/** Sample implementation of a low-level keyboard hook on W32. */
public class KeyboardHook {

	
	private HHOOK hhk;
	private LowLevelKeyboardProc keyboardHook;
	
	
	public void run() {
		
		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		
		keyboardHook = new LowLevelKeyboardProc() {
			@Override
			public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT info) {

				if (nCode==0) {



//					if(info.flags==16 || info.flags==144) {System.out.print("(由程序执行的)");}
					if(info.flags!=0 && info.flags!=128) {System.out.print("(由程序执行的)");}
					System.out.println("键盘键"+info.vkCode);

					//开关相关
					if(Controller.mapListenBar.containsKey(info.vkCode)){
						System.out.println(Controller.mapListenBar.get(info.vkCode));
						if(Controller.mapListenBar.get(info.vkCode).equals("off")){
							for(MyThread thread:Controller.threadList){
								thread.mySuspend();
							}
							Controller.listehSwitch=false;
						}else if(Controller.mapListenBar.get(info.vkCode).equals("on")){
							for(MyThread thread:Controller.threadList){
								if(thread.defaultState.equals("on")){
									thread.myResume();
								}
							}
							Controller.listehSwitch=true;
						}
					}
					if(Controller.listehSwitch==false){
						return null;
					}


					String userInput="userInput";
//					if(info.flags==16 || info.flags==144){
					if(info.flags!=0 && info.flags!=128){
						userInput="!userInput";
					}
//					String inputCode=info.vkCode+"_"+wParam.intValue()+"_"+userInput;
					InputInfo inputInfo =new InputInfo();
					inputInfo.value=info.vkCode;
					inputInfo.press=wParam.intValue();
					inputInfo.userInput=userInput;

					if(Controller.mapJna.containsKey(inputInfo)){
						Utiliy utiliy1=Controller.mapJna.get(inputInfo);
						Controller.do1.task(utiliy1);
						if(utiliy1.intercept==true){
							return new LRESULT(1);
						}
					}
				}


				Pointer ptr = info.getPointer();
				long peer = Pointer.nativeValue(ptr);
				return lib.CallNextHookEx(hhk, nCode, wParam, new LPARAM(peer));
			}
		};

		hhk = lib.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, keyboardHook, hMod, 0);



		// This bit never returns from GetMessage
		MSG msg = new MSG();
		lib.GetMessage(msg, null, 0, 0);

		System.out.println("base.KeyboardHook run 方法结束");
	}

	
	
}