package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Repeatable(value = ListenMouseKeyboards.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboard {

	int keyboardOrMouse();
	int value();
	boolean immediately() default true;
	boolean press() default true;
	boolean userInput() default true;
	boolean intercept() default false;
	int mouseData() default 0;
	String note() default "";

//	public enum KeyboardOrMouse
//	{
//		Keyboard(0), Mouse(1), MouseWithMouseData(2);
//		public  final int value;
//		KeyboardOrMouse(int value)
//		{
//			this.value = value;
//		}
//	}


	public static class KeyboardOrMouse
	{
		public static final int Keyboard=1;
		public static final int Mouse=2;
		public static final int MouseWithMouseData=3;


	}
}

