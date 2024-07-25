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

    public Set<String> customCondition = new HashSet<>();


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
        InputInfo objNotTempInput = (InputInfo) obj; // 将obj强制转换为当前类的类型
        // 根据类的属性进行相等性比较

        boolean step0 = false;
        step0 = value == objNotTempInput.value && press == objNotTempInput.press && userInput == objNotTempInput.userInput && keyboardOrMouse == objNotTempInput.keyboardOrMouse;


        boolean step1 = true;
        if (objNotTempInput.otherCondition != null && objNotTempInput.otherCondition.size() != 0) {

            for (Map.Entry<String, String> item : objNotTempInput.otherCondition.entrySet()) {
                if (!otherCondition.containsKey(item.getKey())) {
                    throw new RuntimeException("otherCondition mistake");
                }

                step1 = step1 && Objects.equals(otherCondition.get(item.getKey()), item.getValue());
            }
        }

        boolean step2 = true;
        if (CommonUtil.prepareState==true) {
            step2 = customCondition.equals(objNotTempInput.customCondition);
        }else {
            if (!objNotTempInput.customCondition.isEmpty()) {
                step2 = CommonUtil.customConditionSet.containsAll(objNotTempInput.customCondition);
            }
        }

        return step0 && step1 && step2;
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
