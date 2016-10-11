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

    public static void resetInterrupt() {
        System.out.println("check interrupt = " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("check interrupt = " + Thread.interrupted());
        System.out.println("check interrupt = " + Thread.interrupted());
    }

    public static void getThreadName() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }
    }

    public static void main(String[] args) {
//        checkInterrupt();
//        resetInterrupt();
        getThreadName();
    }
}
