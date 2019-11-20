package effectivejava;

public class NewNutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        private final int servingSize;
        private final int servings;
        private  int calories = 0;
        private  int fat = 0;
        private  int sodium = 0;
        private  int carbohydrate = 0;
        //两个必要参数
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories=val;
            return this;
        }
        public Builder fat(int val){
            fat=val;
            return this;
        }
        public Builder sodium(int val){
            sodium=val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate=val;
            return this;
        }
        public NewNutritionFacts build(){
            return new NewNutritionFacts(this);
        }
    }
    private NewNutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
    public static void main(String[] args){
        NewNutritionFacts co = new Builder(240,8)
                .calories(100).sodium(35).build();
        System.out.println(co.calories);
    }
}
