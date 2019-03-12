package app.core.concurrency2;

import java.util.concurrent.Callable;

public class StackProducer implements Callable<Integer> {

    Stack stack;

    public StackProducer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20; ++i) {
            int num = (int) (Math.random() * 100);
            sum += num;
            stack.push(num);
            try {Thread.sleep(50);} catch (Exception e) { };
        }

        System.out.println("Producer sum: " + sum);
        if (sum % 2 != 0) {
            throw new Exception("From Producer: Not Event");
        }
        return sum;
    }
}
