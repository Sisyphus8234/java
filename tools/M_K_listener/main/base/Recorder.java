package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Recorder {


    boolean press() default true;

    boolean userInput() default true;

    String note() default "";

    long timeInterval() default 0L;


}

