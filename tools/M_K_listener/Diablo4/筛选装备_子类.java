package custom;

import java.util.List;

public abstract class 筛选装备_子类 {
    public abstract void 自定筛选(筛选装备.当前装备情况 当前装备情况);
    public abstract void 装备分类(List<String> result, 筛选装备.当前装备情况 当前装备情况);
    public abstract String[] 需求词缀_目标();
    public abstract String[] 不要词缀_目标();
    public abstract String[] 必须词缀_目标();
    public abstract int 必须词缀_减少量();
    public abstract int 需求词条数量_要求();
    public abstract int 物品强度下限();
}
