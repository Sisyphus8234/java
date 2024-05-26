package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Repeatable(value = ListenMouseKeyboards.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenMouseKeyboard {

    int keyboardOrMouse();

    String key();

    boolean immediately() default true;

    boolean press() default true;

    boolean userInput() default true;

    boolean intercept() default false;


    String note() default "";

    long timeInterval() default 0L;

    boolean extend() default false;


    String otherCondition() default "";

    int active() default -1;




}

