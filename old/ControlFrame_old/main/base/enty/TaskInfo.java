package base.enty;

import base.InputInfo;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

//最小单元
public class TaskInfo {
    public Method method;
    public boolean immediately = true;
    public boolean intercept = false;
    public long occupyTime = 0L;

    public InputInfo inputInfo;
    public InputInfo inputInfoActualTemp;

    public TaskResult taskResult;

    public LocalDateTime lastTime = LocalDateTime.now();
}
