package base;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

//最小单元
public class TaskInfo {
    public Method method;
    public boolean immediately = true;
    public boolean intercept = false;

    public InputInfo inputInfo;
    public InputInfo inputInfoActualTemp;

    public TaskResult taskResult;

    LocalDateTime lastTime = LocalDateTime.now();
}
