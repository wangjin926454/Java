package designpattern.decoratorpattern;

public class Skill_Q extends Skills{

    private String skillName;

    public Skill_Q(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }
    @Override
    public void learnKills() {
        System.out.println("学习了技能Q:" +skillName);
        super.learnKills();
    }
}