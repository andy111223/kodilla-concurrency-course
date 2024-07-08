package multi.latch.BeerDrinkers;

import java.util.concurrent.ConcurrentMap;

public class SlowestDrinkerFinder {

    public static String findSlowestDrinker(ConcurrentMap<String,Integer> drinkingTimes){

        String slowestDrinker = null;
        int longestTime = Integer.MIN_VALUE;
        for (String drinker : drinkingTimes.keySet()) {
            int time = drinkingTimes.get(drinker);
            if (time > longestTime) {
                longestTime = time;
                slowestDrinker = drinker;
            }
        }
        if (slowestDrinker != null) {
            System.out.println("---> " + slowestDrinker + " was slowest and will order the taxi");
        } else {
            System.out.println("No slowest drinker found");
        }
        return slowestDrinker;
    }
}
