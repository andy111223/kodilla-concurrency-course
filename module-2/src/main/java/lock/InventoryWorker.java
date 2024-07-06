package lock;

import java.util.Random;

import static util.SleepUtil.sleep;

public class InventoryWorker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public InventoryWorker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            final Random random = new Random();
            sleep(random.nextInt(4));
            warehouse.showProducts(workerName);
        }
    }
}
