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
		
		String inputFormat = args[0];
		String depatureStation = args[1];
		String destentionStation = args[2];
		String depatureTime = args[3];
		
//		System.out.println(inputFormat);
//		System.out.println(depatureStation);
//		System.out.println(destentionStation);
//		System.out.println(depatureTime);

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
		
		switch (args[0]) {
		case "html":
			if(closestRides.size()==0)
				System.out.println("Sorry there are no relevant rides for your ride");
			else {
				for(int i=0 ; i<3 && i<closestRides.size(); i++) {
				System.out.println(closestRides.get(i).toHtml());
				System.out.println("<br>");

				}
			}
			break;

		default:
		if(closestRides.size()==0)
			System.out.println("Sorry there are no relevant rides for your ride");
		else {
			for(Ride r : closestRides)
				System.out.println(r);
		}
			break;
		}
	}
}

