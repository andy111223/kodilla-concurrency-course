package multi.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierApp {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        for (int n = 0; n < 5; n++) {
            launchTheThread(barrier, n);
        }

    }

    private static void launchTheThread(CyclicBarrier barrier, int number) {
        new PartialStep(barrier, number);
    }
}
