package Rail_iL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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


    private void rideBubbleSorter() {
        Collections.sort(allRides, new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                return 0;
            }
        });
    }

}
