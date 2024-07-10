package database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

public class Database {

    private final List<Customer> customers = new ArrayList<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void insert(Customer customer) {
        rwLock.writeLock().lock();
        try {
            customers.add(customer);
            System.out.println("Inserted: " + customer);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public List<Customer> select() {
        rwLock.readLock().lock();
        try {
            return new ArrayList<>(customers);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
