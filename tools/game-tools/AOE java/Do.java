import java.awt.List;


public class Do
{
	public long refreshtime;
	public List task_list=new List();
	
		
	
	public Do(long refreshtime) {
		this.refreshtime=refreshtime;
		
		new Thread() {
		    @Override
		    public void run() {
		    	while(true) {try {Thread.sleep(refreshtime);} catch (InterruptedException e) {e.printStackTrace();}
	            task(task_list);
	    }}}.start();
    }
	
	
    public void what_at_once(String s) {
    	Functions.run(s);
    }
	
	
	
	public void task(List task_list) {
		if(task_list.getItemCount()>0) {
//			System.out.println("----------list");
//			for(String s:list.getItems()) {System.out.println(s);}					
//			System.out.println("----------list");			
			Functions.run(task_list.getItem(0));
			task_list.remove(0);
	    }
	}

	
	
}