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


				if (nCode==0 & wParam.intValue()==256) {
					
					if(info.flags==16) {System.out.print("这是由系统按下的");}
					System.out.println(info.vkCode);
					
					switch(info.vkCode){
					
					
					
					case 192:
						
						Mainclass.task("AOE",true);
						
						break;
						
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

		System.out.println("KeyboardHook run 方法结束");
	}

	
	
}