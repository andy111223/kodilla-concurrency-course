package producerconsumer;

import java.util.Random;

public class Consumer extends Thread {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        int counter = 0;
        final Random random = new Random();
        while (counter < 3) {
            try {
                buffer.get();
                Thread.sleep(random.nextInt(1000));
                counter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
