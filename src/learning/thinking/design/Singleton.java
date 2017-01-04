package learning.thinking.design;

/**
 * @author Chenstyle
 *         2016/11/28 0028
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton single;

    public static Singleton getInstance() {
        if (single != null) {
            return single;
        } else {
            return new Singleton();
        }
    }


}
