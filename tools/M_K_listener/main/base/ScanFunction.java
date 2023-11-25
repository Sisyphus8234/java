package base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static base.Controller.*;

public class ScanFunction {
    public static void run(Class myFunctionClass, Class baseFunctionClass) {


        //Class<Functions> classFunctions = Functions.class;
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


        try {
            Do.object = myFunctionClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to create Functions instance object");
            System.exit(0);
        }

//        //按下还是松开,鼠标不适用
//        Map<Boolean,Integer> map1=new HashMap();
//        map1.put(true,256);
//        map1.put(false,257);

//        //是否是用户输入
//        Map<Boolean,String> map2=new HashMap();
//        map2.put(true,"userInput");
//        map2.put(false,"!userInput");


        for (Method method : methods) {

            if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
                method.setAccessible(true);
                ListenMouseKeyboard listenMouseKeyboard = method.getAnnotation(ListenMouseKeyboard.class);

                System.out.println("Method recorded: " + method.getName());
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.method = method;
                taskInfo.immediately = listenMouseKeyboard.immediately();
                taskInfo.intercept = listenMouseKeyboard.intercept();
                InputInfo inputInfo = new InputInfo();
                inputInfo.value = listenMouseKeyboard.value();
                inputInfo.press = listenMouseKeyboard.press();
                inputInfo.userInput = listenMouseKeyboard.userInput();
                inputInfo.keyboardOrMouse = listenMouseKeyboard.keyboardOrMouse();
                inputInfo.mouseData = listenMouseKeyboard.mouseData();
                inputInfo.timeInterval = listenMouseKeyboard.timeInterval();
                taskInfo.inputInfo = inputInfo;
                mapJna.put(inputInfo, taskInfo);
            }

            //处理重复注解
            if (method.isAnnotationPresent(ListenMouseKeyboards.class)) {
                method.setAccessible(true);
                ListenMouseKeyboards listenMouseKeyboards = method.getAnnotation(ListenMouseKeyboards.class);

                for (ListenMouseKeyboard listenMouseKeyboard : listenMouseKeyboards.value()) {
                    System.out.println("Method recorded: " + method.getName());
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.method = method;
                    taskInfo.immediately = listenMouseKeyboard.immediately();
                    taskInfo.intercept = listenMouseKeyboard.intercept();
                    InputInfo inputInfo = new InputInfo();
                    inputInfo.value = listenMouseKeyboard.value();
                    inputInfo.press = listenMouseKeyboard.press();
                    inputInfo.userInput = listenMouseKeyboard.userInput();
                    inputInfo.keyboardOrMouse = listenMouseKeyboard.keyboardOrMouse();
                    inputInfo.mouseData = listenMouseKeyboard.mouseData();
                    inputInfo.timeInterval = listenMouseKeyboard.timeInterval();
                    taskInfo.inputInfo = inputInfo;
                    mapJna.put(inputInfo, taskInfo);
                }
            }

            //jintellitype部分
            if (method.isAnnotationPresent(JintellitypeListen.class)) {
                method.setAccessible(true);
                JintellitypeListen j111 = method.getAnnotation(JintellitypeListen.class);

                System.out.println("Method recorded: " + method.getName());
                TaskInfo u111 = new TaskInfo();
                u111.method = method;
                u111.immediately = j111.immediately();
                mapJintellitype.put(j111.modifier() + "_" + j111.keycode(), u111);
            }

            //处理重复
            if (method.isAnnotationPresent(JintellitypeListens.class)) {
                method.setAccessible(true);
                JintellitypeListens js111 = method.getAnnotation(JintellitypeListens.class);

                for (JintellitypeListen j111 : js111.value()) {
                    System.out.println("Method recorded: " + method.getName());
                    TaskInfo u111 = new TaskInfo();
                    u111.method = method;
                    u111.immediately = j111.immediately();
                    mapJintellitype.put(j111.modifier() + "_" + j111.keycode(), u111);
                }
            }


        }
        System.out.println("Jna:" + mapJna);
        System.out.println("Jintellitype: " + mapJintellitype);


//        Field[] fieldsChild=class1.getDeclaredFields();
//        Field[] fieldsParent=class1.getSuperclass().getDeclaredFields();
//        Field[] fieldsChildAndParent = mergeFields(fieldsChild, fieldsParent);

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


        for (Field field : fields) {
            if (field.isAnnotationPresent(ListenBar.class)) {
                ListenBar listenBar = field.getAnnotation(ListenBar.class);
                try {
                    if (listenBar.onOrOff() == ListenBar.OnOrOff.off && listenBar.threadList() != true) {
                        mapListenBar.put(Integer.parseInt(field.get(myFunctionClass).toString()), ListenBar.OnOrOff.off);
                    } else if (listenBar.onOrOff() == ListenBar.OnOrOff.on && listenBar.threadList() != true) {
                        mapListenBar.put(Integer.parseInt(field.get(myFunctionClass).toString()), ListenBar.OnOrOff.on);
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

        System.out.println("OnAndOff key(1 means on,2 means off): " + mapListenBar);
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
