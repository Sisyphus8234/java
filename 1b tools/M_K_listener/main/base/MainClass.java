package base;

import base.Controller;
import base.IFunctions;
import custom.Functions;

public class MainClass {
    public static void main(String[] s){
        new Controller(Functions.class, IFunctions.class);
    }
}
