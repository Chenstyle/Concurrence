package learning.effective;

import learning.thinking.design.Singleton;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String args[]) {

        new Child();

    }
}

class Child extends Parent {
    private int i = 22;

    public Child() {
        i = 222;
    }

    public void display() {
        System.out.println(i);
    }
}

class Parent {
    private int i = 2;

    public Parent() {
        display();
    }

    public void display() {
        System.out.println(i);
    }
}



