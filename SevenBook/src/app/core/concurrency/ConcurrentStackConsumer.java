package app.core.concurrency;

public class ConcurrentStackConsumer implements Runnable{
    private ConcurrentStack stack;

    public ConcurrentStackConsumer(ConcurrentStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int popped = stack.pop();
            System.out.println("popped: " + popped);
            try {Thread.sleep(50);} catch (Exception e) { };
        }
    }
}
