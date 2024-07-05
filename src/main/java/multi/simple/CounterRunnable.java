package multi.simple;

public class CounterRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Object " + Thread.currentThread().threadId() + ", current value: " + i);
        }
    }
}
