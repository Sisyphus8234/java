package custom;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class RunPythonScript {
    public static java.util.List<Point> run() {
        try {
            // 指定 Python 脚本路径
            String pythonScriptPath = "py\\aaa.py";

            // 创建 ProcessBuilder 对象
            ProcessBuilder processBuilder = new ProcessBuilder("E:\\anaconda3\\envs\\py_d4\\python.exe", pythonScriptPath);

            // 启动进程
            Process process = processBuilder.start();

            // 读取 Python 脚本的标准输出
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 读取 Python 脚本的错误输出
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            StringBuilder stringBuilder=new StringBuilder();
            String s;
            System.out.println("Standard output of the command:");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                stringBuilder.append(s);
            }


            ArrayList<Point> pointArrayList=parsePoints(stringBuilder.toString());


            System.out.println("Standard error of the command (if any):");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            // 等待进程结束并获取退出状态
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);


            return pointArrayList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Point> parsePoints(String input) {
        if(input.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Point> points = new ArrayList<>();

        // 去掉括号并用下划线分割字符串
        String[] pairs = input.split("_");

        // 遍历每个坐标对
        for (String pair : pairs) {
            // 去掉括号并用逗号分割
            pair = pair.replace("(", "").replace(")", "");
            String[] coords = pair.split(", ");

            // 解析坐标并创建 Point 对象
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            points.add(new Point(x, y));
        }

        return points;
    }
}
