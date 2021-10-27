import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller {
	
	
	
	
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

	public static Map<Integer, Utiliy> map1=new HashMap<Integer,Utiliy>();

	public static void scanFunctions(Class class1) {


		//Class<Functions> classFunctions = Functions.class;
		Method[] methods = class1.getDeclaredMethods();


		try {
			Do.obj1 = class1.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建Functions实例对象失败");
			System.exit(0);
		}
		for (Method method : methods) {
			if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
				method.setAccessible(true);
				ListenMouseKeyboard k111 = method.getAnnotation(ListenMouseKeyboard.class);

				System.out.println("已扫描方法"+method.getName());
				Utiliy u111 = new Utiliy();
				u111.method1 = method;
				u111.immediately = k111.immediately();
				map1.put(k111.value(), u111);
			}
		}
	}
	
		
	
	public static long refreshtime=3000;
	
	public static Do do1=new Do(refreshtime);


	
	public static void task(Utiliy u1) {
		if(u1.immediately==true) {
			//立即执行功能
			do1.what_at_once(u1.method1);
		}else if(u1.immediately==false){
			//放入队列执行
			do1.task_list.add(u1.method1);
			}
		}
	
	public Controller(Class class1) {
		
		setJframe();

		scanFunctions(class1);

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
