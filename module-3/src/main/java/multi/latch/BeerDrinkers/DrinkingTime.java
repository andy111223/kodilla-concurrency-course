package multi.latch.BeerDrinkers;

import java.util.Random;

public class DrinkingTime {

    public static int measureTime() throws InterruptedException {
        Random random = new Random();
        int time = random.nextInt(1500) + 500;
        Thread.sleep(time);
        return time;
    }
}
