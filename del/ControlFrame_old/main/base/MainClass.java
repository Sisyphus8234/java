package base;

import custom.Functions;

public class MainClass {
    public static void main(String[] s){
        Controller.printKey=false;
        Controller.run(Functions.class, IFunctions.class);
    }
}
