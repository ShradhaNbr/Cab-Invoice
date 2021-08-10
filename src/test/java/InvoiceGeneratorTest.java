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
    }

