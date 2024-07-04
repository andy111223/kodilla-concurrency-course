package multi.deadlock;

public class ProcessB implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(50);
            synchronized (ProcessB.class) {
                System.out.println("Process B, part 1");
                Thread.sleep(50);
                synchronized (ProcessA.class) {
                    System.out.println("Process B, part 2");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
