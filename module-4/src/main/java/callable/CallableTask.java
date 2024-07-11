package callable;

import java.util.concurrent.*;

public class CallableTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit the task for execution
        Future<Integer> future = service.submit(new Task());

        // perform some unrelated operations

        //get the result of the callable task
        Integer result = future.get(); // get() is a BLOCKING operation until the thread is ready to return a value

        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Result: " + result);

        service.shutdown();
        System.out.println("Is shutdown started? " + service.isShutdown());
        System.out.println("Are all tasks completed (included queued ones)? " + service.isTerminated());
        System.out.println("Active Count: " + Thread.activeCount());
    }

    /*
    Run() method in Runnable interface returns void. Use call() from Callable interface instead.
    Call() returns <Value>. Future<Value> is a placeholder for the value to be returned in the future.
     */
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            Thread.sleep(3000);
            return 1;
        }
    }
}
