import java.util.ArrayList;
import java.util.Collections;

public class RideManager {
    ArrayList<Ride> allRides;

    public RideManager(){
        allRides =  new ArrayList<Ride>();
    }

    public void addRide (Ride ride){
        allRides.add(ride);
        Collections.sort(allRides , new SortRideByDepartureTime());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int counter =1;
        for ( Ride r : allRides) {
            sb.append("\nride " + counter++ +": " + r.toString() +"\n");
        }
        return sb.toString();
    }

}
