package multi.parallel.population;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinCountriesMain {
    public static void main(String[] args) {

        List<Country> countries = Countries.randomCountries(15);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(new CountriesProcessTask(countries));
        String formattedResult = NumberFormatter.format(result);
        System.out.println("Total population: " + formattedResult);
    }
}
