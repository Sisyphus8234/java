package custom;

import java.util.List;

public class 筛选装备_死灵 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"暴击几率", "点力量", "点敏捷", "点智力","点意力", "点全属性", "抗性", "伤害减免", "易伤"
            , "生命上限", "总护甲", "%伤害", "暴击几率","暴击伤害", "幸运一击几率","被动","生命上限","总护甲","冷却","攻击速度","移动速度","物理伤害","对远距敌人的伤害","骷髅","召唤","仆从"};
    public String[] 不要的词缀 = {};
    public int 需求词条数量_要求 = 3;
    public int 数值大于多少算优秀 = -75;
    public int 物品强度大于多少算优秀 = 714;

    @Override
    public String[] 要的词缀() {
        return 要的词缀;
    }
    @Override
    public String[] 不要的词缀() {
        return 不要的词缀;
    }
    @Override
    public int 需求词条数量_要求() {
        return 需求词条数量_要求;
    }
    @Override
    public int 数值大于多少算优秀() {
        return 数值大于多少算优秀;
    }
    @Override
    public int 物品强度大于多少算优秀() {
        return 物品强度大于多少算优秀;
    }

    @Override
    public void 装备分类(List<String> result, 筛选装备.当前装备情况 当前装备情况) {
        for (String extractedText : result) {
            if (extractedText.contains("双手")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.只看物品强度);
                break;
            }else if (extractedText.contains("每秒伤害")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.自定要求);
                break;
            } else if (extractedText.contains("盾")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.自定要求);
                break;
            }else if (extractedText.contains("护甲值")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.只看属性);
                break;
            }else {
                当前装备情况.装备种类 = 筛选装备.装备种类.只看属性;
            }
        }


        if (当前装备情况.预类别== 筛选装备.预类别.戒指) {
            当前装备情况.装备种类 = (筛选装备.装备种类.只看属性);
        }else if(当前装备情况.预类别== 筛选装备.预类别.护符) {
            当前装备情况.装备种类 = (筛选装备.装备种类.只看属性);
        }
    }


    @Override
    public void 自定筛选(筛选装备.当前装备情况 当前装备情况) {

        当前装备情况.所有要求满足 = false;



    }
}
