package base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboards {

    ListenMouseKeyboard[] value();

}