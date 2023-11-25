package base;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class TaskInfo {
    public Method method;
    public boolean immediately;
    public boolean intercept;

    public InputInfo inputInfo;

    LocalDateTime lastTime=LocalDateTime.now();
}
