package base;

import base.enty.TaskInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


import static base.CommonUtil.keyCodeMap;
import static base.Controller.*;

public class ScanFunction {


    private static void handleMethod(Method method, ListenMouseKeyboard listenMouseKeyboard) {

        if (listenMouseKeyboard.active() != -1 && listenMouseKeyboard.active() != IFunctions.active) {
            return;
        }


        System.out.println("Method recorded: " + method.getName());
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.method = method;
        taskInfo.immediately = listenMouseKeyboard.immediately();
        taskInfo.intercept = listenMouseKeyboard.intercept();
        taskInfo.occupyTime = listenMouseKeyboard.occupyTime();
        InputInfo inputInfo = new InputInfo();

        //判断是否是recorder
        if(listenMouseKeyboard.key().isEmpty()){
            inputInfo.value = -1;
        }else {
            if (!keyCodeMap.containsKey(listenMouseKeyboard.key())) {
                throw new RuntimeException(listenMouseKeyboard.key() + " was not found in keyCodeMap");
            }
            inputInfo.value = keyCodeMap.get(listenMouseKeyboard.key());
        }
        inputInfo.press = listenMouseKeyboard.press();
        inputInfo.userInput = listenMouseKeyboard.userInput();
        inputInfo.keyboardOrMouse = listenMouseKeyboard.keyboardOrMouse();
        inputInfo.timeInterval = listenMouseKeyboard.timeInterval();
        inputInfo.extend = listenMouseKeyboard.extend();


        taskInfo.inputInfo = inputInfo;


        if(inputInfo.value==-1){
            recorder.add(taskInfo);
            return;
        }



        if (!listenMouseKeyboard.otherCondition().isEmpty()) {
            String[] otherCondition = listenMouseKeyboard.otherCondition().split(",");
            for (String item : otherCondition) {
                String key = item.split("=")[0];
                String value = item.split("=")[1];
                inputInfo.otherCondition.put(key, value);
            }
        }

        if (!listenMouseKeyboard.customCondition().isEmpty()) {
            String[] customCondition = listenMouseKeyboard.customCondition().split(",");
            for (String item : customCondition) {
                if(item.startsWith("!")&&!item.equals("!")){
                    inputInfo.customConditionReverse.add(item.substring(1));
                }else {
                    inputInfo.customCondition.add(item);
                }
            }
        }

        if (!taskMmap.containsKey(inputInfo)) {
            List tempList = new ArrayList<TaskInfo>();
            tempList.add(taskInfo);
            taskMmap.put(inputInfo, tempList);
        } else {
            Iterator<TaskInfo> tempIterator = taskMmap.get(inputInfo).iterator();
            while (tempIterator.hasNext()) {
                TaskInfo tempTaskInfo = tempIterator.next();
                if (tempTaskInfo.inputInfo.extend == false && inputInfo.extend == false) {
                    if (tempTaskInfo.inputInfo.customCondition.isEmpty() && inputInfo.customCondition.isEmpty()) {
                        tempIterator.remove();
                    } else if (tempTaskInfo.inputInfo.cusConEquals(inputInfo)) {
                        tempIterator.remove();
                    }
                }
            }
            taskMmap.get(inputInfo).add(taskInfo);

        }
    }

//    private static void handleRecorder(Method method, Recorder recorder) {
//        System.out.println("Recorder recorded: " + method.getName());
//        TaskInfo taskInfo = new TaskInfo();
//        taskInfo.method = method;
//        InputInfo inputInfo = new InputInfo();
//
//        inputInfo.timeInterval = recorder.timeInterval();
//        taskInfo.inputInfo = inputInfo;
//        Controller.recorder = taskInfo;
//    }


    public static void run(Class myFunctionClass, Class baseFunctionClass) {
        Class classForTraverseMethod;
        classForTraverseMethod = myFunctionClass;
        Method[] methods = new Method[0];
        while (true) {
            methods = mergeFields(methods, classForTraverseMethod.getDeclaredMethods());
            if (classForTraverseMethod.isInstance(baseFunctionClass)) {
                break;
            }
            classForTraverseMethod = classForTraverseMethod.getSuperclass();
        }
//        for (Method method : methods) {
//            method.setAccessible(true);
//        }


        try {
            Do.object = myFunctionClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to create Functions instance object");
            System.exit(0);
        }


        for (Method method : methods) {

            if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
                ListenMouseKeyboard listenMouseKeyboard = method.getAnnotation(ListenMouseKeyboard.class);
                handleMethod(method, listenMouseKeyboard);
            }
//            else if (method.isAnnotationPresent(Recorder.class)) {
//                Recorder recorder = method.getAnnotation(Recorder.class);
//                handleRecorder(method, recorder);
//            }

            //处理重复注解
            if (method.isAnnotationPresent(ListenMouseKeyboards.class)) {
                ListenMouseKeyboards listenMouseKeyboards = method.getAnnotation(ListenMouseKeyboards.class);
                for (ListenMouseKeyboard listenMouseKeyboard : listenMouseKeyboards.value()) {
                    handleMethod(method, listenMouseKeyboard);
                }
            }


//            //jintellitype部分
//            if (method.isAnnotationPresent(JintellitypeListen.class)) {
//                JintellitypeListen j111 = method.getAnnotation(JintellitypeListen.class);
//
//                System.out.println("Method recorded: " + method.getName());
//                TaskInfo u111 = new TaskInfo();
//                u111.method = method;
//                u111.immediately = j111.immediately();
//                mapJintellitype.put(j111.modifier() + "_" + j111.keycode(), u111);
//            }
//
//            //处理重复
//            if (method.isAnnotationPresent(JintellitypeListens.class)) {
//                method.setAccessible(true);
//                JintellitypeListens js111 = method.getAnnotation(JintellitypeListens.class);
//
//                for (JintellitypeListen j111 : js111.value()) {
//                    System.out.println("Method recorded: " + method.getName());
//                    TaskInfo u111 = new TaskInfo();
//                    u111.method = method;
//                    u111.immediately = j111.immediately();
//                    mapJintellitype.put(j111.modifier() + "_" + j111.keycode(), u111);
//                }
//            }


        }
        System.out.println("Jna:" + taskMmap);
//        System.out.println("Jintellitype: " + mapJintellitype);


        Class classForTraverseField;
        classForTraverseField = myFunctionClass;
        Field[] fields = new Field[0];
        while (true) {
            fields = mergeFields(fields, classForTraverseField.getDeclaredFields());
            if (classForTraverseField.isInstance(baseFunctionClass)) {
                break;
            }
            classForTraverseField = classForTraverseField.getSuperclass();
        }
//        for (Field field : fields) {
//            field.setAccessible(true);
//        }

        for (Field field : fields) {
            if (field.isAnnotationPresent(ListenBar.class)) {
                ListenBar listenBar = field.getAnnotation(ListenBar.class);
                try {
                    if ((listenBar.onOrOff() == ListenBar.OnOrOff.on || listenBar.onOrOff() == ListenBar.OnOrOff.off) && listenBar.threadList() != true) {
                        Iterator<Map.Entry<Integer, Integer>> iterator = switchMmap.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<Integer, Integer> entry = iterator.next();
                            if (entry.getValue().equals(listenBar.onOrOff())) {
                                iterator.remove();
                            }
                        }

                        switchMmap.put(keyCodeMap.get(field.get(myFunctionClass).toString()), listenBar.onOrOff());

                    }
                } catch (Exception e) {
                }

                try {
                    if (listenBar.threadList() == true) {
                        threadList.addAll((List<MyThread>) field.get(myFunctionClass));
                    }
                } catch (Exception e) {
                }
            }

        }

        System.out.println("OnAndOff key(1 means on,2 means off): " + switchMmap);
        System.out.println("Thread controlled by OnAndOff key: " + threadList);


    }

    public static <T> T[] mergeFields(T[] arr1, T[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        T[] merged = Arrays.copyOf(arr2, length1 + length2);  // 创建一个新数组，长度为两个数组之和
        System.arraycopy(arr1, 0, merged, length2, length1);  // 将 arr2 数组的元素复制到 merged 数组中
        return merged;
    }

}
