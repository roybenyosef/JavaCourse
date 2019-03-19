package app.core.concurrency2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExercise {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futures = new ArrayList<>();
//        futures.add(executor.submit(new StackProducer(stack)));
//        futures.add(executor.submit(new StackProducer(stack)));
//        futures.add(executor.submit(new StackProducer(stack)));
//
//        futures.add(executor.submit(new StackConsumer(stack)));
//        futures.add(executor.submit(new StackConsumer(stack)));
//        futures.add(executor.submit(new StackConsumer(stack)));





        for (Future<Integer> future : futures) {
            try {
                System.out.println("Producer result: " + future.get());
            }
            catch (Exception ex) {
                System.out.println("Producer exception: " + ex.getMessage());
            }
        }

        //see extreme java day 2, page 139
//        //we can shutdown the executor here.
//        //or use daemon threads:
//        public class MyThreadFactory implments Threadfactory {
//            public Thread newThread(Runnable r) {
//                //set daemon...
//            }
//        }
    }
}
