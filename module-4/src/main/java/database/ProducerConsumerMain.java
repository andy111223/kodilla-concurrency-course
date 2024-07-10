package database;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerMain {

    private static int customerId = 0;
    private static synchronized int getNextCustomerId() {
        return customerId++;
    }

    public static void main(String[] args) {

        Database database = new Database();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                int id = getNextCustomerId();
                Customer customer = new Customer(id, "Customer-" + id);
                database.insert(customer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Runnable consumerTask = () -> {
            for (int i = 0; i < 5; i++) {
                List<Customer> customers = database.select();
                System.out.println("Selected: " + customers);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        executorService.submit(producerTask);
        executorService.submit(consumerTask);

        executorService.shutdown();
    }
}
