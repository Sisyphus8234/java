public class MyThread extends Thread {
    public String state="";
    public MyThread(){
        super();
        this.myStart();
        IFunctions.threadList.add(this);
        this.mySuspend();
    }


    public void myStart(){
        state="on";
        start();


    }


    public void mySuspend(){
        state="off";
        suspend();
    }

    public void myResume(){
        state="on";
        resume();
    }

}