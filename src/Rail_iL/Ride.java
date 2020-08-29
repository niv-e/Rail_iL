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

	public Ride() {
		System.out.println("Please enter departure station's name: ");
		while(!departure.setStationName())
			System.out.println("Invalid input please try again");
		while(!departureTime.setTime())
			System.out.println("Invalid input please try again");

		System.out.println("Please enter destination station's name: ");
		while(!destination.setStationName())
			System.out.println("Invalid input please try again");
		while(!destinationTime.setTime())
			System.out.println("Invalid input please try again");

		while(destinationTime.timeToCompare()<departureTime.timeToCompare()){
			System.out.println("Destination time can not be assigned earlier then the departure time");
			destinationTime.setTime();
		}
	}

	public boolean addIntermediateStation(String name){
		IntermediateStation i = new IntermediateStation(name);
		while(!(i.checkIfTimeInRange(departureTime ,destinationTime)))
			i.expectedStopTime.setTime();
		allIntermediateStations.add(i);
		return true;
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
