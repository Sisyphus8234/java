package base;

import java.io.*;
import java.util.*;

public class Config {
    public static String prefix = "";
    public static String filePath = "custom/Config.properties";
    private static Properties prop = new Properties();

    static {
        init();
    }

    public static void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),java.nio.charset.StandardCharsets.UTF_8));
            prop.load(br);
            br.close();
        } catch (Exception e) {
        }
    }

    public static String read(String s1) {
        return prop.getProperty(s1, null);
    }

    public static String readWithPrefix(String s1) {
        s1 = prefix + s1;
        return read(s1);
    }


    public static void write(String s1, String s2) {

        try {
            prop.setProperty(s1, s2);

            Set<String> keys = prop.stringPropertyNames();

            // 将键按照首字母排序
            List<String> sortedKeys = new ArrayList<>(keys);
            Collections.sort(sortedKeys);

            // 手动写入属性到文件，保持顺序
            try (Writer writer = new FileWriter(filePath, false)) { // 设置为 false 表示覆盖源文件
                for (String key : sortedKeys) {
                    String value = prop.getProperty(key);
                    writer.write(key + "=" + value + "\n");
                }
            }

        } catch (Exception e) {
        }

    }

    public static void writeWithPrefix(String s1, String s2) {
        s1 = prefix + s1;
        write(s1, s2);
    }

}
