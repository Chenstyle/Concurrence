package jikexueyuan.wiki;

/**
 * 多线程的实现方法
 * Created by Chenstyle on 2016/9/23 0023.
 */

class MyThread implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}


public class ThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
    }
}
