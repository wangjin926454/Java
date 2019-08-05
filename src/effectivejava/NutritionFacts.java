package effectivejava;
/**
 * 当构造函数参数非常多的时候使用此builder方法创建良好的构造函数
 * 缺点：
 * 此方法的缺陷是很难编写客户端代码，读者很难读懂这些值得意思。而一长串参数可能会导致<br>
 * 程序员在无意中错误地设置了参数而编译器并不会报错，但是在运行时会出现错误行为。<br>
 * (参数太多眼花放错位置或者少放而且无法直观看出某个参数在构造函数中的对应位置)<br>
 * */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts() {
        this(0);
    }

    public NutritionFacts(int servingSize) {
        this(servingSize,0);
    }

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize,servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
    //类推
    //.........................
    //................................................
}
