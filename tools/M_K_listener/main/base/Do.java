package base;

import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<Utiliy> utiliyList=new ArrayList<>();

	public static Object object;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            task(utiliyList);
	    }}}.start();
    }

	public void task(Utiliy utiliy) {
		if(utiliy.immediately==true) {
			//立即执行功能
			this.what_at_once(utiliy);
		}else if(utiliy.immediately==false){
			//放入队列执行
			this.utiliyList.add(utiliy);
		}
	}
	
	
    public void what_at_once(Utiliy utiliy) {

		try {
			int parameterCount = utiliy.method.getParameterCount();
			if(parameterCount>0) {
				utiliy.method.invoke(object, utiliy.inputInfo);
			}else {
				utiliy.method.invoke(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void task(List<Utiliy> utiliyList) {
		if(utiliyList.size()>0) {
			try {
				utiliyList.get(0).method.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}

			utiliyList.remove(0);
	    }
	}

	
	
}