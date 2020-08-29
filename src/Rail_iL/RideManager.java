import java.util.ArrayList;
import java.util.Collections;

public class RideManager {
    ArrayList<Ride> allRides;

    public RideManager(){
        allRides =  new ArrayList<Ride>();
    }

    public boolean addIntermediateStop(int mainRideChoice , String intermediateStation){
        return allRides.get(mainRideChoice).addIntermediateStation(intermediateStation);
    }

    public void addRide (Ride ride){
        allRides.add(ride);
        Collections.sort(allRides , new SortRideByDepartureTime());
    }

    private boolean toContinue(){
        System.out.println("please enter y for yes or any key to exit");
        char c = toString().charAt(0);
        boolean res = c == 'y' || c == 'Y';
        return res;
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
