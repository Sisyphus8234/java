package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
public @interface ListenBar {
	
	

	boolean off() default true;

	boolean threadList() default false;


}

