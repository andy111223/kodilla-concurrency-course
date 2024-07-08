package multi.parallel.population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Countries {

    private Countries() {
    }

    public static List<Country> randomCountries(int number) {
        List<Country> countries = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < number; i++) {
            int partialPopulation = random.nextInt(20) * 1000000;
            countries.add(new Country("Country-" + i, i*partialPopulation ));
        }
        return countries;
    }
}
