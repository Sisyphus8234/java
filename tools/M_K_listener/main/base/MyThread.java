package base;

public class MyThread extends Thread {

    public static class State{
        public static final int on=1;

        public static final int off=2;
    }
    public int defaultState=State.off;
    public int state;
    public MyThread(){
        super();
        this.myStart();
        IFunctions.threadList.add(this);
    }

    public MyThread(int defaultState){
        this();
        this.defaultState=defaultState;
        if(this.defaultState==State.off){
            this.mySuspend();
        }
    }


    public void myStart(){
        state=State.on;
        start();


    }


    public void mySuspend(){
        state=State.off;
        suspend();
    }

    public void myResume(){
        state=State.on;
        resume();
    }

}