package Rail_il;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class RideManager {
	ArrayList<Ride> allRides;
	final static String F_NAME = "rideDetails";

	public RideManager(){
		allRides =  new ArrayList<Ride>();
	}

	public void showRelevantRides(String departureName  , String destinationName , String time ) { 
		Clock c = new Clock();
		c.setTime(time); 
		Collections.sort(allRides , new SortRideByDepartureTime());
		for (Ride r : allRides) { 
			if(r.departure.getStationName().equals(departureName) && r.destination.getStationName().contentEquals(destinationName)) {
				if(c.checkIfClose(r.departureTime)) { 
					System.out.println(r.toString());	
				}
			}
		}
	}

	public void addRide (Ride ride){
		allRides.add(ride);
		Collections.sort(allRides , new SortRideByDepartureTime());
	}

	public void saveToFile() throws FileNotFoundException {
		File file = new File("rideDetails");
		PrintWriter pw;
		
		if( file.exists()) {
			String newFileName = F_NAME + new Clock().getHours();
			File newFile = new File(newFileName);
			pw = new PrintWriter(newFile);
			pw.write(toString());
			pw.close();
			System.out.println("new file was created: " + newFileName );
			return;
		}
		
		pw = new PrintWriter(file);
		pw.write(toString());
		pw.close();
		System.out.println("new file was created: rideDetails" );

	}

	public void readFile() throws FileNotFoundException {
		try { 
			Scanner scan = new Scanner(new File(F_NAME)); // The location should change in another computer

			while(scan.hasNextLine()) {
				Ride r = new Ride(); 
				scan.nextLine();scan.nextLine();
				scan.next();scan.next();
				r.departure.setStationName(scan.nextLine().trim()); //departure name
				scan.next();scan.next();
				r.departureTime.setTime(scan.next()); //departure time
				scan.next();scan.next();
				r.destination.setStationName(scan.nextLine().trim()); //destination name
				scan.next();scan.next();
				r.destinationTime.setTime(scan.next()); //destination time
				int num = scan.nextInt();
				scan.nextLine();scan.nextLine();
				IntermediateStation is = new IntermediateStation("tocheck");
				if(num ==0)
					scan.nextLine();
				for (int i = 0; i < num; i++) {
					String name  = scan.next().trim();
					is.setStationName(name.substring(0,name.length()-1));
					scan.next();scan.next();scan.next();
					is.setTime(scan.next());
					r.addIntermediateStation(is);
				}
				this.allRides.add(r);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void setAllRides(ArrayList<Ride> allRides) {
		this.allRides = allRides;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		int counter =1;
		for ( Ride r : allRides) {
			sb.append("\nride " + counter++ +": " + r.toString() +"\n");
		}
		return sb.toString();
	}

	public ArrayList<Ride> getAllRides() {
		return allRides;
	}


}
