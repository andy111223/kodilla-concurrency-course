package terminal;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Terminal {
    public static final FlightsProvider flightsProvider = new FlightsProvider();
    public static final CompanyProvider companyProvider = new CompanyProvider();

    public static void main(String[] args) {

        flightsProvider.provideFlights().thenCompose(flights -> {
            List<CompletableFuture<Flight>> updatedFlights = updateFlights(flights);
            return collectAllFlightsFutures(updatedFlights);
        }).thenAccept(Terminal::printResult).join();

//        flightsProvider.provideFlights().thenCompose(flights -> {
//
//            final List<CompletableFuture<Flight>> updatedFlights = flights.stream()
//                    .map(flight -> companyProvider.provideName(flight.getCompanyId())
//                            .thenApply(companyName -> {
//                                flight.setCompanyName(companyName);
//                                return flight;
//                            })).collect(Collectors.toList());
//
//            final CompletableFuture[] updatedFlightsArray = updatedFlights.toArray(new CompletableFuture[0]);
//
//            return CompletableFuture.allOf(updatedFlightsArray)
//                    .thenApply(v -> updatedFlights
//                            .stream()
//                            .map(CompletableFuture::join)
//                            .collect(Collectors.toList()));
//        }).thenAccept(updatedFlights -> {
//            System.out.println("----TERMINAL KODILLA----");
//            System.out.println(updatedFlights);
//        }).join();
    }

    private static void printResult(List<Flight> updatedFlights) {
        System.out.println("");
        System.out.println("----TERMINAL KODILLA----");
        System.out.println(updatedFlights);
    }

    private static CompletableFuture<List<Flight>> collectAllFlightsFutures(List<CompletableFuture<Flight>> updatedFlights) {
        return CompletableFuture.allOf(updatedFlights.toArray(new CompletableFuture[0]))
                .thenApply(v -> updatedFlights.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    private static List<CompletableFuture<Flight>> updateFlights(List<Flight> flights) {
        return flights.stream()
                .map(flight -> companyProvider.provideName(flight.getCompanyId())
                        .thenApply(companyName -> {
                            flight.setCompanyName(companyName);
                            return flight;
                        })).collect(Collectors.toList());
    }
    
    
}
