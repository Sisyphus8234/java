package custom;

import base.Controller;
import base.IFunctions;

public class Main {
    public static void main(String[] s){
        Controller.printKey=false;
        Controller.run(Functions.class, IFunctions.class);
    }
}
