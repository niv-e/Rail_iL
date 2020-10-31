package Rail_il;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

public class RideManager {
	ArrayList<Ride> allRides;

	final static String SAVE_PATH = "";
//	final static String SAVE_PATH = "src/webServer/";
	final static String F_NAME = "rideDetails";
	final static String ENDING = ".txt";

	final static int ZERO_OBJECT = -1;
	static GregorianCalendar calendar = new GregorianCalendar();

	public RideManager() {
		allRides = new ArrayList<Ride>();

	}

	public void showRelevantRides(String departureName, String destinationName, String time) {
		Clock c = new Clock();
		c.setTime(time);
		Collections.sort(allRides, new SortRideByDepartureTime());
		for (Ride r : allRides) {
			if (r.getDeparture().equals(departureName) && 	
					r.getDestination().equalsIgnoreCase(destinationName)) {
				if (c.checkIfClose(r.getDepartureClock()))
					System.out.println(r.toString());
			}
		}
	}

	public void addRide(Ride ride) {
		allRides.add(ride);
		Collections.sort(allRides, new SortRideByDepartureTime());
	}

	public void saveToFile() throws FileNotFoundException {
		File file = new File(SAVE_PATH + F_NAME + ENDING);
		PrintWriter pw;

		if (file.exists()) {
			String newFileName = SAVE_PATH + F_NAME + calendar.getTime() + ENDING;
			File newFile = new File(newFileName);
			pw = new PrintWriter(newFile);
		} else {
			pw = new PrintWriter(file);
		}
//			
		System.out.println("start saving");
		int size = allRides.size();
		pw.print(size + "\n"); // printing the number of the rides
		System.out.println(allRides.size());
		for (Ride r : allRides) {
			pw.print(r.getDeparture() + "\n");
			pw.print(r.getDepartureClock().toString() + "\n");
			pw.print(r.getDestination() + "\n");
			pw.print(r.getDestinationClock().toString() + "\n");
			boolean haveIntermediate = r.getAllIntermediateStations().isEmpty();
			if (haveIntermediate) {
				pw.print(ZERO_OBJECT + "\n");
			} else {
				int numOfIntermediate = r.getAllIntermediateStations().size();
				pw.print(numOfIntermediate + "\n");
				for (int i = 0; i < numOfIntermediate; i++)
					pw.print(r.getAllIntermediateStations().get(i).getStationName() + "\n");
			}
		}
		pw.close();
		System.out.println("new file was created! ");

	}

	public void readFile() throws FileNotFoundException {
		try {
			File f = new File(SAVE_PATH + F_NAME + ENDING);
			if (!f.exists()) {
				f = new File(SAVE_PATH + F_NAME + calendar.getTime() + ENDING);
			}

			Scanner scan = new Scanner(f); // The location should change in another computer

			int numOfRides = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < numOfRides; i++) {
				Ride r = new Ride();
				r.setDeparture(scan.nextLine());
				r.setDepartureTime(scan.nextLine());
				r.setDestination(scan.nextLine());
				r.setDestinationTime(scan.nextLine());
				int numOfIntermediate = Integer.parseInt(scan.nextLine());
				if (numOfIntermediate != -1) {
					for (int j = 0; j < numOfIntermediate; j++) {
						r.addIntermediateStation(new IntermediateStation(scan.nextLine()));
						r.getAllIntermediateStations().get(j).setTime(scan.nextLine());
					}
				}
				this.allRides.add(r);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public Vector<Ride> checkForClosestRides(Ride mainRide) {
		Vector<Ride> matchRides = new Vector<Ride>();
		allRides.sort(new SortRideByDepartureTime());
		allRides.sort(new SortRideByDepartureAndDestination());
		int counter = 0;

		for (Ride r : allRides) {
			if (checkRidesMarch(mainRide, r) && counter < 3) {
				matchRides.add(r);
				counter++;
			}
		}
		return matchRides;

	}

	public void setAllRides(ArrayList<Ride> allRides) {
		this.allRides = allRides;
	}

	public boolean checkRidesMarch(Ride first, Ride second) {
		if (first.getDeparture().equalsIgnoreCase(second.getDeparture())
				&& first.getDestination().equalsIgnoreCase(second.getDestination()))
			return true;
		else
			return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Ride r : allRides) {
			sb.append("\nride " + counter++ + ": " + r.toString() + "\n");
		}
		return sb.toString();
	}

	public ArrayList<Ride> getAllRides() {
		return allRides;
	}

}
