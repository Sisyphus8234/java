package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
public @interface ListenBar {
	int onOrOff() default OnOrOff.off;
	boolean threadList() default false;
	public static class OnOrOff{
		public static final int on=1;
		public static final int off=2;

	}


}

