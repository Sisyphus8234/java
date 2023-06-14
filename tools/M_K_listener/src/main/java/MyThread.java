public class MyThread extends Thread {
    public String state="";
    public MyThread(){
        super();
        this.start();
        IFunctions.threadList.add(this);
        this.suspend();
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