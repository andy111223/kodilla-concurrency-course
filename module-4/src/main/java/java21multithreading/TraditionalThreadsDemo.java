package java21multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TraditionalThreadsDemo {

    // Java 8-20 code using traditional threads
    public static void main(String[] args) throws InterruptedException {

        // Creating a fixed thread pool with a limited number of threads

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Running task:");
            });
        }
        // Properly shutting down the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Waiting for all tasks to finish
            Thread.sleep(100);
        }
    }
}
