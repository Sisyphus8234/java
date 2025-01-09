package base;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThread extends Thread {

    public LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>();

    synchronized public void getBlock(){
        try {
            queue.put(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void nonBlock() {
        try {
            queue.put(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void block() {
        queue.clear();
    }





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