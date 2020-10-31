package Rail_il;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ride {
	ArrayList<IntermediateStation> allIntermediateStations = new ArrayList<IntermediateStation>();
	private Station departure;
	private Station destination;
	private Clock departureTime = new Clock();
	private Clock destinationTime = new Clock();

	Scanner s = new Scanner(System.in);

	public Ride() {
	}

	public Ride(String departure, String destination) {
		setDeparture(departure);
		setDestination(destination);
	}

	public ArrayList<IntermediateStation> getAllIntermediateStations() {
		return allIntermediateStations;
	}

	// getters
	public String getDeparture() {
		return departure.getStationName();
	}

	public String getDestination() {
		return destination.getStationName();
	}

	public Clock getDepartureClock() {
		return departureTime;
	}

	public String getDepatureTime() {
		String time = departureTime.getHours() + ":" + departureTime.getMinutes();
		return time;
	}

	public Clock getDestinationClock() {
		return destinationTime;
	}

	public String getDestinationTime() {
		String time = destinationTime.getHours() + ":" + destinationTime.getMinutes();
		return time;
	}

	public void setAllIntermediateStations(ArrayList<IntermediateStation> allIntermediateStations) {
		this.allIntermediateStations = allIntermediateStations;
	}

	public void setDeparture(String departure) {
		this.departure = new Station(departure);
	}

	public void setDeparture(Station departure) {
		this.departure = (departure);
	}

	public void setDestination(String destination) {
		this.destination = new Station(destination);
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public boolean setDepartureTime(String departureTime) {
		this.departureTime = new Clock();
		this.departureTime.setTime(departureTime);
		boolean res = this.departureTime.setTime(departureTime);
		return res;
	}

	public boolean setDestinationTime(String destinationTime) {
		this.destinationTime = new Clock();
		boolean res = this.destinationTime.setTime(destinationTime);
		return res;

	}

	public boolean checkIfTimeInRange(Clock departureTime, Clock destinationTime) {
		if (departureTime.timeToCompare() > destinationTime.timeToCompare()) {
			return false;
		}
		return true;
	}

	public void addIntermediateStation(IntermediateStation intermediateStation) {
		allIntermediateStations.add(intermediateStation);
	}

	public String toHtml() {
		StringBuilder sbh = new StringBuilder();
		sbh.append("<br> Department name: " + departure.getStationName() + "<br>" + "Department time: "
				+ departureTime.toString()+ "<br>");
		sbh.append("<br> Destination name: " + destination.getStationName() + "<br>" + "Destination time: "
				+ destinationTime.toString()+ "<br>");

		sbh.append("<br> Intermediate Station: ");
		if (this.allIntermediateStations.isEmpty())
			sbh.append("<br> &nbsp;&nbsp;&nbsp;&nbsp; no intermediate station for this moment");
		else {
			for (IntermediateStation i : allIntermediateStations) {
				sbh.append("<br> &nbsp;&nbsp;&nbsp;&nbsp; " + i.getStationName() + "<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;" + i.getStopTime() +"<br>");
			}
		}
		return sbh.toString();

	}

	public String toString() {
		Collections.sort(allIntermediateStations, new SortRideByStopTime());
		StringBuilder sb = new StringBuilder();
		sb.append("\nDepartment name: " + departure.getStationName() + "\nDepartment time: " + departureTime.toString()
				+ "\nDestination name: " + destination.getStationName() + "\nDestination time: "
				+ destinationTime.toString());
		sb.append("\n" + allIntermediateStations.size());
		sb.append("\n\tIntermediate stations:\n");
		if (this.allIntermediateStations.isEmpty())
			sb.append("\tno intermediate station for this moment");
		else {
			for (IntermediateStation i : allIntermediateStations) {
				sb.append(i.toString());
			}
		}
		return sb.toString();
	}
}
