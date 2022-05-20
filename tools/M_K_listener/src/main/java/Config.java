import java.io.*;
import java.util.Properties;

public class Config {

    public static String filePath = "Config.properties";
    public static Properties prop;

    static {
        read();
    }

    public static void read() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            prop.load(br);
            br.close();
        } catch (Exception e) {
        }
    }


    public static void write() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            prop.store(bw, null);
            bw.close();
        } catch (Exception e) {
        }

    }
}
