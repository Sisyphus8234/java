package base;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JintellitypeRegisterAndListener {

    Do do1=Controller.do1;

    public void run() {

        int i=1;
        Map<Integer,String> map1=new HashMap();
        for(String s1:Controller.mapJintellitype.keySet()){
            String[] temp1 = s1.split("_");
            JIntellitype.getInstance().registerHotKey(i,Integer.parseInt(temp1[0]),Integer.parseInt(temp1[1]));
            map1.put(i,s1);
            i++;
        }
        Set<Integer> set1=map1.keySet();

        // 添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {

                if(set1.contains(markCode)){

                    do1.task(Controller.mapJintellitype.get(map1.get(markCode)));
                }
            }
        });


    }

}
