package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

import static util.SleepUtil.sleep;

public class LockedWarehouse {
    /*
    Using the Condition's await() method, the thief waits until ELECTRONICS are available in the warehouse.
    Workers cooperate with the thief (and potentially with other thieves) by notifying them with the signalAll() method
    when new ELECTRONICS are added to the warehouse.
    */

    private final Map<Product, Integer> products = new HashMap<>();
    private final StampedLock lock = new StampedLock();
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition electronicsAvailable = reentrantLock.newCondition();

    public void add(Product product, String by) {
        System.out.println("I am " + by + " trying to add " + product);
        final long stamp = lock.writeLock();
        try {
            sleep(2);
            products.merge(product, 1, Integer::sum);
            System.out.println("Product " + product + " added by" + by + ". Now is " + countProducts());

            // Signal the thief if electronics were added
            if (product == Product.ELECTRONICS) {
                reentrantLock.lock();
                try {
                    electronicsAvailable.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    private int countProducts() {
        return products.values().stream().reduce(0, Integer::sum);
    }

    public void showProducts(String inventoryWorkerName) {
        System.out.println("I am " + inventoryWorkerName + " and I want to check INVENTORY");
        final long stamp = lock.readLock();
        try {
            products.forEach((key, value) ->
                    System.out.println("[" + inventoryWorkerName + "] " + "Product: " + key + "quantity: " + value));
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void trySteal(String thiefName) {
        System.out.println("I am " + thiefName + " trying to STEAL ELECTRONICS");

        // Wait until electronics are available
        reentrantLock.lock();
        try {
            while (!products.containsKey(Product.ELECTRONICS)) {
                System.out.println(this + " waiting for ELECTRONICS");
                electronicsAvailable.await();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            reentrantLock.unlock();
        }

        // Attempt to steal electronics
        final long stamp = lock.writeLock();
        try {
            if (products.containsKey(Product.ELECTRONICS)) {
                products.remove(Product.ELECTRONICS);
                System.out.println("Electronics stolen by " + thiefName);
            }
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
