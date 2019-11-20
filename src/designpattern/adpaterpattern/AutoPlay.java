package designpattern.adpaterpattern;

public class AutoPlay implements IPhone {
    @Override
    public void play(String type, String title) {
        //内置方法
        if(title.equalsIgnoreCase("wzry")){
            System.out.println("playing wzry");
        }
        //我搞不定的方法送出去
        else if(title.equalsIgnoreCase("lol")||title.equalsIgnoreCase("jdqs")){
            //搞不定送出去的方法做一个初始化标识
            AutoPlayAdpater adpater = new AutoPlayAdpater(title);
            adpater.play(type,title);
        }
        //其他方法无法执行
        else {
            System.out.println("not found this type"+title);
        }
    }
}
