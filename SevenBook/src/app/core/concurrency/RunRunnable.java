package app.core.concurrency;

public class RunRunnable {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        //t1.setDaemon(true); //set to true if you want the jvm to close it (in this case the thread code will probably no run)
        t1.start();
        try {
            t1.join();
        }
        catch (Exception e) {
           e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println("main thread " + i);
        }
        System.out.println("done!");
    }
}
