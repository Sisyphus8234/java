import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ScanFunction {
    public static void run(Class class1,Map<String, Utiliy> mapJna,Map<String, Utiliy> mapJintellitype){




        //Class<Functions> classFunctions = Functions.class;
        Method[] methods = class1.getDeclaredMethods();


        try {
            Do.obj1 = class1.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建Functions实例对象失败");
            System.exit(0);
        }

        Map<Boolean,String> map1=new HashMap<Boolean,String>();
        map1.put(true,"256");
        map1.put(false,"257");
        for (Method method : methods) {

            if (method.isAnnotationPresent(ListenMouseKeyboard.class)) {
                method.setAccessible(true);
                ListenMouseKeyboard k111 = method.getAnnotation(ListenMouseKeyboard.class);

                System.out.println("已扫描方法"+method.getName());
                Utiliy u111 = new Utiliy();
                u111.method1 = method;
                u111.immediately = k111.immediately();
                mapJna.put(k111.value()+"_"+map1.get(k111.press()), u111);
            }

            //处理重复注解
            if (method.isAnnotationPresent(ListenMouseKeyboards.class)) {
                method.setAccessible(true);
                ListenMouseKeyboards ks111 = method.getAnnotation(ListenMouseKeyboards.class);

                for(ListenMouseKeyboard k111 : ks111.value()){
                    System.out.println("已扫描方法"+method.getName());
                    Utiliy u111 = new Utiliy();
                    u111.method1 = method;
                    u111.immediately = k111.immediately();
                    mapJna.put(k111.value()+"_"+map1.get(k111.press()), u111);
                }
            }

            //jintellitype部分
            if (method.isAnnotationPresent(JintellitypeListen.class)) {
                method.setAccessible(true);
                JintellitypeListen j111 = method.getAnnotation(JintellitypeListen.class);

                System.out.println("已扫描方法"+method.getName());
                Utiliy u111 = new Utiliy();
                u111.method1 = method;
                u111.immediately = j111.immediately();
                mapJna.put(j111.identifier()+"_"+j111.modifier()+"_"+j111.modifier(), u111);
            }

            //处理重复
            if (method.isAnnotationPresent(JintellitypeListens.class)) {
                method.setAccessible(true);
                JintellitypeListens js111 = method.getAnnotation(JintellitypeListens.class);

                for(JintellitypeListen j111 : js111.value()){
                    System.out.println("已扫描方法"+method.getName());
                    Utiliy u111 = new Utiliy();
                    u111.method1 = method;
                    u111.immediately = j111.immediately();
                    mapJna.put(j111.identifier()+"_"+j111.modifier()+"_"+j111.modifier(), u111);
                }
            }




        }
        System.out.println(mapJna);

    }
}
