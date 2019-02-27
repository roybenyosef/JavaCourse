package app.core.concurrency;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            System.out.println("thread " + i++);
            try {
                Thread.sleep(20);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
