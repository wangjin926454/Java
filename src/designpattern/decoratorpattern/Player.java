package designpattern.decoratorpattern;

public class Player {
    public static void main(String[] args) {
        //选择英雄
        Hero hero = new BlindMonk("李青");
        Skills skills = new Skills(hero);
        Skills w = new Skill_W(skills,"金钟罩/铁布衫");
        Skills q = new Skill_Q(w,"天音波/回音击");
        //学习技能
        q.learnKills();
    }
}