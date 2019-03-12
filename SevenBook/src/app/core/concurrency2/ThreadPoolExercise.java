package app.core.concurrency2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExercise {
    public static void main(String[] args) {
        Stack stack = new Stack();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> producerFuture = executor.submit(new StackProducer(stack));
        Future<Integer> consumerFuture = executor.submit(new StackConsumer(stack));

        try {
            System.out.println("Producer result: " + producerFuture.get());
        }
        catch (Exception ex) {
            System.out.println("Producer exception: " + ex.getMessage());
        }

        try {
            System.out.println("Consumer result: " + consumerFuture.get());
        }
        catch (Exception ex) {
            System.out.println("Consumer exception: " + ex.getMessage());
        }
    }
}
