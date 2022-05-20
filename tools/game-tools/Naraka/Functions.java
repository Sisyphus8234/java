import com.melloware.jintellitype.JIntellitype;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions extends IFunctions {

    public static boolean temp1 = false;
    public static boolean temp2 = false;
    public static boolean temp3 = false;
    public static Date time1 = new Date();

//    static {
//
//		new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(35);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//					if (temp2 == true) {
//						robot.keyRelease(KeyEvent.VK_E);
//						robot.keyPress(KeyEvent.VK_E);
//						robot.keyRelease(KeyEvent.VK_E);
//						try {
//							Thread.sleep(200);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//
//					if (temp3 == true) {
////					try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
//						robot.keyRelease(KeyEvent.VK_ALT);
//
//						robot.keyPress(KeyEvent.VK_ALT);
//
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						robot.keyRelease(KeyEvent.VK_ALT);
//
//
//					}
//
//
//				}
//
//			}
//		}.start();
//
//		new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(35);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//					if (temp1 == true) {
//						robot.keyRelease(KeyEvent.VK_SPACE);
//						robot.keyPress(KeyEvent.VK_SPACE);
//
//						try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}.start();
//	}

    static {
        new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));
                    if (temp1 == true) {
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.keyPress(KeyEvent.VK_SPACE);
                        pause(500);
                    }
                }

            }
        };

        new CreateThread(){
            @Override
            public void myFunction() {
                while (true) {
                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));

					if (temp2 == true) {
						robot.keyRelease(KeyEvent.VK_E);
						robot.keyPress(KeyEvent.VK_E);
						robot.keyRelease(KeyEvent.VK_E);
						pause(200);
					}

					if (temp3 == true) {
						robot.keyRelease(KeyEvent.VK_ALT);
						robot.keyPress(KeyEvent.VK_ALT);
						pause(50);
						robot.keyRelease(KeyEvent.VK_ALT);
					}
				}
			}
        };
    }

    @ListenMouseKeyboard(value = 32, intercept = true)
    private static void space() {
        temp1 = true;
    }

    @ListenMouseKeyboard(value = 32, intercept = true, press = false)
    private static void space2() {
        temp1 = false;
    }

//	@ListenMouseKeyboard(value=32,intercept = true)
//	private static void space() {
//
//		if(temp1==true&&new Date().getTime()-time1.getTime()>=400){
//			System.out.println("程序按下space");
//		robot.keyRelease(KeyEvent.VK_SPACE);
//		robot.keyPress(KeyEvent.VK_SPACE);
//		temp1=false;
//time1=new Date();
//
//		}
//	}
//	@ListenMouseKeyboard(value=32,press = false,intercept = true)
//	private static void space2() {
//		temp1=true;
//	}


    //拾取物品
    @ListenMouseKeyboard(value = 69, intercept = true)
    private static void e() {
        temp2 = true;
    }
    @ListenMouseKeyboard(value = 69, press = false, intercept = true)
    private static void e2() {
        temp2 = false;
    }

    //拉人 T
    @ListenMouseKeyboard(value = 84, intercept = true)
    private static void t() {
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_E);
    }
    @ListenMouseKeyboard(value = 84, press = false, intercept = true)
    private static void t2() {
        robot.keyRelease(KeyEvent.VK_E);
    }



    //振刀
    @ListenMouseKeyboard(value = 523)
    private static void zhendao() {
        temp3 = true;
    }

    @ListenMouseKeyboard(value = 524)
    private static void zhendao2() {
        temp3 = false;
    }


}
