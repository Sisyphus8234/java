import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainclass {	
	
	
	
	
	static void setJframe() { 
		// 窗口界面
		JFrame jframe = new JFrame("M_K_listener");
		jframe.setSize(300, 200);
		jframe.setLocation(550, 250);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel field = new JLabel();
		field.setBounds(30, 20, 400, 100);
		field.setText("后台监听鼠标键盘已开启");
		jframe.setLayout(null);
		JButton button = new JButton("关闭");
		jframe.add(field);
		jframe.add(button);
		button.setBounds(60, 120, 150, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jframe.setLayout(null);
		jframe.setResizable(true);
		jframe.setVisible(true);
	}
	
	
	
	
	
		
	
	public static long refreshtime=3000;
	
	public static Do do1=new Do(refreshtime);
	
	
	public static void task(String s,boolean b) {
		if(b==true) {
			//立即执行功能
			do1.what_at_once(s);
		}else {
			//放入队列执行
			do1.task_list.add(s);
			}
		}
	
	public static void main(String[] args) {
		
		setJframe();
		
		
		//mouse
		new Thread() {
			@Override
			public void run() {
            
			MouseHook mouseHook =new MouseHook();
			mouseHook.run();
            
            }}.start();
            
            
        //keyboard    
        new Thread() {
            @Override
    		public void run() {            
            
            KeyboardHook keyboardHook=new KeyboardHook();
            keyboardHook.run();
                
        }}.start();
        
	}

}
