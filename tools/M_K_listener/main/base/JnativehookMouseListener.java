package base;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

import static base.JnativehookUtil.tempF;

public class JnativehookMouseListener implements NativeMouseInputListener {
    private InputInfo inputInfoActualTemp = new InputInfo();
    public void nativeMouseClicked(NativeMouseEvent e) {

        System.out.println(e.getButton());

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getButton();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        tempF(inputInfoActualTemp, e);
    }

    public void nativeMousePressed(NativeMouseEvent e) {

        System.out.println(e.getButton());

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getButton();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        tempF(inputInfoActualTemp, e);
    }

    public void nativeMouseReleased(NativeMouseEvent e) {

        System.out.println(e.getButton());

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getButton();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = false;

        tempF(inputInfoActualTemp, e);
    }

    public void nativeMouseMoved(NativeMouseEvent e) {

    }

    public void nativeMouseDragged(NativeMouseEvent e) {

    }


}