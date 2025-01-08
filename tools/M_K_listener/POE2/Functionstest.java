package custom;

import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.awt.event.KeyEvent.*;


public class Functionstest extends IFunctions {

	@ListenBar(onOrOff = ListenBar.OnOrOff.on)
	public static String on = "home";

	@ListenBar(onOrOff = ListenBar.OnOrOff.off)
	public static String off = "end";





	@ListenMouseKeyboard(key = "h", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,immediately = false,occupyTime = 1000L)
	public static void test(InputInfo inputInfo) {
		//---
		System.out.println("a");
	}

	@ListenMouseKeyboard(key = "h", intercept = true,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,immediately = false,extend = true,occupyTime = 1000L)
	public static void test1(InputInfo inputInfo) {
		//---
		System.out.println("b");
	}







}