package custom;

import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static base.IFunctions.pause;
import static base.IFunctions.robot;

public interface FakeMouse {

    String 上 = "up";
     String 下 = "down";
     String 左 = "left";
     String 右 = "right";
     String 滚轮上 = "gls";

     HashSet<String> status = new HashSet<>();


    int baseDistance = 10;
    public static AtomicInteger 距离 = new AtomicInteger(baseDistance);







    //region 移动鼠标
    public static MyThread f = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            Point point;

            while (true) {

                if (!status.isEmpty()) {

                    point = MouseInfo.getPointerInfo().getLocation();
                    int 移动距离_倍率 = 距离.get();
                    if (status.contains(上)) {
                        point.y = point.y - 移动距离_倍率;
                    }
                    if (status.contains(下)) {
                        point.y = point.y + 移动距离_倍率;
                    }
                    if (status.contains(左)) {
                        point.x = point.x - 移动距离_倍率;
                    }
                    if (status.contains(右)) {
                        point.x = point.x + 移动距离_倍率;
                    }
                    robot.mouseMove(point.x, point.y);


                } else {
                }
                pause(50L);
            }
        }
    };

    @ListenMouseKeyboard(key = "i", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult w() {
        status.add(上);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "i", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult w1() {
        status.remove(上);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "k", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult k() {
        status.add(下);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "k", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult k1() {
        status.remove(下);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "j", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult j() {
        status.add(左);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "j", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult j1() {
        status.remove(左);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "l", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult l() {
        status.add(右);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "l", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult l1() {
        status.remove(右);
        return new TaskResult(true);
    }

    //endregion


    //region 滚轮

    public static MyThread f1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            while (true) {

                getBlock();
                if(status.contains(滚轮上)){
                    robot.mouseWheel(-2);
                }else {
                    robot.mouseWheel(2);
                }

                pause(50L);
            }
        }
    };

    @ListenMouseKeyboard(key = "u", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult u() {
        status.add(滚轮上);
        f1.nonBlock();
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "u", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult u1() {
        f1.block();
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "o", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult o() {
        status.remove(滚轮上);
        f1.nonBlock();
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "o", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult o1() {
        f1.block();
        return new TaskResult(true);
    }

    //endregion


    //region 调速度

    @ListenMouseKeyboard(extend = true, key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult yi() {
            距离.set(baseDistance / 2);


        return new TaskResult(true);
    }

    @ListenMouseKeyboard(extend = true, key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult er() {
            距离.set(baseDistance);


        return new TaskResult(true);
    }

    @ListenMouseKeyboard(extend = true, key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult san() {
            距离.set(baseDistance * 2);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(extend = true, key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 开关开)
    public static TaskResult si() {
            距离.set(baseDistance * 4);

        return new TaskResult(true);
    }

    //endregion

    //region 开关
    public final static String 开关开 = "kgk";
    public final static String alt左 = "altl";
    public final static String alt右 = "altr";
    AtomicReference<LocalDateTime> time = new AtomicReference<>(LocalDateTime.now());



    //endregion
}
