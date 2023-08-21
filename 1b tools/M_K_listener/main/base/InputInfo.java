package base;

import java.util.Objects;

public class InputInfo {

    int keyboardOrMouse;
    int value;
    int press;
    String userInput;
    int mouseData;


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
        switch (other.keyboardOrMouse){
            case 0:
                return value == other.value && press==other.press && userInput== other.userInput;
            case 1:
                return value == other.value  && userInput== other.userInput;
            case 2:
                return value == other.value  && userInput== other.userInput&&mouseData== other.mouseData;
            default:
                return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, userInput);
    }


}
