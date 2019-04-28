package designpattern.decoratorpattern;

public class Skill_W extends Skills{

    private String skillName;

    public Skill_W(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }
    @Override
    public void learnKills() {
        System.out.println("学习了技能W:" +skillName);
        super.learnKills();
    }
}