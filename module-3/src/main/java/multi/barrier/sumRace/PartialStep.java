package multi.barrier.sumRace;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PartialStep implements Runnable {

    private final CyclicBarrier barrier;
    private final int number;
    private int sumA = 1000;
    private int sumB = 0;

    public PartialStep(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread number " + number + " was launched");
        Random random = new Random();
        int counter = 0;
        while (sumA > sumB) {
            int addNumberA = random.nextInt(10);
            sumA += addNumberA;
            int addNumberB = random.nextInt(50);
            sumB += addNumberB;
            System.out.println("Thread number " + number + " - Counter: " + counter++);
            System.out.println("Thread " + number + " - A: " + sumA);
            System.out.println("Thread " + number + " - B: " + sumB);
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
