package base;

import base.jna.JnaKeyboardHook;
import base.jna.JnaMouseHook;
import base.jnativehook.JnativehookUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {

    public static class Active {
        public static final int jna = 0;
        public static final int jnativehook = 1;
    }


    public static Map<String, Integer> keyCodeMap = new HashMap<>();

    public static List<Thread> hookList=new ArrayList<>();

    public static void switchActive() {

        keyCodeMap = JsonUtil.readJsonFile("base/common_key_code.json", new TypeReference<HashMap<String, Integer>>() {
        });
        String file = "";
        Thread temp;

        for(Thread thread:hookList){
            thread.stop();
        }
        hookList.clear();

        if (IFunctions.active == Active.jna) {
            file = "base/jna/jna_key_code.json";
            CommonUtil.keyCodeMap.putAll(JsonUtil.readJsonFile(file, new TypeReference<HashMap<String, Integer>>() {
            }));

            //mouse
            temp=new Thread() {
                @Override
                public void run() {

                    JnaMouseHook jnaMouseHook = new JnaMouseHook();
                    jnaMouseHook.run();

                }
            };
            temp.start();
            hookList.add(temp);


            //keyboard
            temp=new Thread() {
                @Override
                public void run() {

                    JnaKeyboardHook jnaKeyboardHook = new JnaKeyboardHook();
                    jnaKeyboardHook.run();

                }
            };
            temp.start();
            hookList.add(temp);




        } else if (IFunctions.active == CommonUtil.Active.jnativehook) {
            file = "base/jnativehook/jnativehook_key_code.json";
            CommonUtil.keyCodeMap.putAll(JsonUtil.readJsonFile(file, new TypeReference<HashMap<String, Integer>>() {
            }));



            //keyboard
            temp=new Thread() {
                @Override
                public void run() {
                    JnativehookUtil.run();

                }
            };
            temp.start();
            hookList.add(temp);
        }



    }
}
