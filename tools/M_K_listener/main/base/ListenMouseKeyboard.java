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

    long timeInterval() default 0L;

    boolean extend() default false;

    int flags() default 0;

    String otherCondition() default "";


    public static class KeyboardOrMouse {
        public static final int Keyboard = 1;
        public static final int Mouse = 2;
    }

    public static class ConditionName {
        public static final String mouseData = "mouseData";
        public static final String flags = "flags";


    }
}

