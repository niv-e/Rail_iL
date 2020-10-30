import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Rail_il.Clock;
import Rail_il.Ride;
import Rail_il.RideManager;
public class CheckValidRides {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\WINDOWS 10 PRO\\eclipse-workspace\\Rail_IL\\src\\Rail_il\\Rides details"); // The location should change in another computer
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
		manager.readFile(f);

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
	}
}