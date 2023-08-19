import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Functions野蛮人 extends Functions公共 {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
//    public static Long weight = Long.parseLong(Config.read("Weight"));
    public static boolean t1Temp = false;
    public static boolean t2Temp = false;
    public static boolean 用哪个基础技能 = true;
    public static boolean 随机用哪个基础技能 = true;
    //    public static boolean t2Temp = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 攻击型加移动 = true;

    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;

    public static Random r = new Random();
    public static int i = 0;


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;

    public static 筛选装备_野蛮人 筛选装备_野蛮人=new 筛选装备_野蛮人();

    static {
        t1 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {

//                        if(随机用哪个基础技能==true) {
//                            用哪个基础技能 = r.nextBoolean();
//                        }else {
//                            用哪个基础技能=false;
//                        }
                        if (是否基础技能 == true) {

                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);
                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);


//                            if (用哪个基础技能==true) {

//                            } else {
//                                robot.keyPress(KeyEvent.VK_9);
//                                robot.keyRelease(KeyEvent.VK_9);
//                            }

                        }
                        if(是否核心技能) {

                            pixelColor = robot.getPixelColor(1318, 965);
//                    System.out.println(pixelColor);
//                    200,128,55
                            if(pixelColor.getRed()+
                                    pixelColor.getGreen()+
                                    pixelColor.getBlue()>=270

                            ){


                                robot.keyPress(KeyEvent.VK_4);
                                robot.keyRelease(KeyEvent.VK_4);}
                        }




                    } else {
//                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

                    }
                    pause(baseDelay);
                }
            }
        };


        t2 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {
//
                    if (t2Temp == true) {
                        robot.keyPress(KeyEvent.VK_G);
                        robot.keyRelease(KeyEvent.VK_G);
                    }
                    pause(baseDelay);

                }
            }
        };


        new MyThread("on") {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                    } else {
                    }
                    pause(baseDelay);

                }
            }
        };

        t4=new MyThread("off"){
            @Override
            public void run() {
                while (true) {
                    int x= (int) MouseInfo.getPointerInfo().getLocation().getX();
                    int y= (int) MouseInfo.getPointerInfo().getLocation().getY();

                    筛选装备.run(x,y,robot,筛选装备_野蛮人, 筛选装备_野蛮人.要的词缀, 筛选装备_野蛮人.不要的词缀,筛选装备_野蛮人.有效词条要求);

                    this.mySuspend();
                }
            }
        };



//        t4=new MyThread("off"){
//            @Override
//            public void run() {
//                while (true) {
//                    int x= (int) MouseInfo.getPointerInfo().getLocation().getX();
//                    int y= (int) MouseInfo.getPointerInfo().getLocation().getY();
//
//                    String pythonScript = "C:\\Users\\aaa\\Desktop\\python_project\\get_words_of_picture.py"; // 替换为实际的Python脚本路径
//                    String pythonInterpreter = "C:\\Users\\aaa\\.conda\\envs\\paddle_env\\python.exe"; // Python解释器
//                    String arg1 = String.valueOf(x-437); // 传递给方法的参数
//                    String arg2 = String.valueOf(91); // 传递给方法的参数
//                    String arg3 = "390"; // 传递给方法的参数
//                    String arg4 = "736"; // 传递给方法的参数
//                    try {
//                        ProcessBuilder processBuilder = new ProcessBuilder(
//                                pythonInterpreter, pythonScript, arg1, arg2,arg3,arg4);
//                        Process process = processBuilder.start();
//
//                        InputStream inputStream = process.getInputStream();
//                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//                        BufferedReader reader = new BufferedReader(inputStreamReader);
//                        String result="";
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            System.out.println(line); // 输出Python方法的返回值
//                            result=line;
//                        }
//
//                        int exitCode = process.waitFor();
//                        System.out.println("Python process exited with code " + exitCode);
//
//                        if(result.equals("False")){
//                            robot.keyPress(VK_SPACE);
//                            robot.keyRelease(VK_SPACE);
//
//                            System.out.println("------------------------------space");
//                        }
//
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    this.mySuspend();
//                }
//            }
//        };



    }

//    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = 0)
//    public static void r() {
//
//        t1Temp =true;
//        t1.myResume();
//
//    }
//    @ListenMouseKeyboard(value = 82,press = false, intercept = true,keyboardOrMouse = 0)
//    public static void r1() {
//    }

    @ListenMouseKeyboard(value = 69, intercept = true, keyboardOrMouse = 0)
    public static void e() {
//        攻击型加移动 = true;
//        是否核心技能=false;

        t1Temp = true;
        t2Temp = false;


//                robot.keyRelease(KeyEvent.VK_G);
//        robot.keyPress(KeyEvent.VK_G);
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = 0)
    public static void R() {
//        攻击型加移动 = false;
        t1Temp = false;
        t2Temp = true;

    }


    @ListenMouseKeyboard(value = 514, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = 0)
    public static void w() {
//        暂停t1时是否松开左键 = false;
        t1Temp = false;
        t2Temp = false;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0)
    public static void 侧键_f() {
        t1Temp=false;
        t2Temp=true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp=false;
    }


    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51, keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
    public static void 键盘1() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;

        if (t1Temp == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1Temp = false;

    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = 0)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 = false;
    }



    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, intercept = true)

    @ListenMouseKeyboard(value = 516, keyboardOrMouse = 1)
    public static void 右键() {
        是否核心技能=true;
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, press = false, intercept = true)
    @ListenMouseKeyboard(value = 517, keyboardOrMouse = 1)
    public static void 右键1() {
        是否基础技能 = true;
    }

//    @ListenMouseKeyboard(value = 32, keyboardOrMouse = 0)
//    public static void 空格() {
//        是否核心技能=true;
//    }


//    @ListenMouseKeyboard(value = 523, keyboardOrMouse = 1)
//    public static void 侧键() {
//        是否核心技能 = false;
//    }
//
//
//    @ListenMouseKeyboard(value = 524, keyboardOrMouse = 1)
//    public static void 侧键1() {
//        是否核心技能 = true;
//    }

    @ListenMouseKeyboard(value = 112,keyboardOrMouse = 0,intercept = true)
    public static void 图像识别_装备(){
        筛选装备.是否筛选装备 =true;
        筛选装备.鼠标是否回到原点 =true;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 114,keyboardOrMouse = 0,intercept = true)
    public static void 图像识别_装备1(){
        筛选装备.是否筛选装备 =true;
        筛选装备.鼠标是否回到原点 =false;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 113,keyboardOrMouse = 0,intercept = true)
    public static void 图像识别_装备_终止(){
        筛选装备.是否筛选装备 =false;
    }


}
