package multi.tireChange;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TireChangeWithCountdownLatch {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Waiting for tires to get changed");
        CountDownLatch latch = new CountDownLatch(4);
        TireChangeTask task = new TireChangeTask(latch);
        Thread worker1 = new Thread(task);
        Thread worker2 = new Thread(task);
        Thread worker3 = new Thread(task);
        Thread worker4 = new Thread(task);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        latch.await();
        System.out.println("Wheel balancing and alignment starts");
    }
}

class TireChangeTask implements Runnable {

    CountDownLatch latch;

    public TireChangeTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        System.out.println("Changing tire");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tire change completed");
        latch.countDown();
    }
}
