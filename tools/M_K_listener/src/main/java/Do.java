import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Do
{

	public long refreshtime;
	public List<Method> task_list=new ArrayList<Method>();

	public static Object obj1;
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            task(task_list);
	    }}}.start();
    }

	public void task(Utiliy u1) {
		if(u1.immediately==true) {
			//立即执行功能
			this.what_at_once(u1.method);
		}else if(u1.immediately==false){
			//放入队列执行
			this.task_list.add(u1.method);
		}
	}
	
	
    public void what_at_once(Method m1) {

		try {
			m1.invoke(obj1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void task(List<Method> task_list) {
		if(task_list.size()>0) {

			try {
				task_list.get(0).invoke(obj1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			task_list.remove(0);
	    }
	}

	
	
}