package multi.latch;

import java.util.concurrent.CountDownLatch;

public class LatchApp {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch theLatch = new CountDownLatch(5);
        new ExampleTask(theLatch);

        theLatch.await();

        System.out.println("The latch is closed");
    }
}
