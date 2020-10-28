package Rail_il;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

	public void saveToFile(String f) throws FileNotFoundException {
		File file = new File(f);
		PrintWriter pw = new PrintWriter(file);
		pw.write(toString());

		pw.close();
	}

	public static void readFile(File f) throws FileNotFoundException {
		try { 
			Scanner scan = new Scanner(new File("C:\\Users\\WINDOWS 10 PRO\\eclipse-workspace\\Rail_IL\\src\\Rail_il\\Rides details"));
			RideManager rideManager = new RideManager();
			Ride r1 = new Ride();
			while(scan.hasNextLine()) {
				scan.nextLine();scan.nextLine();
				scan.next();scan.next();
				r1.departure.setStationName(scan.next()); //departure name
				scan.next();scan.next();
				r1.departureTime.setTime(scan.next()); //departure time
				scan.next();scan.next();
				r1.destination.setStationName(scan.next()); //destination name
				scan.next();scan.next();
				r1.destinationTime.setTime(scan.next()); //destination time
				int num = scan.nextInt();
				scan.nextLine();
				rideManager.addRide(r1);
				ArrayList<IntermediateStation> allIntermediateStations = new ArrayList<IntermediateStation>();
				IntermediateStation is = new IntermediateStation(null);
				for (int i = 0; i < num; i++) {
					String name  = scan.next().trim();
					is.setStationName(name.substring(0,name.length()-1));
					scan.next();scan.next();scan.next();
					is.setTime(scan.next());
					allIntermediateStations.add(is);	
				}

			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

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
