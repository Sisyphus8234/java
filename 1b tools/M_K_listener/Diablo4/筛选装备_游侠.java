package custom;

import java.util.List;

public class 筛选装备_游侠 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"攻击速度", "暴击几率", "回旋刀锋", "点力量", "点敏捷", "点智力", "点全属性", "核心技能伤害", "抗性", "伤害减免", "易伤"
            , "生命上限", "物理伤害", "对近距敌人的伤害", "敌人的伤害减免", "总护甲", "%伤害", "使用双持武器", "---毒素灌注", "---所有灌注技能", "------被灌注的技能",
             "能量", "暴击伤害", "---------对受陷阱技能影响敌人", "对中毒敌人","-----毒素伤害","----持续性伤害","恶意","幸运一击几率","被动","主要资源","躲闪"};
    public String[] 不要的词缀 = {"受伤状态下的", "对受伤敌人的暴击几率", "被灌注技能的暴击伤害", "能量上限","对中毒敌人的伤害减免","暗影抗性","冰霜抗性"};
    public int 需求词条数量_要求 = 3;
    public int 数值大于多少算优秀 = -75;
    public int 物品强度大于多少算优秀 = 799;

    @Override
    public String[] 要的词缀() {
        return 要的词缀;
    }
    @Override
    public String[] 不要的词缀() {
        return 不要的词缀;
    }

    @Override
    public String[] 必须的词缀() {
        return new String[0];
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
            if (extractedText.contains("匕首") || (extractedText.contains("剑") && !extractedText.contains("双手"))) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看物品强度);
                break;
            } else if (extractedText.contains("弓")||extractedText.contains("弩")) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
                break;
            }else if (extractedText.contains("护甲值")) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
                break;
            }else {
//                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.看数值或看属性;
            }
        }


        if (当前装备情况.预类别== 筛选装备.预类别_枚举.戒指) {
            当前装备情况.装备种类 = (筛选装备.装备种类_枚举.自定要求);
        }else if(当前装备情况.预类别== 筛选装备.预类别_枚举.护符) {
//            当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
        }
    }


    @Override
    public void 自定筛选(筛选装备.当前装备情况 当前装备情况) {
        boolean 自定要求是否满足 = false;
        for (String s : 当前装备情况.是词缀的部分_容器) {
            if (s.contains("暴击几率")) {
                自定要求是否满足 = true;
            }
        }


        筛选装备.筛选逻辑(当前装备情况);

        if ((自定要求是否满足&& 当前装备情况.需求词条数量>=2)||(当前装备情况.需求词条数量是否满足)
        ) {
            当前装备情况.所有要求满足 = true;
        }


    }
}
