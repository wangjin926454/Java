package effectivejava;

import java.util.List;

public class SpellChecker {
    private final Object object;
    //创建新实例时将资源传递到构造器中
    public SpellChecker(Object object){
        this.object=object;
    }
    public boolean isValid(String word){
        return false;
    }
    public List<String> suggestions(String type){
        return null;
    }
}
