import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrintAllFields {

    private static List l1 = new ArrayList();

    public static void run(Object obj) {
        traversal_father_and_son(obj, "");
    }

    public static void run(Object obj, String name) {
        traversal_father_and_son(obj, name);
    }

    private static void traversal_father_and_son(Object obj, String name) {
        Class cls = obj.getClass();
        while (cls != null && cls != Object.class) {

            l1.add(obj);

            printfields(obj, cls, name);
            cls = cls.getSuperclass();
        }
    }


    private static void printfields(Object obj, Class cls, String name) {

        Field[] fields = cls.getDeclaredFields();
        //System.out.println("--------------------"+name+"共有" + fields.length + "个属性");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                //新增field.get(obj)!=null，不知道有没有问题
//                if(field.get(obj)!=null && field.get(obj).getClass().isArray() == true){
//                    System.out.println(name + "===>" + field.getName() + ":" +Arrays.toString((Object[]) field.get(obj)));
//                    continue;
//                }

                System.out.println(name + "===>" + field.getName() + ":" + field.get(obj));

                if (is_an_Object(field.get(obj)) && field.get(obj) != obj && !l1.contains(field.get(obj))) {
                    traversal_father_and_son(field.get(obj), name + "." + field.getName());
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        //System.out.println("--------------------"+name+"结束");
    }

    private static boolean is_an_Object(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (
                //obj.toString().equals(obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode()))
                obj.getClass().isArray() == false &&
                obj instanceof java.util.Collection ==false &&
                isPrimitive(obj) ==false
                ) {

            return true;
            } else {
                return false;
            }
        }
    }

    /**判断一个对象是否是基本类型或基本类型的封装类型*/
    private static boolean isPrimitive(Object obj) {
        try {
            return ((Class<?>)obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }


}