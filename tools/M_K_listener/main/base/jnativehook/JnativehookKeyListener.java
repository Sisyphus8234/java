package base.jnativehook;

import base.InputInfo;
import base.ListenMouseKeyboard;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import static base.jnativehook.JnativehookUtil.tempF;

public class JnativehookKeyListener implements NativeKeyListener {

    private InputInfo inputInfoActualTemp = new InputInfo();


    public void nativeKeyPressed(NativeKeyEvent e) {

        System.out.println(e.getKeyCode());

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getKeyCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        JnativehookUtil.tempF(inputInfoActualTemp, e);

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getKeyCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = false;

        JnativehookUtil.tempF(inputInfoActualTemp, e);
    }



    public void nativeKeyTyped(NativeKeyEvent e) {

    }


}