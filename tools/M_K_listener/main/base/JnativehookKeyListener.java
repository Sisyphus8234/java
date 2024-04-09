package base;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.lang.reflect.Field;

import static base.JnativehookUtil.tempF;

public class JnativehookKeyListener implements NativeKeyListener {

    private InputInfo inputInfoActualTemp = new InputInfo();


    public void nativeKeyPressed(NativeKeyEvent e) {

        System.out.println(e.getKeyCode());

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getKeyCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        tempF(inputInfoActualTemp, e);

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getKeyCode();
        inputInfoActualTemp.keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = false;

        tempF(inputInfoActualTemp, e);
    }



    public void nativeKeyTyped(NativeKeyEvent e) {

    }


}