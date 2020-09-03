import java.util.ArrayList;
import java.util.Collections;

public class RideManager {
    ArrayList<Ride> allRides;

    public RideManager(){
        allRides =  new ArrayList<Ride>();
    }

    //need to rewrite this method (Session 2)
    public void showRelevantRides(String departureName , String destinationName , String time){
        Collections.sort(allRides , new SortRideByDepartureTime());

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
