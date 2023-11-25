package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 筛选装备_野蛮人 extends 筛选装备_子类 {
    @Override
    public int 物品强度下限() {
        return 810;
    }

    @Override
    public ArrayList<String> 需求词缀_目标() {
        return new ArrayList<>(Arrays.asList("移动速度", "攻击速度", "暴击","力量", "--敏捷", "--意力", "全属性", "核心技能伤害", "抗性", "伤害减免", "--易伤伤害", "生命上限", "物理伤害",
                "对近距敌人的伤害", "怒气上限", "对流血敌人的", "使用双手钝击武器的伤害", "强固", "总护甲", "--%伤害", "资源生成", "--使用双持", "需要切换武器的",
                "冷却时间缩减", "敌人的伤害减免", "--压制", "狂暴", "受到的治疗", "被动"));
    }

    @Override
    public ArrayList<String> 不要词缀_目标() {
        return new ArrayList<>(Arrays.asList(
                "--暗影抗性", "受伤状态下的伤害减免", "--对流血敌人的伤害减免", "对受伤敌人的暴击几率", "闪避获得", "你的药水也会", "闪避的冷却时间"));
    }

    @Override
    public ArrayList<String> 必须词缀_目标() {
        return new ArrayList<>(Arrays.asList(new String[]{}));
    }

    @Override
    public int 必须词缀_减少量() {
        return 0;
    }

    @Override
    public int 需求词条数量_目标() {
        return 3;
    }

    @Override
    public void 装备分类(筛选装备.当前装备情况 当前装备情况) {
        for (String extractedText : 当前装备情况.是词缀的部分_筛选结果) {
            if (当前装备情况.预类别 == 筛选装备.预类别_枚举.戒指) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;

                当前装备情况.必须词缀_目标 = Arrays.asList("暴击几率");
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);

                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                break;
            } else if (当前装备情况.预类别 == 筛选装备.预类别_枚举.护符) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;

                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);

                break;
            } else if (extractedText.contains("双手锤")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
                当前装备情况.物品强度下限 = 890;
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);

                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.需求词缀数量_目标 = 4;
                break;
            } else if (extractedText.contains("每秒伤害")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
                当前装备情况.必须词缀_目标 = Arrays.asList("全属性", "力量");
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);

//                当前装备情况.需求词缀_目标 = ScanFunction.mergeFields(当前装备情况.需求词缀_目标, new String[]{"健康敌人的伤害", "受伤敌人的伤害","压制伤害"});
//                当前装备情况.需求词缀_目标 = ScanFunction.mergeFields(当前装备情况.需求词缀_目标, new String[]{"力量", "全属性"});
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.需求词缀数量_目标 = 4;
                break;
            }
//            else if (extractedText.contains("双手锤")) {
//
//                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
//                当前装备情况.物品强度下限 = 890;
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
//                break;
//            } else if (extractedText.contains("每秒伤害")) {
//                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
//                当前装备情况.需求词缀_目标 = ScanFunction.mergeFields(当前装备情况.需求词缀_目标, new String[]{"健康敌人的伤害", "受伤敌人的伤害"});
//
//                当前装备情况.必须词缀_目标 = new String[]{"全属性", "力量"};
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);
//
//                当前装备情况.需求词缀数量_目标 = 3;
//                break;
//            }
            else if (extractedText.contains("手套")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
                当前装备情况.必须词缀_目标 = Arrays.asList("先祖之锤");
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);


                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.需求词缀数量_目标 = 2;
                break;
            }


//            else if (extractedText.contains("靴子")) {
//                当前装备情况.装备种类= 筛选装备.装备种类_枚举.筛选;
//                当前装备情况.必须词缀_目标 = new String[]{"移动速度"};
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
//                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
//                break;
//            }

            else if (extractedText.contains("靴子")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;

                当前装备情况.需求词缀_目标.removeAll(Arrays.asList("力量","全属性"));
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
                break;
            } else if (extractedText.contains("胸甲") || extractedText.contains("裤子")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;

                当前装备情况.必须词缀_目标 = Arrays.asList("生命上限","伤害减免");
                当前装备情况.必须词缀_减少量 = 1;
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.必须词缀);

                当前装备情况.需求词缀_目标.removeAll(Arrays.asList("力量","全属性"));
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
                break;
            } else if (extractedText.contains("头盔")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;

                当前装备情况.需求词缀_目标.removeAll(Arrays.asList("力量","全属性"));
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
                break;
            } else if (extractedText.contains("护甲值")) {
                当前装备情况.装备种类 = 筛选装备.装备种类_枚举.筛选;
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.需求词缀);
                当前装备情况.筛选哪些.add(筛选装备.筛选哪些_枚举.物品强度);
                break;
            }
        }
    }


    @Override
    public void 自定筛选(筛选装备.当前装备情况 当前装备情况) {
        boolean 自定要求是否满足 = false;
        for (String s : 当前装备情况.是词缀的部分_筛选结果) {
            if (s.contains("移动速度")) {
                自定要求是否满足 = true;
            }
        }

//        筛选逻辑参数.需求词条要求数量--;
        筛选装备.筛选逻辑(当前装备情况);

        if ((当前装备情况.需求词缀数量是否满足) && 自定要求是否满足) {
            当前装备情况.所有要求满足 = true;
        }
    }
}
