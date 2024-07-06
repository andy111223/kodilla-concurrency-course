package lock;

import java.util.Random;

import static util.SleepUtil.sleep;

public class Thief implements Runnable {

    private final String thiefName;
    private final LockedWarehouse warehouse;

    public Thief(String thiefName, LockedWarehouse warehouse) {
        this.thiefName = thiefName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            final Random random = new Random();
            sleep(random.nextInt(4));
            warehouse.trySteal(thiefName);
        }
    }
}
