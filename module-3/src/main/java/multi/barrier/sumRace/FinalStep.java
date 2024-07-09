package multi.barrier.sumRace;

public class FinalStep implements Runnable {

    @Override
    public void run() {
        System.out.println("All threads have finished. FINITO");
    }
}
