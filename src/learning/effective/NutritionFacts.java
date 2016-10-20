package learning.effective;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 15:05
 * 《Effective Java》 P11 Builder pattern
 */
public class NutritionFacts {
    private final int servingSize; // 份量
    private final int servings; // 一份
    private final int calories; // 卡路里
    private final int fat;  // 脂肪
    private final int sodium; // 钠
    private final int carbohydrate; // 碳水化合物

    public static class Builder {
        // Required parameter
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default value
        private int calories     = 0;
        private int fat          = 0;
        private int carbohydrate = 0;
        private int sodium       = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
