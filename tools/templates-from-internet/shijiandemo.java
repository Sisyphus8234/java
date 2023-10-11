import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class shijiandemo {
    
    private Frame f;
    private TextField tf;
    private Button but;
    
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new shijiandemo() ;
    }



    public shijiandemo() {
        super();
        init();
    }



    private void init() {
        f=new Frame("鼠标与键盘事件监听");
        
        f.setBounds(200,200,400,400);
        
        f.setLayout(new FlowLayout());
        
        tf=new TextField(15);
        but=new Button("这是一个按钮");
        f.add(tf);
        f.add(but);
        
        f.setVisible(true);
        myevent();
        
    }



    private void myevent() {
        
        //添加键盘事件
        tf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                // 设定只能输入数字
                int code=e.getKeyCode();
                if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
                {
                    System.out.println("必须是数字");
                    e.consume();
                }
                    
                
            }
        });
        
        //添加窗体事件
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        
        //添加鼠标事件
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    tf.setText("单击了");
                }
                if(e.getClickCount()==2)
                {
                    tf.setText("双击了");
                }
            
            }

            private int count=0;

            @Override
            public void mouseEntered(MouseEvent e) {
                
                but.setLabel("鼠标触发了"+count++);
            }
        });
        
    }

}