package producerconsumer;

import java.util.Random;

public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while (counter < 3) {
                buffer.add();
                Thread.sleep(random.nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
