package base;

import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<MethodInfo> methodInfoList =new ArrayList<>();

	public static Object object;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            task(methodInfoList);
	    }}}.start();
    }

	public void task(MethodInfo methodInfo) {
		if(methodInfo.immediately==true) {
			//立即执行功能
			this.what_at_once(methodInfo);
		}else if(methodInfo.immediately==false){
			//放入队列执行
			this.methodInfoList.add(methodInfo);
		}
	}
	
	
    public void what_at_once(MethodInfo methodInfo) {

		try {
			int parameterCount = methodInfo.method.getParameterCount();
			if(parameterCount>0) {
				methodInfo.method.invoke(object, methodInfo.inputInfo);
			}else {
				methodInfo.method.invoke(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void task(List<MethodInfo> methodInfoList) {
		if(methodInfoList.size()>0) {
			try {
				methodInfoList.get(0).method.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}

			methodInfoList.remove(0);
	    }
	}

	
	
}