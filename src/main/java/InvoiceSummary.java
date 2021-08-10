public class InvoiceSummary {
    private int numberOfRides = 0;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int length, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numberOfRides;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare,totalFare)==0 && Double.compare(that.averageFare, averageFare) == 0;
    }

}