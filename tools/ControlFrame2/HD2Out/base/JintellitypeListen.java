package base;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@Repeatable(value = JintellitypeListens.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface JintellitypeListen {
//    int identifier();
    int modifier();
    int keycode();

    boolean immediately() default true;
}
