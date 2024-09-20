package base;

import base.enty.TaskInfo;

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
        boolean result=false;


        if (recorder != null) {
            recorder.inputInfoActualTemp = inputInfoActualTemp;
            Controller.do1.doTask(recorder);
            if (recorder.taskResult != null && recorder.taskResult.intercept == true) {
                return true;
            }
        }

        inputInfoActualTemp.customCondition=CommonUtil.customConditionSet;



        if (Controller.taskMmap.containsKey(inputInfoActualTemp)) {
            List<TaskInfo> taskInfoList = Controller.taskMmap.get(inputInfoActualTemp);
            for (TaskInfo taskInfo : taskInfoList) {
                taskInfo.inputInfoActualTemp = inputInfoActualTemp;
                if(Controller.do1.doTask(taskInfo)==true){
                    result=true;
                }
            }
        }

        return result;

    }



}
