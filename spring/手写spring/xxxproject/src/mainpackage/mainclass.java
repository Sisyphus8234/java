package mainpackage;


import java.lang.reflect.InvocationTargetException;

import springA.ApplicationContextA;

public class mainclass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ApplicationContextA a1= new ApplicationContextA(AppConfig.class);
		
		System.out.println(a1.getBean("controller1"));
		
	}

}
