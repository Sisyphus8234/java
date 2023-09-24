package custom;

import java.util.List;

public class 筛选装备_法师 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"攻击速度", "幸运一击","暴击几率","--点力量", "点敏捷", "--点意力", "点全属性", "核心技能伤害", "抗性", "伤害减免", "易伤伤害"
            , "生命上限", "非物理伤害", "距敌人的伤害", "法力", "冷却时间缩减", "敌人的伤害减免", "双持","总护甲","%伤害","闪电伤害","资源","消耗","电冲技能","连锁闪电","电花"};
    public String[] 不要的词缀 = {"受伤状态下的伤害减免", "对受伤敌人的暴击几率","对燃烧敌人的"};
    public int 需求词条数量_要求 =3;
    public int 数值大于多少算优秀 = -10;
    public int 物品强度大于多少算优秀 = 684;

    @Override
    public int 数值大于多少算优秀() {
        return 数值大于多少算优秀;
    }
    public int 物品强度大于多少算优秀() {
        return 物品强度大于多少算优秀;
    }


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
    public void 装备分类(List<String> result, 筛选装备.当前装备情况 当前装备情况) {
        for(String extractedText:result) {
            if (extractedText.contains("魔杖")||extractedText.contains("匕首")) {
                当前装备情况.物品强度大于多少算优秀=701;
                当前装备情况.装备种类 = (筛选装备.装备种类.只看物品强度);
                break;
            }else if (extractedText.contains("聚能器")) {
                当前装备情况.物品强度大于多少算优秀=704;
                当前装备情况.装备种类 = (筛选装备.装备种类.不要);
                break;
            } else if (extractedText.contains("杖")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.不要);
                break;
            } else if (extractedText.contains("护甲值")) {
                当前装备情况.装备种类 = (筛选装备.装备种类.只看属性);
                break;
            } else {
                当前装备情况.装备种类 = (筛选装备.装备种类.看数值或看属性);
            }
        }

        if(当前装备情况.预类别== 筛选装备.预类别.戒指|| 当前装备情况.预类别==筛选装备.预类别.护符){
            当前装备情况.装备种类=(筛选装备.装备种类.只看属性);
        }
    }


    @Override
    public void 自定筛选(筛选装备.当前装备情况 当前装备情况) {
        boolean 自定要求是否满足=false;
        for (String s : 当前装备情况.是词缀的部分_容器) {
            if(s.contains("移动速度")){
                自定要求是否满足=true;
            }
        }

//        筛选逻辑参数.需求词条要求数量--;
        筛选装备.筛选逻辑(当前装备情况);

        if((当前装备情况.需求词条数量是否满足)
        &&自定要求是否满足
        ){
            当前装备情况.所有要求满足=true;
        }
    }
}
