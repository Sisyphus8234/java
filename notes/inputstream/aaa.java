import java.io.*;


public class aaa {
    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        byte[] b = new byte[is.available()];
        System.out.println(is.available());

        while ((is.read(b)) != -1) {
            fos.write(b);
        }
        is.close();
        fos.close();

    }
}