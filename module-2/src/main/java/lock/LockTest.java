package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockTest {
    public static void main(String[] args) {

        final LockedWarehouse lockedWarehouse = new LockedWarehouse();

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Worker("Worker 1", lockedWarehouse));
        executorService.submit(new Worker("Worker 2", lockedWarehouse));
        executorService.submit(new Worker("Worker 3", lockedWarehouse));

        executorService.submit(new InventoryWorker("Inventory 1", lockedWarehouse));
        executorService.submit(new InventoryWorker("Inventory 2", lockedWarehouse));

        executorService.submit(new Thief("Zdzisław 'Najmro' Najmrodzki ", lockedWarehouse));

        executorService.shutdown();
    }
}
