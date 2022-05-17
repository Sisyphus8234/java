import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JintellitypeRegisterAndListener {


    public static void run() {

        Map<Integer,Utiliy> mapJintellitype=new HashMap();


        JIntellitype.getInstance().registerHotKey(1, 0, 27);
        JIntellitype.getInstance().registerHotKey(2, 0, 112 );
        JIntellitype.getInstance().registerHotKey(3, 0, 113);
        JIntellitype.getInstance().registerHotKey(4, 0, 114);
        JIntellitype.getInstance().registerHotKey(5, 0, 115);

        JIntellitype.getInstance().registerHotKey(6, 0, 33);
        JIntellitype.getInstance().registerHotKey(7, 0, 34);


        // 添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {

                if(markCode)
                switch (markCode) {
                    case 1:
                        taskList1.add("leftMouseClick");
                        break;
                    case 2:
                        taskList1.add("rightMouseClick");
                        break;
                    case 3:
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        break;
                    case 4:
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        break;
                    case 5:
                        robot.keyRelease(KeyEvent.VK_DELETE);
                        robot.keyPress(KeyEvent.VK_DELETE);
                        robot.keyRelease(KeyEvent.VK_DELETE);
                        break;

                    case 6:
                        taskList1.add("wheelUp");
                        break;
                    case 7:
                        taskList1.add("wheelDown");
                        break;


                }
            }

        });
    }

}
