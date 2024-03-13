package base;

import java.util.*;

public class InputInfo {

    public int keyboardOrMouse;
    public int value;
    public boolean press;
    public boolean userInput;

    HookInputInfo hookInputInfo = new HookInputInfo();

    public Set<String> otherCondition = new HashSet<>();

    public long timeInterval;
    public boolean extend;



    public void resetProperty() {
        this.keyboardOrMouse = 0;
        this.value = 0;
        this.press = true;
        this.userInput = true;
        this.hookInputInfo.mouseData = 0;
        this.hookInputInfo.flags = 0;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // 如果是同一个对象，则认为相等
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // 如果对象为null或者类型不同，则认为不相等
        }
        InputInfo other = (InputInfo) obj; // 将obj强制转换为当前类的类型
        // 根据类的属性进行相等性比较

        boolean step0 = false;
        switch (other.keyboardOrMouse) {
            case ListenMouseKeyboard.KeyboardOrMouse.Keyboard:
                step0 = value == other.value && press == other.press && userInput == other.userInput;
                break;

            case ListenMouseKeyboard.KeyboardOrMouse.Mouse:
                step0 = value == other.value && userInput == other.userInput;
                break;
        }

        boolean step1 = true;
        if (!otherCondition.isEmpty()) {
            if (otherCondition.contains(ListenMouseKeyboard.ConditionName.mouseData)) {
                step1 = step1 && (hookInputInfo.mouseData == other.hookInputInfo.mouseData);
            }
            if (otherCondition.contains(ListenMouseKeyboard.ConditionName.flags)) {
                step1 = step1 && (hookInputInfo.flags == other.hookInputInfo.flags);
            }
        }

        return step0 && step1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, userInput);
    }


//    public boolean recorderEquals(Object obj) {
//        if (this == obj) {
//            return true; // 如果是同一个对象，则认为相等
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false; // 如果对象为null或者类型不同，则认为不相等
//        }
//        InputInfo other = (InputInfo) obj; // 将obj强制转换为当前类的类型
//        // 根据类的属性进行相等性比较
//
//        boolean step0 = false;
//        switch (other.keyboardOrMouse) {
//            case ListenMouseKeyboard.KeyboardOrMouse.Keyboard:
//                step0 = press == other.press && userInput == other.userInput;
//                break;
//
//            case ListenMouseKeyboard.KeyboardOrMouse.Mouse:
//                step0 = userInput == other.userInput;
//                break;
//        }
//
//
//
//        return step0;
//    }


}
