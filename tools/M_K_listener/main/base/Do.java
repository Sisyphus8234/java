package base;

import base.enty.TaskInfo;
import base.enty.TaskResult;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Do {

    public long refreshtime;
    public List<TaskInfo> taskInfoList = new ArrayList<>();

    public static Object object;


    public Do(long refreshtime) {
        this.refreshtime = refreshtime;

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(refreshtime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    delay(taskInfoList);
                }
            }
        }.start();
    }


    public boolean doTask(TaskInfo taskInfo) {
        boolean result=false;
        if(!taskInfo.inputInfo.customConditionReverse.isEmpty()) {
            if(taskInfo.inputInfo.customConditionReverse.stream().anyMatch(CommonUtil.customConditionSet::contains)){
                return result;
            }
        }
        if(taskInfo.inputInfo.customCondition.isEmpty()||CommonUtil.customConditionSet.containsAll(taskInfo.inputInfo.customCondition)) {
            if (Duration.between(taskInfo.lastTime, LocalDateTime.now()).toMillis() > taskInfo.inputInfo.timeInterval) {
                taskInfo.lastTime = LocalDateTime.now();
                if (taskInfo.immediately == true) {
                    //立即执行功能
                    this.invoke(taskInfo);
                } else if (taskInfo.immediately == false) {
                    //放入队列执行
                    this.taskInfoList.add(taskInfo);
                }
            }

            if (taskInfo.intercept == true) {
                result= true;
            }
            if(taskInfo.taskResult!=null&&taskInfo.taskResult.intercept==true){
                result= true;
            }
        }

        return result;
    }

    private void invoke(TaskInfo taskInfo) {
        try {
            int parameterCount = taskInfo.method.getParameterCount();
            if (parameterCount > 0) {
                taskInfo.taskResult = (TaskResult) taskInfo.method.invoke(object, taskInfo.inputInfoActualTemp);
            } else {
                taskInfo.taskResult = (TaskResult) taskInfo.method.invoke(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delay(List<TaskInfo> taskInfoList) {
        if (taskInfoList.size() > 0) {
            TaskInfo taskInfo = taskInfoList.get(0);

            invoke(taskInfo);

            taskInfoList.remove(0);
        }
    }


}