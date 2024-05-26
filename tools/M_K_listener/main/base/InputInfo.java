package base;

import java.util.*;

public class InputInfo {

    public int keyboardOrMouse;
    public int value;
    public boolean press;
    public boolean userInput;


    public Map<String, String> otherCondition = new HashMap();

    public long timeInterval;
    public boolean extend;


    public void resetProperty() {
        this.keyboardOrMouse = 0;
        this.value = 0;
        this.press = true;
        this.userInput = true;

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // 如果是同一个对象，则认为相等
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // 如果对象为null或者类型不同，则认为不相等
        }
        InputInfo objInMap = (InputInfo) obj; // 将obj强制转换为当前类的类型
        // 根据类的属性进行相等性比较

        boolean step0 = false;
        step0 = value == objInMap.value && press == objInMap.press && userInput == objInMap.userInput && keyboardOrMouse == objInMap.keyboardOrMouse;


        boolean step1 = true;
        if (objInMap.otherCondition != null && objInMap.otherCondition.size() != 0) {

            for (Map.Entry<String, String> item : objInMap.otherCondition.entrySet()) {
                if (!otherCondition.containsKey(item.getKey())) {
                    throw new RuntimeException("otherCondition mistake");
                }

                step1 = step1 && Objects.equals(otherCondition.get(item.getKey()), item.getValue());
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
