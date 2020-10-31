import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import Rail_il.Clock;
import Rail_il.Ride;
import Rail_il.RideManager;
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

	/*	
//		File f = new File(F_NAME); // The location should change in another computer
		Scanner s = new Scanner(System.in);
		RideManager manager = new RideManager();
		Ride r = new Ride(); 
		System.out.println("What station are you coming from?");
		String departure = s.next();

		r.departure.setStationName(departure);
		System.out.println("What is your destination station?");
		String destination = s.next();
		r.destination.setStationName(destination);

		System.out.println("When are you going to leave the departure station? \nPlease enter the time in format HH:MM: ");
		String time = s.next();

		r.departureTime.setTime(time);
		manager.readFile();

		Clock c = new Clock();	
		c.setTime(time);
		int counter = 0;
		for (Ride r1 : manager.getAllRides()) { 
			if(r1.departure.getStationName().equals(departure) && r1.destination.getStationName().contentEquals(destination)) {
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
		*/
	}
}