package java21multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {

        // Java 21: Using Virtual Threads

        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Running task: " + taskId + ", in virtual thread: " + Thread.currentThread());
                });
            }
        } // The try-with-resources ensures the executor is properly closed

        // Simulate some work with a short sleep
        Thread.sleep(1000);
    }

}
