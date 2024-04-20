package base.jnativehook;


import base.CommonUtil;
import base.InputInfo;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelListener;

public class JnativehookMouseWheelListener implements NativeMouseWheelListener {

    private InputInfo inputInfoActualTemp = new InputInfo();
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getButton();
        inputInfoActualTemp.keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        JnativehookUtil.tempF(inputInfoActualTemp, e);

    }

}