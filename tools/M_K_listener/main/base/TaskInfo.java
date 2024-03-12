package base;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class TaskInfo {
    public Method method;
    public boolean immediately=true;
    public boolean intercept=false;

    public InputInfo inputInfo;
    public InputInfo inputInfoActualTemp;

    LocalDateTime lastTime=LocalDateTime.now();
}
