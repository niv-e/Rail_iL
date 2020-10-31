import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import Rail_il.Clock;
import Rail_il.Ride;
import Rail_il.RideManager;
import Rail_il.SortRideByDepartureTime;
public class CheckValidRides {

	final static String F_NAME = "rideDetails.txt";

	public static void main(String[] args) throws IOException {
		
		String depatureStation = args[0];
		String destentionStation = args[1];
		String depatureTime = args[2];
		
		System.out.println(depatureStation);
		System.out.println(destentionStation);
		System.out.println(depatureTime);

		File f = new File(F_NAME);
		RideManager manager = new RideManager();
		Ride webRide = new Ride();
		
		webRide.setDeparture(depatureStation);
		webRide.setDestination(destentionStation);
		webRide.setDepartureTime(depatureTime);
		
		try {
			manager.readFile();

		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		Vector<Ride> closestRides = manager.checkForClosestRides(webRide);
		
		if(closestRides.size()==0)
			System.out.println("Sorry there are no relevant rides for your ride");
		else {
			for(Ride r : closestRides)
				System.out.println(r);
		}
		
//		
//		Clock c = new Clock();
//		c.setTime(depatureTime);
//		int counter = 0;
//		for (Ride r1 : manager.getAllRides()) { 
//			if(r1.getDeparture().equalsIgnoreCase(depatureStation) && 
//					r1.getDestination().equalsIgnoreCase(destentionStation)) {
//				if(r1.getDepartureClock().checkIfClose(c)&&counter<=3) {
//					System.out.println(r1.toString());	
//					counter++;
//				}
//				else
//					System.out.println("Sorry there are no relevant rides for your ride");
//			}
//			else if(manager.getAllRides().indexOf(r1) == manager.getAllRides().size()-1 && counter == 0)
//				System.out.println("Sorry there are no relevant rides for your ride"); 
//		} 
	}
}
