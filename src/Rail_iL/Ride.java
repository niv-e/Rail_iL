import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ride {
	ArrayList<IntermediateStation> allIntermediateStations = new ArrayList<IntermediateStation>();
	Station departure = new Station();
	Station destination = new Station();;
	Clock departureTime=new Clock();
	Clock destinationTime = new Clock();

	Scanner s = new Scanner(System.in);

	public Ride() { }

	public boolean checkIfTimeInRange(Clock departureTime , Clock destinationTime){
		if(departureTime.timeToCompare() > destinationTime.timeToCompare()) {
			return false;
		}
		return true;
	}


	public void addIntermediateStation(IntermediateStation intermediateStation){
		allIntermediateStations.add(intermediateStation);
	}

	public String toString() {
		Collections.sort(allIntermediateStations, new SortRideByStopTime());
		StringBuilder sb = new StringBuilder();
		sb.append("\nDepartment name:\t" + departure.getStationName() + "\nDepartment time:\t" + departureTime.toString()
				+ "\nDestination name:\t" + destination.getStationName() + "\nDestination time:\t" + destinationTime.toString());
		sb.append("\n\tIntermediate stations:\n");
		if(this.allIntermediateStations.isEmpty())
			sb.append("\tno intermediate station for this moment");
		else {
			for (IntermediateStation i : allIntermediateStations) {
				sb.append(i.toString());
			}
		}
		return sb.toString();
	}
}
