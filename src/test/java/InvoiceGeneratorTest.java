import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


    public class InvoiceGeneratorTest {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        private Assertions Assert;

        @Before
        public void setUp() throws Exception {
            invoiceGenerator = new InvoiceGenerator();
        }
        @Test
        public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
            double distance = 2.0;
            int time = 5;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(25, fare, 0.0);
        }

        @Test
        public void WhenGivenLessDistanceAndTimeShouldReturnMinimumFare() {
            double distance = 0.1;
            int time = 1;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assert.assertEquals(5, fare, 0.0);
        }

        @Test
        public void whenGivenMultipleRidesShouldReturnTotalFare() {
            //Creating rides object for Rides class
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)};
            //calling calculateTotalFare method
            double totalFare = invoiceGenerator.calculateTotalFare(rides);
            Assert.assertEquals(30, totalFare, 0.0);
        }
        @Test
        public void whenGiveMultipleRidesShouldReturnInvoiceSummary() {
            Ride[] rides = {new Ride(2.0,5),
                                new Ride(0.1,1) } ;
            InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
            InvoiceSummary expectedSummary = new InvoiceSummary(2,30);
            Assert.assertEquals(summary, expectedSummary);
        }
        @Test
        public void givenUseridShouldReturnUserInvoice() {
            String id = "Shradha";
            Ride[] rides = {new Ride(2.0,5),
                             new Ride(0.1,1)};
            invoiceGenerator.addRides(id,rides);
            InvoiceSummary summary = new InvoiceSummary(2,30);
            InvoiceSummary expectedSummary = invoiceGenerator.getInvoiceSummary(id);
            Assert.assertEquals(summary,expectedSummary);
        }
    }