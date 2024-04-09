package base;

import com.fasterxml.jackson.core.type.TypeReference;
import custom.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    public static boolean printKey = false;
    public static boolean listenSwitch = true;
    public static List<MyThread> threadList = new ArrayList<>();
    public static Map<InputInfo, List<TaskInfo>> taskMmap = new HashMap<>();
    public static Map<Integer, Integer> switchMmap = new HashMap<>();
    public static TaskInfo recorder = null;

    @Deprecated
    public static Map<String, TaskInfo> mapJintellitype = new HashMap<>();

    public static long refreshtime = 3000L;

    public static Do do1 = new Do(refreshtime);

    public static Map<String, Integer> keyCodeMap = new HashMap<>();

    public class Active {
        public static final int jna = 0;
        public static final int jnativehook = 1;
    }

    public static void run(Class myFunctionClass, Class baseFunctionClass) {

        MyJFrame.run();


        if (Functions.active == Active.jna) {
            keyCodeMap = JsonUtil.readJsonFile("base/jna_key_code.json", new TypeReference<HashMap<String, Integer>>() {
            });


            //mouse
            new Thread() {
                @Override
                public void run() {

                    JnaMouseHook jnaMouseHook = new JnaMouseHook();
                    jnaMouseHook.run();

                }
            }.start();


            //keyboard
            new Thread() {
                @Override
                public void run() {

                    JnaKeyboardHook jnaKeyboardHook = new JnaKeyboardHook();
                    jnaKeyboardHook.run();

                }
            }.start();
        } else if (Functions.active == Active.jnativehook) {
            keyCodeMap = JsonUtil.readJsonFile("base/jnativehook_key_code.json", new TypeReference<HashMap<String, Integer>>() {
            });

            //keyboard
            new Thread() {
                @Override
                public void run() {
                    JnativehookUtil.run();

                }
            }.start();


//            //mouse
//            new Thread() {
//                @Override
//                public void run() {
//
//
//
//                }
//            }.start();


        }

//		if(Functions.jintellitype==true) {
//			//Jintellitype
//			new Thread() {
//				@Override
//				public void run() {
//
//					JintellitypeRegisterAndListener jintellitypeRegisterAndListener = new JintellitypeRegisterAndListener();
//					jintellitypeRegisterAndListener.run();
//
//				}
//			}.start();
//		}

        ScanFunction.run(myFunctionClass, baseFunctionClass);

    }

}
