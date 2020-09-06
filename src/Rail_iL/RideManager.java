import java.util.ArrayList;
import java.util.Collections;

public class RideManager {
    ArrayList<Ride> allRides;

    public RideManager(){
        allRides =  new ArrayList<Ride>();
    }

	public void showRelevantRides(String departureName , String destinationName , String time){
		Clock c = new Clock();
		c.setTime(time);
		Collections.sort(allRides , new SortRideByDepartureTime());
		for (Ride r : allRides) {	 
			r.departureTime.setTime(time);
			if(r.departure.getStationName().equals(departureName) && r.destination.getStationName().contentEquals(destinationName)) {
				if(r.departureTime.timeToCompare() <= c.timeToCompare()) {
					System.out.println(r.toString());	
				}
			}
		}
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
