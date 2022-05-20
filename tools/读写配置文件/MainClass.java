import java.io.*;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args){

        String filePath="aaa.properties";

        Properties prop = new Properties();
        String value = null;
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            prop.load(br);
            br.close();
            value = prop.getProperty("xxx");
            System.out.println(value);


            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            prop.clear();
            prop.setProperty("xxx","修改后的");
            prop.store(bw, null);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
