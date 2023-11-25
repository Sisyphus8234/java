package base;

import java.util.Objects;

public class InputInfo {

    public int keyboardOrMouse;
    public int value;
    public boolean press;
    public boolean userInput;
    public int mouseData;

    public long timeInterval;

    public void resetProperty(){
        this.keyboardOrMouse=0;
        this.value=0;
        this.press=true;
        this.userInput=true;
        this.mouseData=0;
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
        switch (other.keyboardOrMouse){
            case ListenMouseKeyboard.KeyboardOrMouse.Keyboard:
                return value == other.value && press==other.press && userInput== other.userInput;
            case ListenMouseKeyboard.KeyboardOrMouse.Mouse:
                return value == other.value  && userInput== other.userInput;
            case ListenMouseKeyboard.KeyboardOrMouse.MouseWithMouseData:
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
