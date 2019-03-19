package app.core.concurrency2;

import java.util.concurrent.Callable;

public class StackConsumer implements Callable<Integer> {

    Stack stack;

    public StackConsumer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20; ++i) {
            Integer num = stack.pop();
            System.out.println("Number: " + num);
            sum += num;
            try {Thread.sleep(50);} catch (Exception e) { };
        }

        System.out.println(Thread.currentThread().getId() + " Consumer sum: " + sum);
        if (sum % 2 != 0) {
            throw new Exception(Thread.currentThread().getId() + " From Consumer: Not Event");
        }
        return sum;
    }
}
