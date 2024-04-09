package base;

import com.sun.jna.platform.win32.WinDef;

import java.util.List;

import static base.Controller.recorder;

public class HookUtil {
    public static boolean isSwitch(int keyCode){
        if (Controller.switchMmap.containsKey(keyCode)) {
            if (Controller.switchMmap.get(keyCode).equals(ListenBar.OnOrOff.off)) {
                for (MyThread thread : Controller.threadList) {
                    thread.mySuspend();
                }
                Controller.listenSwitch = false;

                System.out.println("program off");
                return true;
            } else if (Controller.switchMmap.get(keyCode).equals(ListenBar.OnOrOff.on)) {
                for (MyThread thread : Controller.threadList) {
                    if (thread.defaultState == MyThread.State.on) {
                        thread.myResume();
                    }
                }
                Controller.listenSwitch = true;

                System.out.println("program on");
                return true;
            }
        }

        return false;
    }

    public static boolean task(InputInfo inputInfoActualTemp){

        if (recorder != null) {
            recorder.inputInfoActualTemp = inputInfoActualTemp;
            Controller.do1.doTask(recorder);
            if (recorder.taskResult != null && recorder.taskResult.intercept == true) {
                return true;
            }
        }

        if (Controller.taskMmap.containsKey(inputInfoActualTemp)) {
            List<TaskInfo> taskInfoList = Controller.taskMmap.get(inputInfoActualTemp);
            for (TaskInfo taskInfo : taskInfoList) {
                taskInfo.inputInfoActualTemp = inputInfoActualTemp;
                Controller.do1.doTask(taskInfo);
            }
            for (TaskInfo taskInfo : taskInfoList) {
                if (taskInfo.intercept == true) {
                    return true;
                }
                if(taskInfo.taskResult!=null&&taskInfo.taskResult.intercept==true){
                    return true;
                }
            }
        }

        return false;

    }



}
