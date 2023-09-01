package custom;

import base.IFunctions;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.event.KeyEvent.VK_SPACE;

public class 筛选装备 {
    private static class 当前装备信息 {
        int x;
        int xIndex;
        int y;
        int yIndex;
        boolean 所有要求满足;
        String 文件名;
        public 当前装备信息(int xIndex, int yIndex, int x, int y, String 文件名) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.x=x;
            this.y=y;
            this.文件名=文件名;
            所有要求满足=true;
        }
    }

    public static StringBuilder output = new StringBuilder();
    public static List<当前装备信息> list=new ArrayList<>();
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
    public static boolean 是否扫描和筛选 = false;
//    public static boolean 是否筛选 = true;
    public static boolean 是否标记 = false;
    public static boolean 鼠标是否回到原点 = true;
    public static String folderName = "OutPicture";
    public static String outPictureName = "screenshot";
    public static String outTextName = "output";
    public static Robot robot;
    public static int x轴第几个_起点;
    public static int y轴第几个_起点;
    public static boolean 是否标记起点 =false;

    public static int x轴第几个_终点;
    public static int y轴第几个_终点;

    // 创建一个线程池，例如使用固定数量的线程
    public static int 线程池大小 = Runtime.getRuntime().availableProcessors(); // 您可以根据需要调整线程池的大小
    public static ExecutorService 线程池 = Executors.newFixedThreadPool(线程池大小);

    // 创建一个列表来保存Future对象
    public static List<Future<?>> futures = new ArrayList<>();

    public static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    public static int 还有几个 = 0;






    public static String savePicture(int x, int y, Robot robot) {

        int arg1 = x - 430; // 传递给方法的参数
        int arg2 = 90; // 传递给方法的参数
        int arg3 = 380; // 传递给方法的参数
        int arg4 = 690; // 传递给方法的参数

        File directory = new File(folderName);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目标文件夹及其父文件夹（如果不存在）
        }

        String fileName="";

        try {

            // 指定要捕捉的区域
            Rectangle screenRect = new Rectangle(arg1, arg2, arg3, arg4); // (x, y, width, height)

            // 捕捉屏幕区域的图像
            BufferedImage screenshot = robot.createScreenCapture(screenRect);

            fileName=folderName + "/" + outPictureName +"_"+x+"_"+y+"_"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";

            // 保存图像为文件
//            File output = new File(folderName + "/" + outPictureName + ".png");
//            ImageIO.write(screenshot, "png", output);

            File output1 = new File(fileName);
            ImageIO.write(screenshot, "png", output1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }


    public static void voice(String fileName,long time) {
        String audioFilePath = fileName; // 替换为你的音频文件路径

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
            Thread.sleep(time);

            // 关闭 Clip
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void 标记起点(){

        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

        x轴第几个_起点 = (int) (Math.floor((x - 左线) / 单个宽度));
        y轴第几个_起点 = (int) (Math.floor((y - 上线) / 单个高度));

        是否标记起点 =true;


    }

    public static void run(Robot robot1, 筛选装备_子类 筛选装备_子类) {
        robot=robot1;
        list.clear();
        output.setLength(0);


        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY();



        x轴第几个_终点 = (int) (Math.floor((x - 左线) / 单个宽度));
        y轴第几个_终点 = (int) (Math.floor((y - 上线) / 单个高度));

        File directory = new File(folderName);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目标文件夹及其父文件夹（如果不存在）
        }

        int x轴第几个=0;
        int y轴第几个=0;

        if(是否标记起点 ==true) {
            x轴第几个=x轴第几个_起点;
            y轴第几个=y轴第几个_起点;
        }

        while (是否扫描和筛选 ==true){
            扫描(x轴第几个,y轴第几个);


            x轴第几个++;
            if (x轴第几个 > 横向数量-1) {
                y轴第几个++;
                x轴第几个 = 0;
            }
            if(是否标记起点 ==false) {
                if (y轴第几个 < 0) {
                    break;
                }
            }else {
                if(y轴第几个> y轴第几个_终点){
                    break;
                }
                if(y轴第几个== y轴第几个_终点){
                    if(x轴第几个> x轴第几个_终点){
                        break;
                    }
                }
            }
        }



        voice("custom/yy.wav",250);
        还有几个=list.size();
        clipboard.setContents(new StringSelection("总共有: "+还有几个), null);


        // 遍历装备信息列表并提交任务给线程池
        for (当前装备信息 当前装备信息:list) {
            if (是否扫描和筛选) {
            Future<?> future = 线程池.submit(() -> {
                筛选_包裹(筛选装备_子类, 当前装备信息);
            });
            futures.add(future);
            }
        }

        // 关闭线程池并等待所有任务完成
        线程池.shutdown();
        try {
            线程池.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // 将内容保存到文件
        String fileName = folderName + "/" + outTextName + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(output.toString());
            writer.close();
            System.out.println("内容已保存到 " + fileName);
        } catch (IOException e) {
            System.out.println("保存文件时出现错误：" + e.getMessage());
        }

        voice("custom/结束.wav",600);

        是否标记起点 =false;
    }

    public static void run1() {
        for(当前装备信息 当前装备信息:list){
            if(是否标记 == false){break;}

            标记(当前装备信息);
        }

    }

    public static void 扫描(int x轴第几个, int y轴第几个){
        int 标准化x = (int) (x轴第几个 * 单个宽度 + 单个宽度 / 2) + 左线;
        int 标准化y = (int) (y轴第几个 * 单个高度 + 单个高度 / 2 + 上线);
        robot.mouseMove(标准化x, 标准化y);
        IFunctions.pause(300);
        String fileName=savePicture(标准化x, 标准化y, robot);
        当前装备信息 当前装备信息=new 当前装备信息(x轴第几个,y轴第几个,标准化x,标准化y,fileName);
        list.add(当前装备信息);
    }


    public static void 筛选_包裹(筛选装备_子类 筛选装备_子类,当前装备信息 当前装备信息){
        if(是否扫描和筛选==true) {
            筛选(筛选装备_子类, 当前装备信息);
        }
    }
    public static void 筛选(筛选装备_子类 筛选装备_子类,当前装备信息 当前装备信息){
        boolean 是否报错 = false;
        筛选逻辑参数 筛选逻辑参数 = new 筛选逻辑参数();
        筛选逻辑参数.要的词缀_容器 = 筛选装备_子类.要的词缀();
        筛选逻辑参数.不要的词缀_容器 = 筛选装备_子类.不要的词缀();
        筛选逻辑参数.装备种类 = 装备种类.未定种类;
        筛选逻辑参数.initPrimitiveDataType(筛选装备_子类.需求词条数量_要求(),筛选装备_子类.数值大于多少算优秀(),筛选装备_子类.物品强度大于多少算优秀());

        List<String> 图片解析出的所有词条 = new ArrayList<>();
        List<String> 需求词条 = new ArrayList<>();

        int 物品强度索引 = 0;
        int 物品强度索引temp = 0;
        int 装备时损失属性索引 = 0;
        int 装备时损失属性索引temp = 0;

        StringBuilder 一件装备的所有文本=new StringBuilder();

        try {
            // 构建命令
//                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "C:/Users/aaa/.conda/envs/paddle_env/Scripts/paddleocr --image_dir " + folderName + "/" + outPictureName + ".png --use_angle_cls false --use_gpu false");
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "C:/Users/aaa/.conda/envs/paddle_env/Scripts/paddleocr --image_dir " + 当前装备信息.文件名+" --use_angle_cls false");

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


                // 找到元组开始的位置和结束的位置
                int tupleStartIndex = line.indexOf('(');
                int tupleEndIndex = line.lastIndexOf(')');

                if (tupleStartIndex != -1 && tupleEndIndex != -1) {
                    // 提取元组部分
                    String tuple = line.substring(tupleStartIndex + 1, tupleEndIndex);

                    // 切分元组，取得文本部分
                    String[] tupleParts = tuple.split(",");

                    if (tupleParts.length >= 1) {
                        String textPart = tupleParts[0].trim();

                        // 去掉单引号，获得最终的文本
                        String extractedText = textPart.replaceAll("'", "").trim();
                        图片解析出的所有词条.add(extractedText);

                        一件装备的所有文本.append(line).append("\n");




                        if (extractedText.contains("戒指")) {
                            筛选逻辑参数.预类别=预类别.戒指;
                        } else if (extractedText.contains("护符")) {
                            筛选逻辑参数.预类别=预类别.护符;
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

            筛选装备_子类.装备分类(图片解析出的所有词条, 筛选逻辑参数);


            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("Command exited with code: " + exitCode);

            // 关闭资源
            reader.close();
            inputStream.close();

            List<String> 是词缀的部分_物品强度=图片解析出的所有词条.subList(物品强度索引 , 物品强度索引+1);
            if(筛选逻辑参数.预类别==预类别.戒指){
                物品强度索引+=2;
            }else if(筛选逻辑参数.预类别==预类别.护符){
                物品强度索引 += 1;
            }
            List<String> 是词缀的部分 = 图片解析出的所有词条.subList(物品强度索引 + 1, 装备时损失属性索引);
            是词缀的部分_物品强度.addAll(是词缀的部分);
            是词缀的部分=是词缀的部分_物品强度;



            筛选逻辑参数.是词缀的部分_容器 = 是词缀的部分;
            筛选逻辑参数.需求词条 = 需求词条;



            if (筛选逻辑参数.装备种类.equals(装备种类.自定要求)) {
                筛选装备_子类.自定筛选(筛选逻辑参数);
            } else {
                筛选逻辑(筛选逻辑参数);
                if (筛选逻辑参数.装备种类.equals(装备种类.只看数值)) {
                    if (筛选逻辑参数.数值优秀) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                } else if (筛选逻辑参数.装备种类.equals(装备种类.只看物品强度)) {
                    if (筛选逻辑参数.物品强度优秀) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                }else if (筛选逻辑参数.装备种类.equals(装备种类.只看属性)) {
                    if (筛选逻辑参数.需求词条数量是否满足) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                } else if (筛选逻辑参数.装备种类.equals(装备种类.看数值或看属性)) {
                    if (筛选逻辑参数.数值优秀 || 筛选逻辑参数.需求词条数量是否满足) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                }else if (筛选逻辑参数.装备种类.equals(装备种类.看数值且看属性)) {
                    if (筛选逻辑参数.数值优秀 && 筛选逻辑参数.需求词条数量是否满足) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                }else {
                    if (筛选逻辑参数.数值优秀 || 筛选逻辑参数.需求词条数量是否满足) {
                        筛选逻辑参数.所有要求满足 = true;
                    }
                }
            }

        } catch (Exception e) {
            是否报错 = true;
            e.printStackTrace();
        }




        一件装备的所有文本.append("-----需求词条: ").append(需求词条).append("\n");
        一件装备的所有文本.append("-----需求词条数量: ").append(筛选逻辑参数.需求词条数量).append("\n");
        一件装备的所有文本.append("-----数值: ").append(筛选逻辑参数.数值).append("\n");
        一件装备的所有文本.append("-----数值优秀: ").append(筛选逻辑参数.数值优秀).append("\n");
        一件装备的所有文本.append("-----预类别: ").append(预类别.values()).append("\n");
        一件装备的所有文本.append("-----物品强度: ").append(筛选逻辑参数.物品强度).append("\n");
        一件装备的所有文本.append("-----装备种类: ").append(筛选逻辑参数.装备种类).append("\n");
        一件装备的所有文本.append("-----所有要求满足: ").append(筛选逻辑参数.所有要求满足).append("\n");
        一件装备的所有文本.append("===============================================================================").append("\n");

        output.append(一件装备的所有文本);


        if (筛选逻辑参数.所有要求满足) {
        } else {
            if (是否报错 == false) {
                当前装备信息.所有要求满足=false;

            }
        }

        voice("custom/yy.wav",250);
        还有几个--;
        clipboard.setContents(new StringSelection("还有几个: "+还有几个), null);
    }



    public static void 标记(当前装备信息 当前装备信息){
        long time=50L;
        robot.mouseMove(当前装备信息.x,当前装备信息.y);
        IFunctions.pause(time);
        if(当前装备信息.所有要求满足==false) {
            robot.keyPress(VK_SPACE);
            IFunctions.pause(time);
            robot.keyRelease(VK_SPACE);
        }
        IFunctions.pause(time);

    }

    public static void 筛选逻辑(筛选逻辑参数 筛选逻辑参数) {


        boolean 是否是是数值=false;
        for (String s : 筛选逻辑参数.是词缀的部分_容器) {
            if (s.contains("每秒伤害") || s.contains("护甲值")||是否是是数值==true) {
                if(是否是是数值==true){
                    是否是是数值=false;
                }else {
                    是否是是数值=true;
                }

                Pattern pattern = Pattern.compile("([+-]{1})(\\d+)");
                Matcher matcher = pattern.matcher(s);

                if(matcher.find()) {
//                    matcher.find();

                    String sign = matcher.group(1); // 符号
                    int number = Integer.parseInt(matcher.group(2)); // 数字


                    if (sign.equals("-")) {
                        筛选逻辑参数.数值 = -number;
                    } else {
                        筛选逻辑参数.数值 = number;
                    }


                    if (筛选逻辑参数.数值 >= 筛选逻辑参数.数值大于多少算优秀) {
                        筛选逻辑参数.数值优秀 = true;
                    }
                }
            }
            if (s.contains("物品强度")) {

                Pattern pattern = Pattern.compile("(\\d+)物品强度");
                Matcher matcher = pattern.matcher(s);

                matcher.find();

                String 物品强度 = matcher.group(1);


                筛选逻辑参数.物品强度= Integer.parseInt(物品强度);

                if (筛选逻辑参数.物品强度 >= 筛选逻辑参数.物品强度大于多少算优秀) {
                    筛选逻辑参数.物品强度优秀 = true;
                }
            }
            for (String s1 : 筛选逻辑参数.要的词缀_容器) {
                boolean 要的词缀是否包含不要的词缀 = false;
                if (s.contains(s1)) {
                    for (String s2 : 筛选逻辑参数.不要的词缀_容器) {
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
            if (筛选逻辑参数.需求词条数量 >= 筛选逻辑参数.需求词条数量_要求) {
                筛选逻辑参数.需求词条数量是否满足 = true;
            }
        }

    }

    static class 筛选逻辑参数 {
        List<String> 是词缀的部分_容器;
        int 数值;
        int 物品强度;
        boolean 数值优秀;
        boolean 物品强度优秀;
        String[] 要的词缀_容器;
        String[] 不要的词缀_容器;
        int 需求词条数量;
        List<String> 需求词条;
        int 需求词条数量_要求;
        boolean 需求词条数量是否满足;
        boolean 所有要求满足;
        装备种类 装备种类;
        int 数值大于多少算优秀;
        int 物品强度大于多少算优秀;
        预类别 预类别;

        public void initPrimitiveDataType(int 需求词条数量_要求,int 数值大于多少算优秀,int 物品强度大于多少算优秀){
            this.物品强度=0;
            this.数值优秀=false;
            this.需求词条数量=0;
            this.需求词条数量_要求=需求词条数量_要求;
            this.需求词条数量是否满足=false;
            this.所有要求满足=false;
            this.数值大于多少算优秀=数值大于多少算优秀;
            this.数值=数值大于多少算优秀-1;
            this.物品强度大于多少算优秀=物品强度大于多少算优秀;
            this.预类别=预类别.其他;
            this.物品强度优秀=false;

        }
    }

    enum 装备种类 {
        只看数值,
        只看属性,
        只看物品强度,
        看数值或看属性,
        看数值且看属性,
        自定要求,
        未定种类,
    }

    enum 预类别{
        戒指("戒指"),护符("护符"),其他("其他");
        public String value;
        预类别(String value) {
            this.value=value;
        }
    }

}
