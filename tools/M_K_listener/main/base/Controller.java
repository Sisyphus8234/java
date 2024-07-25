package base;

import base.enty.TaskInfo;
import base.jna.JnaKeyboardHook;
import base.jna.JnaMouseHook;
import base.jnativehook.JnativehookUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import custom.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base.CommonUtil.hookList;
import static base.CommonUtil.switchActive;

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




    public static void run(Class myFunctionClass, Class baseFunctionClass) {

        MyJFrame.run();

        try {
            myFunctionClass.newInstance();
        } catch (Exception e) {

        }


        switchActive();

        ScanFunction.run(myFunctionClass, baseFunctionClass);


        CommonUtil.prepareState=false;

        if (IFunctions.active == CommonUtil.Active.jna) {
            //mouse
            Thread t0=new Thread() {
                @Override
                public void run() {

                    JnaMouseHook jnaMouseHook = new JnaMouseHook();
                    jnaMouseHook.run();

                }
            };
            t0.start();
            hookList.add(t0);


            //keyboard
            Thread t1=new Thread() {
                @Override
                public void run() {

                    JnaKeyboardHook jnaKeyboardHook = new JnaKeyboardHook();
                    jnaKeyboardHook.run();

                }
            };
            t1.start();
            hookList.add(t1);




        } else if (IFunctions.active == CommonUtil.Active.jnativehook) {

            //keyboard
            Thread t0=new Thread() {
                @Override
                public void run() {
                    JnativehookUtil.run();

                }
            };
            t0.start();
            hookList.add(t0);
        }



    }

}
