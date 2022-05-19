import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Repeatable(value = ListenMouseKeyboards.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboard {
	
	
	int value();
	boolean immediately() default true;
	boolean press() default true;
	boolean userInput() default true;
	boolean intercept() default false;

}

