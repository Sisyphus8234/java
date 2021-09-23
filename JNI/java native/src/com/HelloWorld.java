package com;

class HelloWorld{

	public native void hello(String name);

	static{
		System.loadLibrary("mydll");
	}

	public static void main(String[] args){
		new HelloWorld().hello("jni");
	}

}



//cmd命令
//javac HelloWorld.java
//javah com.HelloWorld
//gcc -m64 -Wl,--add-stdcall-alias -I"F:\Java\jdk1.8.0_301\include" -I"F:\Java\jdk1.8.0_301\include\win32" -shared -o mydll.dll hello.c
//java com.HelloWorld