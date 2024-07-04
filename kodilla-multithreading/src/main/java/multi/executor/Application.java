package multi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        // Method returning the number of logical processors (threads) available to the Java Virtual Machine (JVM)
        int cores = Runtime.getRuntime().availableProcessors();

        //System.out.println("Available processors (cores): " + cores);

        ExecutorService executor = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < 1000; i++) {
            executor.submit(new Task());
        }
        executor.shutdown();
    }
}
