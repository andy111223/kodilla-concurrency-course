package multi.phaser;

import java.util.concurrent.Phaser;

public class PhasedTask implements Runnable {
/*
This class represents a task that executes in phases, coordinated by a Phaser.
Phaser phaser: The Phaser instance used to coordinate phases.
int number: The task number, used for identification in the print statements.
The constructor registers the task with the Phaser and starts the task in a new thread.
The run method is the main execution point of the task, running through several phases.
 */
    private Phaser phaser;
    private int number;

    public PhasedTask(Phaser phaser, int number) {
        this.phaser = phaser;
        this.number = number;
        phaser.register(); // Register this task with the Phaser
        new Thread(this).start();
    }
/*
The run method is the main execution point of the task, running through several phases.
The task prints that it has entered phase 0.
Sleeps for 200 milliseconds to simulate work.
Calls phaser.arriveAndAwaitAdvance() to signal it has arrived at the barrier and waits for other tasks.
This pattern repeats for subsequent phases (phase 1, phase 2, phase 4):
For each phase, the task prints its entry, simulates work with a sleep, and waits for other tasks to arrive at the barrier.
The final call to phaser.arriveAndDeregister() signals that the task is complete and deregisters from the Phaser.
 */
    @Override
    public void run() {
        System.out.println("Process number " + number + " phase 0 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 1 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 2 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 4 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " finish reached");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndDeregister();
    }
}
