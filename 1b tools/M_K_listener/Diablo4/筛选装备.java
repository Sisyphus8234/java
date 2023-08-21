package custom;

import base.IFunctions;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static java.awt.event.KeyEvent.VK_SPACE;

public class 筛选装备 {
    public static int 左线 = 1270;
    public static int 右线 = 1874;
    public static int 宽度 = 右线 - 左线;
    public static int 上线 = 724;
    public static int 下线 = 964;
    public static int 高度 = 下线 - 上线;
    public static int 横向数量 = 11;
    public static int 纵向数量 = 3;
    public static float 单个宽度 = (float) 宽度 / (float) 横向数量;
    public static float 单个高度 = (float) 高度 / (float) 纵向数量;
    public static HashMap<Integer, String> 装备种类 = new HashMap<>();

    public static boolean 是否筛选装备 = false;
    public static boolean 鼠标是否回到原点 = true;
    public static String folderName="OutPicture";
    public static String outPictureName="screenshot";
    public static String outTextName="output";

    static {
        装备种类.put(0, "只看数值");
        装备种类.put(1, "只看属性");
        装备种类.put(2, "看数值或看属性");
        装备种类.put(3, "自定要求");
    }

    public static void savePicture(int x, int y, Robot robot) {

        int arg1 = x - 430; // 传递给方法的参数
        int arg2 = 90; // 传递给方法的参数
        int arg3 = 380; // 传递给方法的参数
        int arg4 = 690; // 传递给方法的参数


        try {

            // 指定要捕捉的区域
            Rectangle screenRect = new Rectangle(arg1, arg2, arg3, arg4); // (x, y, width, height)

            // 捕捉屏幕区域的图像
            BufferedImage screenshot = robot.createScreenCapture(screenRect);

            // 保存图像为文件
            File output = new File(folderName+"/"+outPictureName+".png");
            ImageIO.write(screenshot, "png", output);

            File output1 = new File(folderName+"/"+outPictureName+LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + ".png");
            ImageIO.write(screenshot, "png", output1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void voice() {
        String audioFilePath = "custom/yy.wav"; // 替换为你的音频文件路径

        try {
            File audioFile = new File(audioFilePath);
            if (!audioFile.exists()) {
                System.out.println("Audio file not found.");
                return;
            }

            // 获取 Clip 实例
            Clip clip = AudioSystem.getClip();

            // 打开音频文件
            clip.open(AudioSystem.getAudioInputStream(audioFile));

            // 播放音频
            clip.start();

            // 等待音频播放完毕
//            Thread.sleep(clip.getMicrosecondLength() / 1000);
            Thread.sleep(250);

            // 关闭 Clip
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run(Robot robot, 筛选装备_子类 筛选装备_子类) {



        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

        String output="";
        int x轴第几个 = (int) (Math.floor((x - 左线) / 单个宽度));
        int y轴第几个 = (int) (Math.floor((y - 上线) / 单个高度));

        int tempx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int tempy = (int) MouseInfo.getPointerInfo().getLocation().getY();

        File directory = new File(folderName);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目标文件夹及其父文件夹（如果不存在）
        }

        while (是否筛选装备 == true) {
            boolean 是否报错 = false;
            筛选逻辑参数 筛选逻辑参数=new 筛选逻辑参数();
            筛选逻辑参数.要的词缀=筛选装备_子类.要的词缀();
            筛选逻辑参数.不要的词缀=筛选装备_子类.不要的词缀();
            筛选逻辑参数.需求词条数量_要求 =筛选装备_子类.需求词条数量_要求();

            筛选逻辑参数.数值优秀=false;
            筛选逻辑参数.需求词条数量=0;
            筛选逻辑参数.需求词条数量是否满足=false;
            筛选逻辑参数.自定要求是否满足=true;
            筛选逻辑参数.所有要求满足=false;
            筛选逻辑参数.装备种类="";

            List<String> result = new ArrayList<>();
            List<String> 需求词条 = new ArrayList<>();

            String 预类别 = "";

            int 物品强度索引 = 0;
            int 物品强度索引temp = 0;
            int 装备时损失属性索引 = 0;
            int 装备时损失属性索引temp = 0;

            int 标准化x = (int) (x轴第几个 * 单个宽度 + 单个宽度 / 2) + 左线;
            int 标准化y = (int) (y轴第几个 * 单个高度 + 单个高度 / 2 + 上线);

            robot.mouseMove(标准化x, 标准化y);
            IFunctions.pause(200);

            savePicture(标准化x, 标准化y, robot);


            if (鼠标是否回到原点 == true) {
                robot.mouseMove(tempx, tempy);
            }

            voice();

            try {
                // 构建命令
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "C:/Users/aaa/.conda/envs/paddle_env/Scripts/paddleocr --image_dir "+folderName+"/"+outPictureName+".png --use_angle_cls false --use_gpu false");

                // 设置工作目录（可选）
                // processBuilder.directory(new File("path_to_working_directory"));

                // 启动进程
                Process process = processBuilder.start();

                // 获取命令输出流
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
                BufferedReader reader = new BufferedReader(inputStreamReader);

                // 读取输出
                String line;
                while ((line = reader.readLine()) != null) {

                    System.out.println(line);
                    output=output+line+"\n";

                    // 找到元组开始的位置和结束的位置
                    int tupleStartIndex = line.indexOf('(');
                    int tupleEndIndex = line.indexOf(')');

                    if (tupleStartIndex != -1 && tupleEndIndex != -1) {
                        // 提取元组部分
                        String tuple = line.substring(tupleStartIndex + 1, tupleEndIndex);

                        // 切分元组，取得文本部分
                        String[] tupleParts = tuple.split(",");

                        if (tupleParts.length >= 1) {
                            String textPart = tupleParts[0].trim();

                            // 去掉单引号，获得最终的文本
                            String extractedText = textPart.replaceAll("'", "").trim();
                            result.add(extractedText);

                            if (extractedText.contains("戒指")) {
                                预类别="戒指";
                            } else if (extractedText.contains("护符")) {
                                预类别="护符";
                            }

//                            筛选装备_子类.装备分类(extractedText, 筛选逻辑参数,预类别);

                            if (extractedText.contains("物品强度")) {
                                物品强度索引 = 物品强度索引temp;
                            }
                            物品强度索引temp++;
                            if (extractedText.contains("装备时损失属性")) {
                                装备时损失属性索引 = 装备时损失属性索引temp;
                            }
                            装备时损失属性索引temp++;
                        }


                    }
                }

                筛选装备_子类.装备分类(result, 筛选逻辑参数,预类别);

                switch (预类别) {
                    case "戒指":
                        物品强度索引 += 2;
                        break;
                    case "护符":
                        物品强度索引 += 1;
                        break;
                }

                // 等待命令执行完成
                int exitCode = process.waitFor();
                System.out.println("Command exited with code: " + exitCode);

                // 关闭资源
                reader.close();
                inputStream.close();


                List<String> 是词缀的部分 = result.subList(物品强度索引 + 1, 装备时损失属性索引);
                System.out.println(是词缀的部分);



                筛选逻辑参数.是词缀的部分=是词缀的部分;
                筛选逻辑参数.需求词条=需求词条;


                System.out.println(筛选逻辑参数.装备种类);
                if (筛选逻辑参数.装备种类.equals(装备种类.get(3))) {
                    筛选装备_子类.自定筛选(筛选逻辑参数);
                }else{
                    筛选逻辑(筛选逻辑参数);
                    if(筛选逻辑参数.需求词条数量>=筛选逻辑参数.需求词条数量_要求){
                        筛选逻辑参数.需求词条数量是否满足=true;
                    }

                    if (筛选逻辑参数.装备种类.equals(装备种类.get(0))) {
                        if(筛选逻辑参数.数值优秀){
                            筛选逻辑参数.所有要求满足=true;
                        }
                    }else if(筛选逻辑参数.装备种类.equals(装备种类.get(1))){
                        if(筛选逻辑参数.需求词条数量是否满足){
                            筛选逻辑参数.所有要求满足=true;
                        }
                    }else if(筛选逻辑参数.装备种类.equals(装备种类.get(2))){
                        if(筛选逻辑参数.数值优秀||筛选逻辑参数.需求词条数量是否满足){
                            筛选逻辑参数.所有要求满足=true;
                        }
                    }else {
                        if(筛选逻辑参数.数值优秀||筛选逻辑参数.需求词条数量是否满足){
                            筛选逻辑参数.所有要求满足=true;
                        }
                    }
                }

            } catch (Exception e) {
                是否报错 = true;
                e.printStackTrace();
            }

            voice();
            System.out.println("-----需求词条: " + 需求词条);
            System.out.println("-----需求词条数量: " + 筛选逻辑参数.需求词条数量);
            System.out.println("-----数值优秀: " + 筛选逻辑参数.数值优秀);
            System.out.println("-----预类别: " + 预类别);
            System.out.println("-----装备种类: " + 筛选逻辑参数.装备种类);
            System.out.println("-----自定要求是否满足: " + 筛选逻辑参数.自定要求是否满足);
            System.out.println("-----所有要求满足: " + 筛选逻辑参数.所有要求满足);

            output=output+("-----需求词条: " + 需求词条)+"\n"+
            ("-----需求词条数量: " + 筛选逻辑参数.需求词条数量)+"\n"+
            ("-----数值优秀: " + 筛选逻辑参数.数值优秀)+"\n"+
            ("-----预类别: " + 预类别)+"\n"+
            ("-----装备种类: " + 筛选逻辑参数.装备种类)+"\n"+
            ("-----自定要求是否满足: " + 筛选逻辑参数.自定要求是否满足)+"\n"+
            ("-----所有要求满足: " + 筛选逻辑参数.所有要求满足)+"\n"+
            ("===============================================================================")+"\n";

            tempx = (int) MouseInfo.getPointerInfo().getLocation().getX();
            tempy = (int) MouseInfo.getPointerInfo().getLocation().getY();


            if (筛选逻辑参数.所有要求满足) {

            } else {
                if (是否报错 == false) {
                    robot.mouseMove(标准化x, 标准化y);
                    IFunctions.pause(20);
                    robot.keyPress(VK_SPACE);
                    IFunctions.pause(20);
                    robot.keyRelease(VK_SPACE);
                    IFunctions.pause(10);
                }
            }

            // 将内容保存到文件
            String fileName = folderName+"/"+outTextName+LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))+".txt";
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write(output);
                writer.close();
                System.out.println("内容已保存到 " + fileName);
            } catch (IOException e) {
                System.out.println("保存文件时出现错误：" + e.getMessage());
            }



            x轴第几个--;
            if (x轴第几个 < 0) {
                x轴第几个 = 横向数量 - 1;
                y轴第几个--;
            }
            if (y轴第几个 < 0) {
                break;
            }
        }
    }

//    public static void 筛选逻辑(List<String> 是词缀的部分, AtomicReference<Boolean> 数值优秀, String[] 要的词缀, String[] 不要的词缀, AtomicReference<Integer> 需求词条数量,
//                                List<String> 需求词条,int 需求词条要求数量,AtomicReference<Boolean> 需求词条数量是否满足, boolean arg1, boolean arg2) {

    public static void 筛选逻辑(筛选逻辑参数 筛选逻辑参数) {
        for (String s : 筛选逻辑参数.是词缀的部分) {
                if (s.contains("每秒伤害") || s.contains("护甲值")) {
                    if (s.contains("+")) {
                        筛选逻辑参数.数值优秀=true;
                    }
                }
                for (String s1 : 筛选逻辑参数.要的词缀) {
                    boolean 要的词缀是否包含不要的词缀 = false;
                    if (s.contains(s1)) {
                        for (String s2 : 筛选逻辑参数.不要的词缀) {
                            if (s.contains(s2)) {
                                要的词缀是否包含不要的词缀 = true;
                                break;
                            }
                        }
                        if (要的词缀是否包含不要的词缀 == false) {
                            筛选逻辑参数.需求词条数量++;
                            筛选逻辑参数.需求词条.add(s);
                            break;
                        }
                    }
                }
        }

    }
    static class 筛选逻辑参数{
        List<String> 是词缀的部分;
        Boolean 数值优秀;
        String[] 要的词缀;
        String[] 不要的词缀;
        Integer 需求词条数量;
        List<String> 需求词条;
        Integer 需求词条数量_要求;
        Boolean 需求词条数量是否满足;
        boolean 自定要求是否满足;
        boolean 所有要求满足;
        String 装备种类;
    }

}
