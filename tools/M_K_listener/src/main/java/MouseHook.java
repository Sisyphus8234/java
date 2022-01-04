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
	



	public void run() {
		
		final User32 lib = User32.INSTANCE;
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		
		mouseHook = new LowLevelMouseProc() {



			@Override
			public LRESULT callback(int nCode, WPARAM wParam, MSLLHOOKSTRUCT info) {

				
				if(nCode==0 & wParam.intValue()!=512) {
					if(info.flags==1) {System.out.print("(由程序执行的)");}
					System.out.println("鼠标键"+wParam);

				if(Controller.map1.containsKey(wParam.intValue()+"_") && info.flags!=1){
					Controller.task(Controller.map1.get(wParam.intValue()+"_256"));
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

		System.out.println("MouseHook run 方法结束");
	}

}
