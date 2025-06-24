import java.awt.*;
import java.awt.geom.AffineTransform;


public class 获取屏幕缩放比例 {
    public static void main(String[] args) {
        GraphicsConfiguration asdf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        AffineTransform asfd2 = asdf.getDefaultTransform();

        double scaleX = asfd2.getScaleX();
        double scaleY = asfd2.getScaleY();

        System.out.println(scaleX);
        System.out.println(scaleY);
    }
}
