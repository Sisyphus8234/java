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

import static base.Controller.printKey;


/** Sample implementation of a low-level keyboard hook on W32. */
public class KeyboardHook {
	private HHOOK hhk;
	private LowLevelKeyboardProc keyboardHook;
	private InputInfo inputInfo =new InputInfo();
	private Utiliy utiliy =new Utiliy();
	private StringBuilder printText=new StringBuilder();

	public void run() {

		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);

		keyboardHook = new LowLevelKeyboardProc() {
			@Override
			public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT info) {

				if (nCode==0) {


					if(printKey==true) {
						if (info.flags == 0 || info.flags == 1 || info.flags == 32 || info.flags == 128 || info.flags == 129) {
						} else {
							printText.append("由程序执行的");
						}
						printText.append("\n").append("键盘键").append(info.vkCode);
						printText.append("\n").append("info.flags").append(info.flags);
						System.out.println(printText);
					}


					//开关相关
					if(Controller.mapListenBar.containsKey(info.vkCode)){
						System.out.println(Controller.mapListenBar.get(info.vkCode));
						if(Controller.mapListenBar.get(info.vkCode).equals(ListenBar.OnOrOff.off)){
							for(MyThread thread:Controller.threadList){
								thread.mySuspend();
							}
							Controller.listenSwitch =false;
						}else if(Controller.mapListenBar.get(info.vkCode).equals(ListenBar.OnOrOff.on)){
							for(MyThread thread:Controller.threadList){
								if(thread.defaultState==MyThread.State.on){
									thread.myResume();
								}
							}
							Controller.listenSwitch =true;
						}
					}
					if(Controller.listenSwitch ==false){
						return null;
					}

					inputInfo.resetProperty();
					inputInfo.value=info.vkCode;

//					if(info.flags==16 || info.flags==144){
					if(info.flags==0 ||info.flags==1||info.flags==32|| info.flags==128||info.flags==129){
						inputInfo.userInput=true;
					}else {
						inputInfo.userInput=false;
					}
					if(wParam.intValue()==256){
						inputInfo.press=true;
					}else {
						inputInfo.press=false;
					}

					if(Controller.mapJna.containsKey(inputInfo)){
						utiliy =Controller.mapJna.get(inputInfo);
						Controller.do1.task(utiliy);
						if(utiliy.intercept==true){
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