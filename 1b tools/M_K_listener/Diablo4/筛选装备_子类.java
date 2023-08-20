import java.util.List;

public abstract class 筛选装备_子类 {
    public abstract void 自定筛选(筛选装备.筛选逻辑参数 筛选逻辑参数);

    public abstract void 装备分类(List<String> result, 筛选装备.筛选逻辑参数 筛选逻辑参数, String 预类别);
}
