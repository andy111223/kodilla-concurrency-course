package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit tasks for execution
        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        // 100 futures, with 100 placeholders

        // perform some unrelated operations

        // 100 seconds
        for (int i = 0; i < allFutures.size(); i++) {
            Future<Integer> future = allFutures.get(i);
            // Integer result = future.get(); // Main thread goes into a blocked state until all placeholders are filled with values
            Integer result = future.get(1, TimeUnit.SECONDS); // Throws TimeoutException if the value is not ready within 1s
            System.out.println("The result of Future #" + i + "=" + result);
        }

        System.out.println("Thread Name: " + Thread.currentThread().getName());
        service.shutdown();
        //service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Is shutdown started? " + service.isShutdown());
        System.out.println("Are all tasks completed (included queued ones)? " + service.isTerminated());
        System.out.println("Active Count: " + Thread.activeCount());
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            Thread.sleep(3000);
            return 1;
        }
    }
}
