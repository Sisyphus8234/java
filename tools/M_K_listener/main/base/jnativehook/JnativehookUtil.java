package base.jnativehook;


import base.Controller;
import base.HookUtil;
import base.InputInfo;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;

import java.lang.reflect.Field;

public class JnativehookUtil{
    public static void tempF(InputInfo inputInfoActualTemp, NativeKeyEvent e) {
        if (HookUtil.isSwitch(e.getKeyCode()) == true) {
            intercept(e);
        }

        if (Controller.listenSwitch == true) {
            if (HookUtil.task(inputInfoActualTemp) == true) {
                intercept(e);
            }
        }
    }

    public static void tempF(InputInfo inputInfoActualTemp, NativeMouseEvent e) {
        if (HookUtil.isSwitch(e.getButton()) == true) {
            intercept(e);
        }

        if (Controller.listenSwitch == true) {
            if (HookUtil.task(inputInfoActualTemp) == true) {
                intercept(e);
            }
        }
    }

    public static void intercept(NativeInputEvent e) {
        try {
            Field f = NativeInputEvent.class.getDeclaredField("reserved");
            f.setAccessible(true);
            f.setShort(e, (short) 0x01);

            System.out.print("[ OK ]\n");
        } catch (Exception ex) {
            System.out.print("[ !! ]\n");
            ex.printStackTrace();
        }
    }

    public static void run() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new JnativehookKeyListener());


        // Construct the example object.
        JnativehookMouseListener example = new JnativehookMouseListener();

        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(example);
        GlobalScreen.addNativeMouseMotionListener(example);
    }
}