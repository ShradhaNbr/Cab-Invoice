public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER =10 ;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE =5 ;
    RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

/*
 * Purpose : Method to calculate fare
 *
 * @param distance
 * @param time
 */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        totalFare = Math.max(totalFare, MINIMUM_FARE);
        return totalFare;

    }
    //Method to calculate TotalFare for multiple rides
    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    //method to get number of rides
    public int getNumberOfRides(Ride[] rides) {
        return rides.length;
    }

    //Method to calculate AverageFarePerRide
    public double calculateAverageFarePerRide(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            //calling calculateFare method here
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare / rides.length;
    }
    //Creating calculateFare method
    public  InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            //calling calculateFare method here
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    //Method to add rides
    public void addRides(String id,Ride[] rides) {
        rideRepository.addRides(id,rides);
    }

    public InvoiceSummary getInvoiceSummary(String id) {
        return this.calculateFare(rideRepository.getRide(id));
    }
}