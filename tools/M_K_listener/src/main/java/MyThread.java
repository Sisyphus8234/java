public class MyThread extends Thread {
    public String state="";
    public MyThread(){
        super();
        this.myStart();
        IFunctions.threadList.add(this);
        this.mySuspend();
    }


    public void myStart(){
        start();
        state="start";


    }


    public void mySuspend(){
        suspend();
        state="suspend";
    }

    public void myResume(){
        resume();
        state="resume";
    }

}