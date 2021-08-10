import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides=new HashMap<>();
    }
    public void addRides(String id,Ride[] rides) {
        this.userRides.put(id,new ArrayList<>(Arrays.asList(rides)));
    }

    public  Ride[] getRide (String id){
    return  this.userRides.get(id).toArray(new Ride[0]);
}
}