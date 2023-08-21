package base;

import java.io.*;
import java.util.Properties;

public class Config {

    public static String filePath = "custom/Config.properties";
    private static Properties prop=new Properties();

    static {
        init();
    }

    public static void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            prop.load(br);
            br.close();
        } catch (Exception e) {
        }
    }

    public static String read(String s1) {
        return read(s1,null);
    }

    public static String read(String s1,String defaultValue) {
        return prop.getProperty(s1,defaultValue);
    }

    public static void write(String s1,String s2) {

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            prop.setProperty(s1,s2);
            prop.store(bw, null);
            bw.close();
        } catch (Exception e) {
        }

    }
}
