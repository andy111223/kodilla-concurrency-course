package multi.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {
    public static void main(String[] args) {
/*
This class sets up the Phaser and starts multiple PhasedTask instances.
A Phaser is created with an initial party count of 1, representing the main thread.
Five PhasedTask instances are created and started, each registering itself with the Phaser.
 */
        Phaser phaser = new Phaser(1);

        int phaseNum = phaser.getPhase();

        new PhasedTask(phaser, 0);
        new PhasedTask(phaser, 1);
        new PhasedTask(phaser, 2);
        new PhasedTask(phaser, 3);
        new PhasedTask(phaser, 4);

        System.out.println("Phaser phase: " + phaseNum + " - begin");
/*
The main thread waits for all tasks to complete each phase using phaser.arriveAndAwaitAdvance().
 */
        phaser.arriveAndAwaitAdvance(); // Wait for all tasks to reach phase 0
        phaseNum = phaser.getPhase();
        System.out.println("Phaser phase: " + phaseNum + " - reached");

        phaser.arriveAndAwaitAdvance(); // Wait for all tasks to reach phase 1
        phaseNum = phaser.getPhase();
        System.out.println("Phaser phase: " + phaseNum + " - reached");

        phaser.arriveAndAwaitAdvance(); // Wait for all tasks to reach phase 2
        phaseNum = phaser.getPhase();
        System.out.println("Phaser phase: " + phaseNum + " - reached");
/*
After waiting for all tasks to complete phase 2, the main thread deregisters itself.
 */
        phaser.arriveAndDeregister(); // Deregister the main thread from the Phaser
/*
The main thread then waits for the Phaser to terminate, which happens when all tasks have deregistered.
 */
        while (!phaser.isTerminated()) {
            // do nothing, just wait
        }

        System.out.println("Work is finished");

    }
}
