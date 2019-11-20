package designpattern.decoratorpattern;

public class Skills implements Hero {
    private Hero hero;
    public Skills(Hero hero){
        this.hero = hero;
    }
    @Override
    public void learnKills() {
        if(hero!=null){
            hero.learnKills();
        }
    }
}
