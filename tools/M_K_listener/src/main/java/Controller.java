import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller {

	
	static void setJFrame() {
		// 窗口界面
		JFrame jframe = new JFrame();
		jframe.setSize(300, 200);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLayout(null);
		jframe.setResizable(false);
		jframe.setVisible(true);

		JLabel jlabel = new JLabel("后台监听鼠标键盘已开启",JLabel.CENTER);
		jlabel.setSize(200,75);
		jlabel.setLocation((jframe.getContentPane().getSize().width - jlabel.getSize().width) / 2,0);
		jframe.add(jlabel);

		JButton jbutton = new JButton("关闭");
		jbutton.setSize(150,70);
		jbutton.setBackground(Color.white);
		jbutton.setLocation((jframe.getContentPane().getSize().width-jbutton.getSize().width)/2, 70);
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jframe.add(jbutton);

	}

	public static Map<String, Utiliy> map1=new HashMap<String,Utiliy>();

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

		Map<Boolean,String> map2=new HashMap<Boolean,String>();
		map2.put(true,"256");
		map2.put(false,"257");
		for (Method method : methods) {
			if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
				method.setAccessible(true);
				ListenMouseKeyboard k111 = method.getAnnotation(ListenMouseKeyboard.class);

				System.out.println("已扫描方法"+method.getName());
				Utiliy u111 = new Utiliy();
				u111.method1 = method;
				u111.immediately = k111.immediately();
				map1.put(k111.value()+"_"+map2.get(k111.press()), u111);
			}

			//处理重复注解
			if (method.isAnnotationPresent(ListenMouseKeyboards.class)) {
				method.setAccessible(true);
				ListenMouseKeyboards ks111 = method.getAnnotation(ListenMouseKeyboards.class);

				for(ListenMouseKeyboard k111 : ks111.value()){
					System.out.println("已扫描方法"+method.getName());
					Utiliy u111 = new Utiliy();
					u111.method1 = method;
					u111.immediately = k111.immediately();
					map1.put(k111.value()+"_"+map2.get(k111.press()), u111);
				}


			}
		}
		System.out.println(map1);
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
		
		setJFrame();

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
