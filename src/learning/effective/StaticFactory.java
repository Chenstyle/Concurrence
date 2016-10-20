package learning.effective;

/**
 * @author Chenstyle
 *  date 2016/10/20 0020
 *  time 14:15
 */
public class StaticFactory {

    public String mName = StaticFactory.class.getSimpleName();
    public byte mAge = 22;

    private static StaticFactory mStaticFactory = new StaticFactory();

    public static StaticFactory getInstance() {
        return mStaticFactory;
    }

    public void showName() {
        System.out.println(mName);
    }

    private void Test() {
        Boolean.valueOf(true);
    }
}
