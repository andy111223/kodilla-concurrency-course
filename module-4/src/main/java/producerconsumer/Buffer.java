package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private final Queue<Integer> products = new LinkedList<>();

    private final Lock lock = new ReentrantLock(); //to make a condition
    private final Condition bufferNotEmpty = lock.newCondition(); //producer waiting
    private final Condition bufferNotFull = lock.newCondition(); //consumer waiting

    public static final int CAPACITY = 5;

    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (products.size() == CAPACITY) {
                System.out.println("[PRODUCER] Waiting: buffer is full");
                bufferNotEmpty.await();
            }
            final Random random = new Random();
            int product = random.nextInt();
            products.offer(product);
            System.out.println("[PRODUCER] Added to buffer: " + product);
            System.out.println("[SIGNAL] Buffer is not empty from now");
            bufferNotFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (products.size() == 0) {
                System.out.println("[PRODUCER] Waiting: buffer is empty");
                bufferNotFull.await();
            }
            Integer product = products.poll();
            System.out.println("[CONSUMER] Consumed product: " + product);

            System.out.println("[SIGNAL] Buffer may be empty from now");
            bufferNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
