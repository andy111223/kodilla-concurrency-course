package terminal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FlightsProvider {

    /*
    Method creating a thread returning a list of flights
     */
    public CompletableFuture<List<Flight>> provideFlights() {
        System.out.println("Providing flights");
        return CompletableFuture.supplyAsync(() -> List.of(
                new Flight(1, "WAW", LocalDateTime.now(), LocalDateTime.now(), 1),
                new Flight(1, "WRO", LocalDateTime.now(), LocalDateTime.now(), 3),
                new Flight(1, "DUB", LocalDateTime.now(), LocalDateTime.now(), 3),
                new Flight(1, "PMI", LocalDateTime.now(), LocalDateTime.now(), 4),
                new Flight(1, "MAD", LocalDateTime.now(), LocalDateTime.now(), 2)
        ));
    }
}
