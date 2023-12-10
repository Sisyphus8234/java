package addition;

import java.io.*;

public class SaveAndReadObject {

    public static void saveObject(Object object,String filePath){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // 将对象写入文件
            objectOutputStream.writeObject(object);
            System.out.println("Object has been serialized and written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readObject(String filePath,Class<T> myClass){


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {


            return myClass.cast(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
