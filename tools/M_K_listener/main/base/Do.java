package base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<TaskInfo> taskInfoList =new ArrayList<>();

	public static Object object;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            delay(taskInfoList);
	    }}}.start();
    }

	public void doTask(TaskInfo taskInfo) {
		if(Duration.between(taskInfo.lastTime, LocalDateTime.now()).toMillis()>taskInfo.inputInfo.timeInterval) {
			taskInfo.lastTime=LocalDateTime.now();
			if (taskInfo.immediately == true) {
				//立即执行功能
				this.immediate(taskInfo);
			} else if (taskInfo.immediately == false) {
				//放入队列执行
				this.taskInfoList.add(taskInfo);
			}
		}
	}
	
	
    public void immediate(TaskInfo taskInfo) {

		try {
			int parameterCount = taskInfo.method.getParameterCount();
			if(parameterCount>0) {
				taskInfo.method.invoke(object, taskInfo.inputInfoActualTemp);
			}else {
				taskInfo.method.invoke(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void delay(List<TaskInfo> taskInfoList) {
		if(taskInfoList.size()>0) {
			try {
				TaskInfo taskInfo = taskInfoList.get(0);
				int parameterCount = taskInfo.method.getParameterCount();
				if(parameterCount>0){
					taskInfo.method.invoke(object, taskInfo.inputInfo);
				}
				taskInfo.method.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}

			taskInfoList.remove(0);
	    }
	}

	
	
}