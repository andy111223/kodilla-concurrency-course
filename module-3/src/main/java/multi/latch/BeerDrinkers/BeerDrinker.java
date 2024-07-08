package multi.latch.BeerDrinkers;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

public class BeerDrinker implements Runnable{

    private final String name;
    private final CountDownLatch latch;
    private final ConcurrentMap<String, Integer> drinkingTimes;

    public BeerDrinker(String name, CountDownLatch latch, ConcurrentMap<String, Integer> drinkingTimes) {
        this.name = name;
        this.latch = latch;
        this.drinkingTimes = drinkingTimes;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " drinking beer");
            int time = DrinkingTime.measureTime();
            System.out.println(name + " drinking time: " + time + "ms");
            drinkingTimes.put(name, time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
