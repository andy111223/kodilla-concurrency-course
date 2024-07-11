package terminal;

import java.time.LocalDateTime;

public class Flight {

    private final int flightNumber;
    private final String arrivalAirport;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final int companyId;
    private String companyName;

    public Flight(int flightNumber, String arrivalAirport, LocalDateTime departure, LocalDateTime arrival, int companyId) {
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.departure = departure;
        this.arrival = arrival;
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    @Override
    public String toString() {
        return "" + flightNumber + "\t" +
                arrivalAirport + "\t" +
                departure + "\t" +
                arrival + "\t" +
                companyName + "\n";
    }
}
