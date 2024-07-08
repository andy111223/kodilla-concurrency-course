package multi.latch.BeerDrinkers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

public class BeerDrinkersMain {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("\nWaiting beer drinkers to get ready and start drinking a beer\n");

        List<String> drinkers = DrinkerSelector.selectRandomDrinkers();

        CountDownLatch latch = new CountDownLatch(drinkers.size());
        ConcurrentMap<String,Integer> drinkingTimes = new ConcurrentHashMap<>();

        for (String drinker : drinkers) {
            new Thread(new BeerDrinker(drinker, latch, drinkingTimes)).start();
        }

        latch.await();

        SlowestDrinkerFinder.findSlowestDrinker(drinkingTimes);
    }
}
