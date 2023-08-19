import java.util.concurrent.atomic.AtomicReference;

public class 筛选装备_野蛮人 extends 筛选装备_子类 {
    public String[] 要的词缀 = {"攻击速度", "暴击几率", "先祖之锤", "点力量", "点敏捷", "点意力", "点全属性", "核心技能伤害", "抗性", "伤害减免", "移动速度", "易伤伤害"
            , "生命上限", "物理伤害", "对近距敌人的伤害", "怒气", "冷却", "----对流血敌人的---", "敌人的伤害减免", "使用双手钝击武器的伤害","强固时","总护甲"};
    public String[] 不要的词缀 = {"受伤状态下的伤害减免", "对受伤敌人的暴击几率","对流血敌人的"};
    public int 有效词条要求=3;
    @Override
    public void f1(String extractedText, AtomicReference<String> 类别) {
        if (extractedText.contains("双手锤")) {
            类别.set(筛选装备.装备种类.get(0));
        } else if (extractedText.contains("护甲值")) {
            类别.set(筛选装备.装备种类.get(1));
        } else if (!extractedText.contains("双手") && (extractedText.contains("斧") || extractedText.contains("剑") || extractedText.contains("锤"))) {
            类别.set(筛选装备.装备种类.get(1));
        }else if(extractedText.contains("双手")&&(extractedText.contains("长柄")||extractedText.contains("劈砍"))) {
            类别.set(筛选装备.装备种类.get(2));
        }


    }
}
