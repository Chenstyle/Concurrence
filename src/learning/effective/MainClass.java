package learning.effective;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String[] args) {
//        StaticFactory.getInstance().showName();
//        String factoryName = StaticFactory.getInstance().mName;
//        int age = StaticFactory.getInstance().mAge;

        AnimalHead head = new AnimalHead.Builder(3).eye(4).nose(4).ear(88).build();
    }

}
