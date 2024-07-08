package multi.latch.BeerDrinkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DrinkerSelector {

    private static final String FILE_PATH = "module-3/src/main/resources/beerDrinkers.txt";
    private static final int NUMBER_OF_DRINKERS = 5;

    public static List<String> selectRandomDrinkers() throws IOException {
        List<String> allDrinkers = Files.readAllLines(Paths.get(FILE_PATH));
        Random random = new Random();

        return random.ints(0, allDrinkers.size())
                .distinct()
                .limit(NUMBER_OF_DRINKERS)
                .mapToObj(allDrinkers::get)
                .collect(Collectors.toList());
    }
}
