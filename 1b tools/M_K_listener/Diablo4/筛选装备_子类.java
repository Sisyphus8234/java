package custom;

import java.util.List;

public abstract class 筛选装备_子类 {
    public abstract void 自定筛选(筛选装备.筛选逻辑参数 筛选逻辑参数);

    public abstract void 装备分类(List<String> result, 筛选装备.筛选逻辑参数 筛选逻辑参数, String 预类别);

    public abstract String[] 要的词缀();
    public abstract String[] 不要的词缀();
    public abstract int 需求词条数量_要求();
    public abstract int 数值大于多少算优秀();
}
