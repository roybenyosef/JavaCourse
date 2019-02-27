package app.core.concurrency;

public class ConcurrentStackProducer implements Runnable{

    private ConcurrentStack stack;

    public ConcurrentStackProducer(ConcurrentStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            stack.push((int) (Math.random() * 100));
          //  System.out.println("after pushing: " + stack.toString());
            try {Thread.sleep(50);} catch (Exception e) { };
        }
    }
}
