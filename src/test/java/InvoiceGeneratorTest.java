import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


    public class InvoiceGeneratorTest {
        private Assertions Assert;

        @Test
        public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
            //Creating object for InvoiceGenerator class
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            double distance = 2.0;
            int time = 5;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(25, fare, 0.0);
        }

        @Test
        public void WhenGivenLessDistanceAndTimeShouldReturnMinimumFare() {
            //Creating object for InvoiceGenerator class
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            double distance = 0.1;
            int time = 1;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(5, fare,0.0);
        }
        @Test
        public void whenGivenMultipleRidesShouldReturnTotalFare() {
            //Creating object for InvoiceGenerator class
            InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
            //Creating rides object for Rides class
            Ride[] rides = { new Ride(2.0, 5),
                    new Ride(0.1, 1)};
            //calling calculateTotalFare method
            double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
            System.out.println("Total Fare = "+totalFare);
            Assert.assertEquals(30, totalFare,0.0);
        }
        @Test
        public void WhenGivenMultipleRidesShouldReturnSizeAndAverageFare() {
            //Creating object for InvoiceGenerator class
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            //Creating rides object for Rides class taking Multiple rides
            Ride[] rides = { new Ride(30,4),
                    new Ride(20.0,1),
                    new Ride(55.0,1),
                    new Ride(22.5,1)};
            //calling calculateTotalFare method
            double totalFare = invoiceGenerator.calculateTotalFare(rides);
            int numberOfRides = invoiceGenerator.getNumberOfRides(rides);
            double averageTotalFare = invoiceGenerator.calculateAverageFarePerRide(rides);
            //printing the totalFare,numberOfRides,averageTotalFare
            System.out.println("Total Fare = " +totalFare);
            System.out.println("Number of ride = " +numberOfRides);
            System.out.println("Average Total Fare " +averageTotalFare);

            Assert.assertEquals(1282,totalFare,0.0);
            Assert.assertEquals(4,numberOfRides);
            Assert.assertEquals(320.5,averageTotalFare,0.5);
        }
    }

