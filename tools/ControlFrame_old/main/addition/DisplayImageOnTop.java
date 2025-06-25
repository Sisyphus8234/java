package addition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DisplayImageOnTop {

    public JFrame frame;
    public JLabel label;
    public ImageIcon imageIcon;
    public Image image;
    public Image scaledImage;

    public static long lastModified = 0L;  // 记录上次读取图片的文件修改时间
    public Point location = new Point(0, 0);
    public float opacity = 1F;
    public String imagePath;
    public double scale = 1D;
    public Point imageSize = new Point();

    public void newPicture() {
        frame = new JFrame("Transparent Image Window");
        frame.setType(Window.Type.UTILITY);

        // 设置为非装饰窗口
        frame.setUndecorated(true);

        frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        frame.getContentPane().add(label);

        frame.setVisible(true);
    }

    public void openImage() {
        File imageFile = new File(imagePath);
        if (imageFile.lastModified() != lastModified) {
            try {
                image = ImageIO.read(imageFile);
                imageSize.x=image.getWidth(null);
                imageSize.y=image.getHeight(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scaledImage = image.getScaledInstance((int) (imageSize.x * scale), (int) (imageSize.y * scale), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
        }
        lastModified = imageFile.lastModified();
        run();
    }

    public void changeImageScale() {
        scaledImage = image.getScaledInstance((int) (imageSize.x * scale), (int) (imageSize.y * scale), Image.SCALE_SMOOTH);

        imageIcon = new ImageIcon(scaledImage);

        run();
    }

    public void run(){

        label.setIcon(imageIcon);


        frame.setSize(label.getIcon().getIconWidth(), label.getIcon().getIconHeight());


        frame.setLocation(location);
        frame.setOpacity(opacity);
    }

    public void draw(Point point){
        // 在原图上绘制圆圈
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setColor(Color.RED);
        g2d.fillOval(point.x,point.y, 20, 20);
        g2d.dispose();

        scaledImage = image.getScaledInstance((int) (imageSize.x * scale), (int) (imageSize.y * scale), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        run();
    }


    public void closeImage() {
        label.setIcon(null);
        frame.setOpacity(0f);
    }

    public void closeWindow() {
        frame.dispose();
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            DisplayImageOnTop displayImageOnTop = new DisplayImageOnTop();
//
//
//            displayImageOnTop.imagePath = "custom/top_pic.png";
//            displayImageOnTop.scale=2D;
//            displayImageOnTop.openImage();
////            displayImageOnTop.changeImageScale();
//        });
//    }
}
