package work.test.inner;

/**
 * Created by Chenstyle on 2016/10/11 0011.
 */
public class TestInner {
    InnerOfInner inner = new InnerOfInner();

    String name = TestInner.class.getSimpleName() +" and "+ inner.name;

    void sayHello() {
        System.out.println(name + " sayHello...");
    }

    static class InnerOfInner{
        String name = InnerOfInner.class.getSimpleName();
        void sayHello() {
            System.out.println(name + "sayHello...");
        }
    }

}


