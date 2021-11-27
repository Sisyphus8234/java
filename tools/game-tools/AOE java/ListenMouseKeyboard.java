import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboard {
	
	
	int value();
	boolean immediately();
	
}