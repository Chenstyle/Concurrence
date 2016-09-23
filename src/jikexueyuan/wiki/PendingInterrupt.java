package jikexueyuan.wiki;

/**
 * 演示待决中断
 * Created by Chenstyle on 2016/9/23 0023.
 */
public class PendingInterrupt {

    public static void checkInterrupt() {
        Thread thread = Thread.currentThread();
        System.out.println("Point A: Check = " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("Point B: Check = " + thread.isInterrupted());
        System.out.println("Point C: Check = " + thread.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }
        System.out.println("Point D: check = " + thread.isInterrupted());
    }

    public static void tryInterrupted() {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("Was NOT interrupted");
        } catch (InterruptedException e) {
            System.out.println("Was interrupted");
        }

        System.out.println("elapsedTime = " + (System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        checkInterrupt();
    }
}
