package designpattern.adpaterpattern;

public class AutoPlayAdpater implements IPhone{
    private IComputer iComputer;
    //根据title决定让谁来搞事情
    public AutoPlayAdpater(String title){
        if(title.equalsIgnoreCase("lol")){
            iComputer = new LOL();
        }else if(title.equalsIgnoreCase("jdqs")){
            iComputer = new JDQS();
        }
    }

    @Override
    public void play(String type, String title) {
        //搞事
        if(title.equalsIgnoreCase("lol")){
            iComputer.playLOL(title);
        }else if(title.equalsIgnoreCase("jdqs")){
            iComputer.playJDQS(title);
        }
    }
}
