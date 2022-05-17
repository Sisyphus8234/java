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

    }
}
