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


public class MouseHook {
	
	private HHOOK hhk;
	private LowLevelMouseProc mouseHook;
	InputInfo inputInfo =new InputInfo();

	private Utiliy utiliy;

	public void run() {
		
		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		
		mouseHook = new LowLevelMouseProc() {



			@Override
			public LRESULT callback(int nCode, WPARAM wParam, MSLLHOOKSTRUCT info) {


				
				if(nCode==0 & wParam.intValue()!=512) {
					if(info.flags==1) {System.out.print("(由程序执行的)");}
					System.out.println("鼠标键"+wParam);
					System.out.println(info.mouseData);

					//开关相关
					if(Controller.listehSwitch==false){
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
						utiliy=Controller.mapJna.get(inputInfo);
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

		hhk = lib.SetWindowsHookEx(WinUser.WH_MOUSE_LL, mouseHook, hMod, 0);



		// This bit never returns from GetMessage
		MSG msg = new MSG();
		lib.GetMessage(msg, null, 0, 0);

		System.out.println("base.MouseHook run 方法结束");
	}

}
