package designpattern.decoratorpattern;

public class BlindMonk implements Hero {
    private String name;
    public BlindMonk(String name){
        this.name = name;
    }
    @Override
    public void learnKills() {
        System.out.println(name+"学习了以上技能");
    }
}
