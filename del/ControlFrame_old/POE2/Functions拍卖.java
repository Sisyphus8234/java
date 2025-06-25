package custom;

import base.*;

import java.awt.*;

import static java.awt.event.KeyEvent.*;


public class  Functions拍卖 extends IFunctions {

    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static String on = "h";

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static String off = "g";





    @ListenMouseKeyboard(key = "滚轮",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320",timeInterval = 800L)

    @ListenMouseKeyboard(key = "滚轮", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false,intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320",timeInterval = 800L)
    public static void 滚轮下(InputInfo inputInfo){

//        robot.mousePress(BUTTON1_DOWN_MASK);
//        robot.mouseRelease(BUTTON1_DOWN_MASK);
//        pause(50L);

        robot.keyPress(VK_CONTROL);
        robot.keyPress(VK_A);
        robot.keyRelease(VK_A);
        robot.keyRelease(VK_CONTROL);

        pause(50L);
        robot.keyPress(VK_CONTROL);
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        robot.keyRelease(VK_CONTROL);

        pause(50L);
        String text = IFunctions.readClipboard();

        int temp=Integer.parseInt(text);

        if(inputInfo.otherCondition.contains("7864320")){
            temp++;
        }else {
            temp--;
        }

        writeClipboard(String.valueOf(temp));

        robot.keyPress(VK_CONTROL);
        robot.keyPress(VK_V);
        robot.keyRelease(VK_V);
        robot.keyRelease(VK_CONTROL);
    }













}


class MainClass1 {
    public static void main(String[] s){

//        Controller.printKey=true;
        Controller.run(Functions拍卖.class, IFunctions.class);
    }


}