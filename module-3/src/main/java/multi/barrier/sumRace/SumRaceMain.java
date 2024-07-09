package multi.barrier.sumRace;

import java.util.concurrent.CyclicBarrier;

public class SumRaceMain {
    public static void main(String[] args) {

        // Initialize CyclicBarrier with 5 parties and FinalStep action
        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        // Launch 5 threads
        for (int n = 0; n < 5; n++) {
            launchTheThread(barrier, n);
        }
    }

    private static void launchTheThread(CyclicBarrier barrier, int number) {

        // Create and start the thread
        new Thread(new PartialStep(barrier, number)).start();
    }
}
