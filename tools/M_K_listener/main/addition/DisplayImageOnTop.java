package addition;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayImageOnTop {

    private JFrame frame;
    private JLabel imageLabel;

    public static long lastModified;  // 记录上次读取图片的文件修改时间
    public static ImageIcon imageIcon;

    public DisplayImageOnTop(Point locatin, float opacity) {

        frame = new JFrame("Transparent Image Window");
        frame.setType(Window.Type.UTILITY);

        // 设置为非装饰窗口
        frame.setUndecorated(true);

        frame.setAlwaysOnTop(true);

        frame.setLocation(locatin);

        frame.setOpacity(opacity);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        imageLabel = new JLabel();
        frame.getContentPane().add(imageLabel);

        frame.setVisible(true);
    }

    public void openImage(String imagePath) {

        File imageFile = new File(imagePath);




        if (imageFile.lastModified() == lastModified) {

        }else {
            imageIcon = createImageIcon(imagePath);
        }




        imageLabel.setIcon(imageIcon);

        // 设置窗口大小为图片尺寸
        frame.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());

        lastModified = imageFile.lastModified();



    }

    private ImageIcon createImageIcon(String imagePath) {
        // 禁用图片缓存
        Image image = Toolkit.getDefaultToolkit().createImage(imagePath);
        return new ImageIcon(image);
    }

    public void closeImage() {
        imageLabel.setIcon(null);
        frame.setOpacity(1.0f);
    }

    public void closeWindow() {
        frame.dispose();
    }

}
