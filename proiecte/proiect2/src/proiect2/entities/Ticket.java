package proiect2.entities;

public class Ticket {
    private Passenger passenger;
    private Flight flight;

    //constructor bilet
    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    //getter pasager
    public Passenger getPassenger() {
        return passenger;
    }

    //setter pasager
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    //getter zbor
    public Flight getFlight() {
        return flight;
    }

    //setter zbor
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
