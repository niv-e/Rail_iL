
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ride {
	static ArrayList<IntermediateStation> allIntermediateStations = new ArrayList<IntermediateStation>();
	String departureName;
	String destinationName;
	Clock departureTime=new Clock();
	Clock destinationTime = new Clock();

	Scanner s = new Scanner(System.in);

	public Ride() {
		boolean flag = true;
		setDepartureName();
		while(!departureTime.setTime())
			System.out.println("Invalid input please try again");
		setDestinationName();
		while(!destinationTime.setTime())
			System.out.println("Invalid input please try again");
	}

	public boolean addIntermediateStation(String name ){
		IntermediateStation i = new IntermediateStation(name);
		i.isCorrectExpectedStopTime(this);
		allIntermediateStations.add(i);
		return true;
	}

	public boolean setDepartureName() {
		System.out.println("Please enter department station: ");
		this.departureName = s.nextLine();
		return true;
	}

	public Clock getDepartureTime() {
		return departureTime;
	}

	public boolean setDestinationName() {
		System.out.println("Please enter destination station: ");
		this.destinationName = s.nextLine();

		return true;
	}

	public Clock getDestinationTime() {
		return destinationTime;
	}

	public String getDepartureName() {
		return departureName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDepartment name:\t" + departureName + "\nDepartment time:\t" + departureTime.toString()
				+ "\nDestination name:\t" + destinationName + "\nDestination time:\t" + destinationTime.toString());
		sb.append("\n\tIntermediate stations:\n");
		for (IntermediateStation i: allIntermediateStations) {
			sb.append(i.toString());
		}
		return sb.toString();
	}

	
}
