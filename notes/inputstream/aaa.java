import java.io.*;


public class aaa {
    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
        byte[] b = new byte[1024];
        while ((is.read(b)) != -1) {
            fos.write(b);
            fos.close();
        }
        is.close();

    }
}