package app.core.concurrency;

import java.util.ArrayList;

public class ConcurrentStack {

    public static void main(String[] args) {
        ConcurrentStack stack = new ConcurrentStack();

        Thread t1 = new Thread(new ConcurrentStackProducer(stack), "producer thread 1");
        Thread t2 = new Thread(new ConcurrentStackProducer(stack), "producer thread 2");
        Thread t3 = new Thread(new ConcurrentStackProducer(stack), "producer thread 3");
        Thread t4 = new Thread(new ConcurrentStackProducer(stack), "producer thread 4");

        Thread t5 = new Thread(new ConcurrentStackConsumer(stack), "consumer thread 1");
        Thread t6 = new Thread(new ConcurrentStackConsumer(stack), "consumer thread 2");
        Thread t7 = new Thread(new ConcurrentStackConsumer(stack), "consumer thread 3");
        Thread t8 = new Thread(new ConcurrentStackConsumer(stack), "consumer thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public synchronized void push(Integer value) {
        arrayList.add(value);
        notify();
    }

    public synchronized Integer pop() {
        while (arrayList.isEmpty()) {
            try {
                System.out.println("wainting...");
                wait();
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public String toString() {
        return "ConcurrentStack{" +
                "arrayList=" + arrayList +
                '}';
    }
}
