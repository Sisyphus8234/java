package base;

import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<TaskdInfo> taskdInfoList =new ArrayList<>();

	public static Object object;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            delay(taskdInfoList);
	    }}}.start();
    }

	public void doTask(TaskdInfo taskdInfo) {
		if(taskdInfo.immediately==true) {
			//立即执行功能
			this.immediate(taskdInfo);
		}else if(taskdInfo.immediately==false){
			//放入队列执行
			this.taskdInfoList.add(taskdInfo);
		}
	}
	
	
    public void immediate(TaskdInfo taskdInfo) {

		try {
			int parameterCount = taskdInfo.method.getParameterCount();
			if(parameterCount>0) {
				taskdInfo.method.invoke(object, taskdInfo.inputInfo);
			}else {
				taskdInfo.method.invoke(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void delay(List<TaskdInfo> taskdInfoList) {
		if(taskdInfoList.size()>0) {
			try {
				TaskdInfo taskdInfo = taskdInfoList.get(0);
				int parameterCount = taskdInfo.method.getParameterCount();
				if(parameterCount>0){
					taskdInfo.method.invoke(object, taskdInfo.inputInfo);
				}
				taskdInfo.method.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}

			taskdInfoList.remove(0);
	    }
	}

	
	
}