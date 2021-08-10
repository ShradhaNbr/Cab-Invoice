public enum CabRide {
    Normal(10.0,1.0,5.0),
    Premium(15.0,2.0,20.0);
    private final double farePerKilometer;
    private final double farePerMinute;
    private final double farePerRide;


    CabRide(double costPerKm, double costperMinute,double farePerRide) {
        this.farePerKilometer = costPerKm;
        this.farePerMinute = costperMinute;
        this.farePerRide = farePerRide;
    }
    public double calculateFareperRide(Ride ride) {
        double rideFare = ride.getDistance() * farePerKilometer + ride.getTime() * farePerMinute;
        return Math.max(rideFare, farePerRide);
    }
}
