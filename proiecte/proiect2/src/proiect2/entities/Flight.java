package proiect2.entities;

public class Flight {
    private static final int MAX_PASSENGERS=600;
    private String operator;
    private int flightId;
    private String departure;
    private String destination;
    private double basePrice;
    private int passengers;

    //constructor zbor
    public Flight(String operator, int flightId, String departure, String destination, double basePrice) {
        this.operator = operator;
        this.flightId = flightId;
        this.departure = departure;
        this.destination = destination;
        this.basePrice = basePrice;
    }

    //getter companie aeriana
    public String getOperator() {
        return operator;
    }

    //setter companie aeriana
    public void setOperator(String operator) {
        this.operator = operator;
    }

    //getter ID zbor
    public int getFlightId() {
        return flightId;
    }

    //setter ID zbor
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    //getter plecare
    public String getDeparture() {
        return departure;
    }

    //setter plecare
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    //getter destinatie
    public String getDestination() {
        return destination;
    }

    //setter destinatie
    public void setDestination(String destination) {
        this.destination = destination;
    }

    //getter pret
    public double getBasePrice() {
        return basePrice;
    }

    //setter pret
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    //getter numar pasageri
    public int getPassengers() {
        return passengers;
    }

    //incrementare numar pasageri
    public void addPassenger() {
        if(passengers<MAX_PASSENGERS) {
            ++passengers;
        }
    }

    //metoda toString
    @Override
    public String toString() {
        return operator+ ' ' + flightId;
    }

    //returnarea informatiilor despre zbor
    public String fullInfo(){
        return "entities.Flight " + operator +  flightId + System.lineSeparator() +
                "From: " + departure + System.lineSeparator() +
                "To: " + destination + System.lineSeparator() +
                "Price: " + basePrice + System.lineSeparator() +
                "Number of passengers: " + passengers + '/' + MAX_PASSENGERS;
    }

    //verificare daca mai sunt locuri libere
    public boolean isFull(){
        return passengers>=MAX_PASSENGERS;
    }
}
