package base.jnativehook;

import base.InputInfo;
import base.ListenMouseKeyboard;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import static base.IFunctions.myKeyPress;
import static base.IFunctions.myKeyRelease;
import static base.jnativehook.JnativehookUtil.tempF;
import static java.awt.event.KeyEvent.VK_J;

public class JnativehookKeyListener implements NativeKeyListener {

    private InputInfo inputInfoActualTemp = new InputInfo();


    public void nativeKeyPressed(NativeKeyEvent e) {

//        System.out.println("--------------------------");
//        System.out.println(e.getKeyCode());
//        System.out.println(e.getKeyLocation());
//        System.out.println(e.getWhen());
//        System.out.println(e.getKeyChar());
//        System.out.println(e.getSource());
//        System.out.println(e.getID());
//        System.out.println(e.getModifiers());
//        System.out.println(e.getRawCode());
//        System.out.println("==========================");

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getRawCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        JnativehookUtil.tempF(inputInfoActualTemp, e);

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getRawCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = false;

        JnativehookUtil.tempF(inputInfoActualTemp, e);
    }



    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));


    }


}