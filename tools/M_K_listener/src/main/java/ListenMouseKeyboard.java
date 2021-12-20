import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Repeatable(ListenMouseKeyboards.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboard {
	
	
	int value();
	boolean immediately();
	
}

