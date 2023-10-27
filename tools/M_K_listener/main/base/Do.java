package base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<Utiliy> utiliyList=new ArrayList<>();

	public static Object obj1;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            task(utiliyList);
	    }}}.start();
    }

	public void task(Utiliy u1) {
		if(u1.immediately==true) {
			//立即执行功能
			this.what_at_once(u1);
		}else if(u1.immediately==false){
			//放入队列执行
			this.utiliyList.add(u1);
		}
	}
	
	
    public void what_at_once(Utiliy u1) {

		try {
			int parameterCount = u1.method.getParameterCount();
			if(parameterCount>0) {
				u1.method.invoke(obj1, u1.inputInfo);
			}else {
				u1.method.invoke(obj1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void task(List<Utiliy> utiliyList) {
		if(utiliyList.size()>0) {
			try {
				utiliyList.get(0).method.invoke(obj1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			utiliyList.remove(0);
	    }
	}

	
	
}