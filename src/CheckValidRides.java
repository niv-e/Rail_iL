import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Rail_il.Clock;
import Rail_il.Ride;
import Rail_il.RideManager;
import Rail_il.SortRideByDepartureTime;
public class CheckValidRides {

	final static String F_NAME = "rideDetails";

	public static void main(String[] args) throws IOException {
		
		String depatureStation = args[0];
		String destentionStation = args[1];
		String depatureTime = args[2];
		
		File f = new File(F_NAME);
		RideManager manager = new RideManager();
		Ride webRide = new Ride();
		
		webRide.departure.setStationName(depatureStation);
		webRide.destination.setStationName(destentionStation);
		webRide.departureTime.setTime(depatureTime);
		
		try {
			manager.readFile();

		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		Clock c = new Clock();
		c.setTime(depatureTime);
		int counter = 0;
		for (Ride r1 : manager.getAllRides()) { 
			if(r1.departure.getStationName().equals(depatureStation) && 
					r1.destination.getStationName().contentEquals(destentionStation)) {
				if(r1.departureTime.checkIfClose(c)&&counter<=3) {
					System.out.println(r1.toString());	
					counter++;
				}
				else
					System.out.println("Sorry there are no relevant rides for your ride");
			}
			else if(manager.getAllRides().indexOf(r1) == manager.getAllRides().size()-1 && counter == 0)
				System.out.println("Sorry there are no relevant rides for your ride"); 
		} 
	}
}
