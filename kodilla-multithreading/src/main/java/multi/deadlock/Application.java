package multi.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            executor.submit(new ProcessA());
            executor.submit(new ProcessB());
        }
    }
}
