package addition;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TopFrame {
    public static class Argument {
        public int x, y, width, height,lineWidth;
        public Color color;

        public Argument(int x, int y, int width, int height,int lineWidth,Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.lineWidth=lineWidth;
            this.color=color;
        }
    }
    public static JFrame frame = new JFrame();

    public static void start(List<Argument> argumentList) {
        stop();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕尺寸
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();


        SwingUtilities.invokeLater(() -> {
            frame = new JFrame();
            frame.setUndecorated(true); // 无边框窗口
            frame.setBackground(new Color(0, 0, 0, 0)); // 设置窗口背景透明
            frame.setAlwaysOnTop(true); // 窗口置顶
            frame.setSize(screenWidth, screenHeight);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    for(Argument u:argumentList) {
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setStroke(new BasicStroke(u.lineWidth)); // 设置线的粗细为10
                        g2d.setColor(u.color);
                        g2d.drawRect(u.x, u.y,u.width,u.height); // 第一个红色方框
                    }
                }
            };
            panel.setOpaque(false); // 设置panel为透明
            frame.add(panel);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // 居中显示
            frame.setVisible(true);
        });
    }

//    public static void main(String[] args) {
//
//        List<Argument> list=new ArrayList<>();
//
//        list.add(new Argument(1297, 764, 100, 100,5,Color.RED));
//        list.add(new Argument(250, 50, 100, 100,5,Color.GRAY));
//        start(list);
//
//    }

    public static void stop(){
//        frame.setVisible(!frame.isVisible()); // 切换窗口可见性
        frame.dispose();
    }
}
