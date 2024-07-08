package multi.latch;

import java.util.concurrent.CountDownLatch;

public class ExampleTask implements Runnable {

    private CountDownLatch theLatch;

    public ExampleTask(CountDownLatch theLatch) {
        this.theLatch = theLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            doTask();
        }
    }

    private void doTask() {
        System.out.println("Running task");
        theLatch.countDown();
    }
}
