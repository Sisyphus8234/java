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
import com.sun.jna.platform.win32.WinUser.LowLevelMouseProc;
import com.sun.jna.platform.win32.WinUser.MSG;
import com.sun.jna.platform.win32.WinUser.MSLLHOOKSTRUCT;

import static base.Controller.printKey;


public class MouseHook {
	private HHOOK hhk;
	private LowLevelMouseProc mouseHook;
	private InputInfo inputInfo =new InputInfo();
	private MethodInfo methodInfo;
	private StringBuilder printText=new StringBuilder();

	public void run() {
		
		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		
		mouseHook = new LowLevelMouseProc() {



			@Override
			public LRESULT callback(int nCode, WPARAM wParam, MSLLHOOKSTRUCT info) {


				
				if(nCode==0 & wParam.intValue()!=512) {


					if(printKey==true) {
						printText.setLength(0);
						printText.append("--------------------").append("\n");
						if (info.flags==1) {
							printText.append("(not user input) ");
						}
						printText.append("MouseKey: ").append(wParam);
						printText.append("\n").append("info.flags ").append(info.flags);
						printText.append("\n").append("info.mouseData ").append(info.mouseData);
						System.out.println(printText);
					}


					//开关相关
					if(Controller.listenSwitch ==false){
						return null;
					}

//					InputInfo inputInfo =new InputInfo();
					inputInfo.resetProperty();
					inputInfo.value=wParam.intValue();
					inputInfo.mouseData=info.mouseData;


					if(info.flags==1){
						inputInfo.userInput=false;
					}else {
						inputInfo.userInput=true;
					}
					inputInfo.press=true;

					if(Controller.mapJna.containsKey(inputInfo)){
						methodInfo =Controller.mapJna.get(inputInfo);
						Controller.do1.task(methodInfo);
						if(methodInfo.intercept==true){
							return new LRESULT(1);
						}
					}
				}

				Pointer ptr = info.getPointer();
				long peer = Pointer.nativeValue(ptr);
				return lib.CallNextHookEx(hhk, nCode, wParam, new LPARAM(peer));
			}
		};

		hhk = lib.SetWindowsHookEx(WinUser.WH_MOUSE_LL, mouseHook, hMod, 0);



		// This bit never returns from GetMessage
		MSG msg = new MSG();
		lib.GetMessage(msg, null, 0, 0);

		System.out.println("base.MouseHook run() Method finished");
	}

}
