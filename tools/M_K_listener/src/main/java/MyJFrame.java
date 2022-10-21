import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame {
    public static void run(){

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

        setTray(jframe);

    }

    //托盘图标
    public static void setTray(JFrame jFrame) {
        //判断当前平台是否支持托盘功能
        if(SystemTray.isSupported()){
            //创建托盘实例
            SystemTray tray = SystemTray.getSystemTray();
            //创建托盘图标：1.显示图标Image 2.停留提示text 3.弹出菜单popupMenu 4.创建托盘图标实例
            //1.创建Image图像
            Image image = Toolkit.getDefaultToolkit().getImage("resources/1.png");
            //2.停留提示text
            String text = "MySystemTray";
            //3.弹出菜单popupMenu
            PopupMenu popMenu = new PopupMenu();
            MenuItem itmOpen = new MenuItem("show");
            itmOpen.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    jFrame.setVisible(true);
                }
            });
            MenuItem itmHide = new MenuItem("hide");
            itmHide.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    jFrame.setVisible(false);
                }
            });
            MenuItem itmExit = new MenuItem("exit");
            itmExit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            popMenu.add(itmOpen);
            popMenu.add(itmHide);
            popMenu.add(itmExit);

            //创建托盘图标
            TrayIcon trayIcon = new TrayIcon(image,text,popMenu);
            //将托盘图标加到托盘上
            try {
                tray.add(trayIcon);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
    }
}
