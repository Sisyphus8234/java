package custom;

import java.util.List;

public class 筛选装备_游侠 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"攻击速度", "暴击几率", "回旋刀锋", "点力量", "点敏捷", "点智力", "点全属性", "核心技能伤害", "抗性", "伤害减免", "易伤"
            , "生命上限", "物理伤害", "对近距敌人的伤害", "敌人的伤害减免", "总护甲", "%伤害", "使用双持武器", "毒素灌注", "所有灌注技能", "被灌注的技能",
             "能量", "暴击伤害", "---------对受陷阱技能影响敌人", "对中毒敌人","-----毒素伤害","----持续性伤害","恶意","幸运一击几率","被动"};
    public String[] 不要的词缀 = {"受伤状态下的伤害减免", "对受伤敌人的暴击几率", "被灌注技能的暴击伤害", "能量上限","对中毒敌人的伤害减免"};
    public int 需求词条数量_要求 = 3;
    public int 数值大于多少算优秀 = -15;

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
    public void 装备分类(List<String> result, 筛选装备.筛选逻辑参数 筛选逻辑参数, String 预类别) {
        for (String extractedText : result) {
            if (extractedText.contains("匕首") || (extractedText.contains("剑") && !extractedText.contains("双手"))) {
                筛选逻辑参数.装备种类 = (筛选装备.装备种类.只看数值);
                break;
            } else if (extractedText.contains("弓")||extractedText.contains("弩")) {
                筛选逻辑参数.装备种类 = (筛选装备.装备种类.只看属性);
                break;
            }else if (extractedText.contains("护甲值")) {
                筛选逻辑参数.装备种类 = (筛选装备.装备种类.只看属性);
                break;
            }else {
                筛选逻辑参数.装备种类 = 筛选装备.装备种类.看数值或看属性;
            }
        }


        if (预类别.equals("戒指") ) {
            筛选逻辑参数.装备种类 = (筛选装备.装备种类.自定要求);
        }else if(预类别.equals("护符")) {
            筛选逻辑参数.装备种类 = (筛选装备.装备种类.只看属性);
        }
    }


    @Override
    public void 自定筛选(筛选装备.筛选逻辑参数 筛选逻辑参数) {
        筛选逻辑参数.自定要求是否满足 = false;
        for (String s : 筛选逻辑参数.是词缀的部分_容器) {
            if (s.contains("暴击几率")) {
                筛选逻辑参数.自定要求是否满足 = true;
            }
        }


        筛选装备.筛选逻辑(筛选逻辑参数);

        if ((筛选逻辑参数.自定要求是否满足&&筛选逻辑参数.需求词条数量>=2)||(筛选逻辑参数.需求词条数量是否满足)
        ) {
            筛选逻辑参数.所有要求满足 = true;
        }


    }
}
