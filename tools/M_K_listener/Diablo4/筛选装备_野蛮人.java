package custom;

import java.util.List;

public class 筛选装备_野蛮人 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"攻击速度", "暴击几率", "先祖之锤", "点力量", "点敏捷", "点意力", "点全属性", "核心技能伤害", "抗性", "伤害减免", "移动速度", "易伤伤害"
            , "生命上限", "物理伤害", "对近距敌人的伤害", "怒气", "冷却", "----对流血敌人的---", "敌人的伤害减免", "使用双手钝击武器的伤害","强固时","总护甲","%伤害"};
    public String[] 不要的词缀 = {"受伤状态下的伤害减免", "对受伤敌人的暴击几率","对流血敌人的"};
    public int 需求词条数量_要求 =3;

    public int 数值大于多少算优秀 = -10;
    public int 物品强度大于多少算优秀 = -10;

    @Override
    public int 物品强度下限() {
        return 物品强度大于多少算优秀;
    }


    @Override
    public String[] 需求词缀_目标() {
        return 要的词缀;
    }

    @Override
    public String[] 不要词缀_目标() {
        return 不要的词缀;
    }

    @Override
    public String[] 必须词缀_目标() {
        return new String[0];
    }

    @Override
    public int 必须词缀_减少量() {
        return 0;
    }

    @Override
    public int 需求词条数量_要求() {
        return 需求词条数量_要求;
    }

    @Override
    public void 装备分类(List<String> result, 筛选装备.当前装备情况 当前装备情况) {
        for(String extractedText:result) {
            if (extractedText.contains("双手锤")) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看数值);
                break;
            } else if (extractedText.contains("靴子")) {
                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.自定要求);
                break;
            } else if (extractedText.contains("护甲值")) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
                break;
            } else if (!extractedText.contains("双手") && (extractedText.contains("斧") || extractedText.contains("剑") || extractedText.contains("锤"))) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
                break;
            } else if ((extractedText.contains("双手") && extractedText.contains("劈砍")) || extractedText.contains("长柄武器")) {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.只看属性);
                break;
            }else {
//                当前装备情况.装备种类 = (筛选装备.装备种类_枚举.看数值或看属性);
            }
        }

        if(当前装备情况.预类别== 筛选装备.预类别_枚举.戒指|| 当前装备情况.预类别== 筛选装备.预类别_枚举.护符){
//            当前装备情况.装备种类=(筛选装备.装备种类_枚举.只看属性);
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

        if((当前装备情况.需求词缀数量是否满足)
        &&自定要求是否满足
        ){
            当前装备情况.所有要求满足=true;
        }
    }
}
