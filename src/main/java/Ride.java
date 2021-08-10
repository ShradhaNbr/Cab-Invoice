public class Ride {

    private final int time;
    public CabRide cabRide;
    private double distance ;

        //Creating Constructor
        public Ride(double distance, int time, CabRide cabRide) {
            this.distance = distance;
            this.time = time;
            this.cabRide = cabRide;
        }

    public Ride(CabRide ride, double distance, int time) {
            this.distance = distance;
            this.time = time;
            this.cabRide  = ride;
    }

    public int getTime() {
            return time;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }
    }

