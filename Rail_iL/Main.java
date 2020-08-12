package Rail_iL;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		ArrayList<Ride> Rides = new ArrayList<Ride>();
		while(!exit) {
			System.out.println("Hi!");
			System.out.println("Please select an option");
			System.out.println("1- Typing travils details");
			System.out.println("2- Data Display");
			System.out.println("9- Exit");
			int option = s.nextInt();
			
			switch(option) {
			case 1:
				boolean addMoreRides;
				Ride r = new Ride();
				Rides.add(r);
				
				do {
					System.out.println("Add More Travels? (true\false)");
					addMoreRides = s.nextBoolean();
					if(addMoreRides == true) {
					Ride r1 = new Ride();
			    	travels.add(r1);
					}
				}while(addMoreRides);
		
			    	break;
			case 2:
				for (Ride ride : Rides) {
					System.out.println(ride.toString());
				
				break;
			case 9:
				System.out.println("bye bye!");
				exit = true;
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
			
		}
		



	}

}
