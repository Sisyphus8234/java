package custom;

import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

import static base.CommonUtil.customConditionSet;
import static base.IFunctions.*;

public interface Wheel {

    //region 参数
    int moveDistance = 30;
    int wheelDistance = 1;
    //endregion




    AtomicReference<Point> basePoint = new AtomicReference<>();
    AtomicReference<Integer> oldFlag = new AtomicReference<>(0);
    AtomicReference<Integer> nowFlag = new AtomicReference<>(0);
    AtomicReference<Boolean> ifExecute = new AtomicReference<>(false);


    public static MyThread f1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            while (true) {

                getBlock();


                nowFlag.set((getPointFix().y - basePoint.get().y) / moveDistance);


                if (!nowFlag.get().equals(oldFlag.get())) {
                    ifExecute.set(true);

                    int tempInt = nowFlag.get() - oldFlag.get();
                    blockingQueue.add(tempInt);

                    oldFlag.set(nowFlag.get());
                }

                pause(100L);
            }
        }
    };

    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue();
    public static MyThread f2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                try {
                    int tempInt = blockingQueue.take();
                    robot.mouseWheel(tempInt*wheelDistance);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pause(100L);
            }
        }
    };


    String wheel屏蔽="wheel_pb";
    @ListenMouseKeyboard(extend = true,intercept = true, key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customConditionReverse =wheel屏蔽 )
    public static void 右键按下() {

        ifExecute.set(false);
        oldFlag.set(0);
        nowFlag.set(0);

        basePoint.set(getPointFix());
        f1.nonBlock();
    }

    @ListenMouseKeyboard(extend = true,intercept = true, key = "右键松开", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customConditionReverse =wheel屏蔽 )
    public static void 右键松开() {
        f1.block();
        oldFlag.set(0);
        nowFlag.set(0);
    }

    @ListenMouseKeyboard(immediately = false, extend = true,key = "右键松开", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customConditionReverse =wheel屏蔽 )
    public static void 右键松开2() {


        if(ifExecute.get().equals(false)){
            customConditionSet.add(wheel屏蔽);
            pause(50L);
            robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
            pause(50L);
            robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
            pause(50L);
            customConditionSet.remove(wheel屏蔽);
        }
    }
}
