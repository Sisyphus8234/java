import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ScanFunction {
    public static void run(Class myFunctionClass, Class baseFunctionClass, Map<InputInfo, Utiliy> mapJna, Map<String, Utiliy> mapJintellitype, Map<Integer, String> mapListenBar, ArrayList<MyThread> threadList){


        //Class<Functions> classFunctions = Functions.class;
        Class classForTraverseMethod;
        classForTraverseMethod=myFunctionClass;
        Method[] methods=new Method[0];
        while (true){
            methods=mergeFields(methods,classForTraverseMethod.getDeclaredMethods());
            if(classForTraverseMethod.isInstance(baseFunctionClass)){
                break;
            };
            classForTraverseMethod=classForTraverseMethod.getSuperclass();
        }


        try {
            Do.obj1 = myFunctionClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建Functions实例对象失败");
            System.exit(0);
        }

        //按下还是松开,鼠标不适用
        Map<Boolean,Integer> map1=new HashMap();
        map1.put(true,256);
        map1.put(false,257);

        //是否是用户输入
        Map<Boolean,String> map2=new HashMap();
        map2.put(true,"userInput");
        map2.put(false,"!userInput");


        for (Method method : methods) {

            if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
                method.setAccessible(true);
                ListenMouseKeyboard k111 = method.getAnnotation(ListenMouseKeyboard.class);

                System.out.println("已扫描方法"+method.getName());
                Utiliy u111 = new Utiliy();
                u111.method = method;
                u111.immediately = k111.immediately();
                u111.intercept=k111.intercept();
                InputInfo inputInfo =new InputInfo();
                inputInfo.value=k111.value();
                inputInfo.press=map1.get(k111.press());
                inputInfo.userInput=map2.get(k111.userInput());
                inputInfo.keyboardOrMouse=k111.keyboardOrMouse();
                inputInfo.mouseData= k111.mouseData();
                mapJna.put(inputInfo, u111);
            }

            //处理重复注解
            if (method.isAnnotationPresent(ListenMouseKeyboards.class)) {
                method.setAccessible(true);
                ListenMouseKeyboards ks111 = method.getAnnotation(ListenMouseKeyboards.class);

                for(ListenMouseKeyboard k111 : ks111.value()){
                    System.out.println("已扫描方法"+method.getName());
                    Utiliy u111 = new Utiliy();
                    u111.method = method;
                    u111.immediately = k111.immediately();
                    u111.intercept=k111.intercept();
                    InputInfo inputInfo =new InputInfo();
                    inputInfo.value=k111.value();
                    inputInfo.press=map1.get(k111.press());
                    inputInfo.userInput=map2.get(k111.userInput());
                    inputInfo.keyboardOrMouse=k111.keyboardOrMouse();
                    inputInfo.mouseData= k111.mouseData();
                    mapJna.put(inputInfo, u111);
                }
            }

            //jintellitype部分
            if (method.isAnnotationPresent(JintellitypeListen.class)) {
                method.setAccessible(true);
                JintellitypeListen j111 = method.getAnnotation(JintellitypeListen.class);

                System.out.println("已扫描方法"+method.getName());
                Utiliy u111 = new Utiliy();
                u111.method = method;
                u111.immediately = j111.immediately();
                mapJintellitype.put(j111.modifier()+"_"+j111.keycode(), u111);
            }

            //处理重复
            if (method.isAnnotationPresent(JintellitypeListens.class)) {
                method.setAccessible(true);
                JintellitypeListens js111 = method.getAnnotation(JintellitypeListens.class);

                for(JintellitypeListen j111 : js111.value()){
                    System.out.println("已扫描方法"+method.getName());
                    Utiliy u111 = new Utiliy();
                    u111.method = method;
                    u111.immediately = j111.immediately();
                    mapJintellitype.put(j111.modifier()+"_"+j111.keycode(), u111);
                }
            }




        }
        System.out.println(mapJna);
        System.out.println(mapJintellitype);


//        Field[] fieldsChild=class1.getDeclaredFields();
//        Field[] fieldsParent=class1.getSuperclass().getDeclaredFields();
//        Field[] fieldsChildAndParent = mergeFields(fieldsChild, fieldsParent);

        Class classForTraverseField;
        classForTraverseField=myFunctionClass;
        Field[] fields=new Field[0];
        while (true){

            fields=mergeFields(fields,classForTraverseField.getDeclaredFields());
            if(classForTraverseField.isInstance(baseFunctionClass)){
                break;
            };
            classForTraverseField=classForTraverseField.getSuperclass();
        }


        for(Field field:fields){
            if(field.isAnnotationPresent(ListenBar.class)){
                ListenBar listenBar =field.getAnnotation(ListenBar.class);
                try {
                    if(listenBar.off()==true&&listenBar.threadList()!=true&&!mapListenBar.containsValue("off")){
                        mapListenBar.put(Integer.parseInt(field.get(myFunctionClass).toString()),"off");
                    }else if(listenBar.off()==false&&listenBar.threadList()!=true&&!mapListenBar.containsValue("on")){
                        mapListenBar.put(Integer.parseInt(field.get(myFunctionClass).toString()),"on");
                    }
                }catch (Exception e){}

                try{
                    if(listenBar.threadList()==true){
                        threadList.addAll((List<MyThread>)field.get(myFunctionClass));
                    }
                }catch (Exception e){}
            }

        }

        System.out.println("开关键: "+mapListenBar);
        System.out.println("开关控制的线程: "+threadList);



    }

    private static <T> T[] mergeFields(T[] arr1, T[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        T[] merged = Arrays.copyOf(arr1, length1 + length2);  // 创建一个新数组，长度为两个数组之和
        System.arraycopy(arr2, 0, merged, length1, length2);  // 将 arr2 数组的元素复制到 merged 数组中
        return merged;
    }
}
