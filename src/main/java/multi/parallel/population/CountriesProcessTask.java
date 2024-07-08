package multi.parallel.population;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountriesProcessTask extends RecursiveTask<Long> {

    private final static int THRESHOLD = 5;
    private List<Country> countries = new ArrayList<Country>();

    CountriesProcessTask(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        if (countries.size() <= THRESHOLD) {
            return countries
                    .stream()
                    .mapToLong(CountriesProcessTask::processCountry)
                    .sum();
        } else {
            int middle = countries.size() / 2;
            CountriesProcessTask left = new CountriesProcessTask(countries.subList(0, middle));
            CountriesProcessTask right = new CountriesProcessTask(countries.subList(middle, countries.size()));

            left.fork();

            long rightResult = right.compute();
            long leftResult = left.join();
            return rightResult + leftResult;
        }
    }

    // Logic assuming population is to be summed directly
    private static long processCountry(Country c) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return (long) (c.getPopulation() * 2 + c.getPopulation() / 2 + Math.floor(Math.sqrt(c.getPopulation())));
    }
}
