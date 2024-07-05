package multi.executor.arrayMul;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayMain {
    public static void main(String[] args) {

        int size = 50;
        ArrayTask.initializeArrays(size);

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int chunkSize = (int) Math.ceil((double) size / cores);

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, size);
            if (start < end) {
                executor.submit(new ArrayTask(start, end));
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds to reduce CPU usage
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }

        System.out.println("---");
        System.out.println("Final resultArray = " + Arrays.toString(ArrayTask.getResultArray()));

    }
}
