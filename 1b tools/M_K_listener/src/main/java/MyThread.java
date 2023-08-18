public class MyThread extends Thread {
    public String defaultState="off";
    public String state="";
    public MyThread(){
        super();
        this.myStart();
        IFunctions.threadList.add(this);
    }

    public MyThread(String defaultState){
        this();
        this.defaultState=defaultState;
        if(this.defaultState.equals("off")){
            this.mySuspend();
        }
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