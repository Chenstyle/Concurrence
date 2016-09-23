package jikexueyuan.wiki;

/**
 * 线程中断
 * Created by Chenstyle on 2016/9/23 0023.
 */
class SleepInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("before 20s...");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception...");
            return;
        }
        System.out.println("Start after 20s...");
    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread thread = new Thread(si);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main() Start Interrupt");
        thread.interrupt();
        System.out.println("main() - leaving");
    }
}
