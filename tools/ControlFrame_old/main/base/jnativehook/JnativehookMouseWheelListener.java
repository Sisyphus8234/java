package base.jnativehook;


import base.CommonUtil;
import base.Controller;
import base.InputInfo;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelListener;

public class JnativehookMouseWheelListener implements NativeMouseWheelListener {

    private InputInfo inputInfoActualTemp = new InputInfo();
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {

        inputInfoActualTemp.resetProperty();
        inputInfoActualTemp.value = e.getButton();
//        inputInfoActualTemp.otherCondition.put("wheelRotation", String.valueOf(e.getWheelRotation()));
        inputInfoActualTemp.otherCondition.add(String.valueOf(e.getWheelRotation()));
        if(Controller.printKey==true) {
            System.out.println(e.getButton());
            System.out.println(e.getWheelRotation());
        }
        inputInfoActualTemp.keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse;
        inputInfoActualTemp.userInput = true;
        inputInfoActualTemp.press = true;

        JnativehookUtil.tempF(inputInfoActualTemp, e);

    }

}