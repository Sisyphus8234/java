import java.io.*;

public class Stream {
    public static void main(String[] strings) throws Exception {

        InputStream in = new FileInputStream("Stream.java");
        OutputStream out = new FileOutputStream("output");

        Integer length=in.available();
        byte[] b = new byte[length];
        in.read(b);

        out.write(b);

        in.close();
        out.close();

    }
}
