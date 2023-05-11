import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static int on = 36;

    @ListenBar
    public static int off = 35;
    @ListenBar(threadList = true)
    public static List<Thread> list=new ArrayList<>();

    public static Integer valueOriginal;

    public static Point pointUser;
    public static Point pointInput;

    public static int sliderChange=4;

    public static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    static {

    }

    @ListenMouseKeyboard(value = 81,intercept = true)
    private static void q() {
        pointInput=MouseInfo.getPointerInfo().getLocation();
    }

    @ListenMouseKeyboard(value = 69,intercept = true)
    @ListenMouseKeyboard(value = 87,intercept = true)
    private static void e_w() {
        pointInput=MouseInfo.getPointerInfo().getLocation();

        CTRLCOrV(KeyEvent.VK_C);
        valueOriginal=getValue();

    }

    @ListenMouseKeyboard(value = 82,intercept = true)
    @ListenMouseKeyboard(value = 83,intercept = true)
    private static void r_s() {
        robot.mouseMove(pointInput.x, pointInput.y);
        setValue(valueOriginal);
        CTRLCOrV(KeyEvent.VK_V);
        robot.mouseMove(pointUser.x, pointUser.y);
    }



    @ListenMouseKeyboard(value = 65,intercept = true)
    private static void a() {

        changeValue(-sliderChange);



    }

    @ListenMouseKeyboard(value = 68,intercept = true)
    private static void d() {
        changeValue(sliderChange);

    }



    public static Integer getValue(){


        Integer value=null;
        // 检查剪贴板中是否有文本内容
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                // 获取剪贴板内容
                System.out.println(clipboard.getData(DataFlavor.stringFlavor));
                value = Integer.valueOf((String) clipboard.getData(DataFlavor.stringFlavor));
                System.out.println("获取原始值: " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static void setValue(Integer value){


        // 封装文本内容
        Transferable trans = new StringSelection(String.valueOf(value));
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);

        System.out.println("加之前的值: " + value);
    }

    public static void changeValue(Integer sliderChange){

        pointUser=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointInput.x, pointInput.y);

        Integer value=getValue();

        setValue(value+sliderChange);

        CTRLCOrV(KeyEvent.VK_V);

        pointInput=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointUser.x, pointUser.y);

    }

    public static void CTRLCOrV(Integer COrV){
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(COrV);
        pause(50);
        robot.keyRelease(COrV);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        pause(50);
    }

}
