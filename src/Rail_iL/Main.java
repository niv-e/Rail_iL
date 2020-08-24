
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean exit = false;
		RideManager manager = new RideManager();

		while (!exit) {
			System.out.println("Hi!");
			System.out.println("Please select an option");
			System.out.println("1- Typing rides details");
			System.out.println("2- Add intermediate station for exist ride");
			System.out.println("3- Data Display");
			System.out.println("9- Exit");
			int option = s.nextInt();

			switch (option) {
				case 1:
					boolean addMoreRides=true;
					while (addMoreRides) {
						Ride r = new Ride();
						manager.addRide(r);
						System.out.println("would you like to add another ride");
						addMoreRides=toContinue();
					}
					break;

				case 2:
					boolean addMoreStations = true;
					System.out.println("Please enter the main ride number: ");
					int choice = s.nextInt()-1;
					while (addMoreStations) {
						System.out.println("Please enter intermediate station name: ");
						String intermediateName = s.next();
						manager.addIntermediateStop(choice, intermediateName);
						addMoreStations = toContinue();
					}
					break;

				case 3:
					Collections.sort(manager.allRides , new SortRideByDepartureTime());
					Collections.sort(Ride.allIntermediateStations , new SortRideByStopTime());
					System.out.print("sorted by departure time:");
					System.out.print(manager.toString());
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
		s.close();
	}


	public static boolean toContinue() {
		Scanner s = new Scanner(System.in);
		System.out.println("please enter y for yes or any key to exit");
		char c = s.next().charAt(0);
		boolean res = (c == 'y' || c == 'Y')? true:false;
		return res;
	}
}
