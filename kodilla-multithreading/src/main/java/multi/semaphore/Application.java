package multi.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {


        ExecutorService executor = Executors.newCachedThreadPool();
        for (int n = 0; n < 1000; n++) {
            executor.submit(new DbManager());
        }
        executor.shutdown();
    }
}
