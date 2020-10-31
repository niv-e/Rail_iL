package Rail_il;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean exit = false;
		RideManager manager = new RideManager();

		while (!exit) {
			System.out.println("\nHi!");
			System.out.println("Please select an option");
			System.out.println("1- Typing rides details");
			System.out.println("2- Add intermediate station for exist ride");
			System.out.println("3- Data Display");
			System.out.println("4- Save details to file");
			System.out.println("5- load detail from file");
			System.out.println("6- Display Rides data according to search requirements");
			System.out.println("9- Exit");
			try {
				int option = s.nextInt();
				s.nextLine(); // clean the buffer from \n

				switch (option) {
				case 1:
					boolean addMoreRides = true;
					while (addMoreRides) {
						Ride r = new Ride();
						System.out.println("Please enter departure station's name: ");
						String departure = s.nextLine();
						Station depatureStation = new Station();
						while(!depatureStation.setStationName(departure)) {
							System.out.println("Invalid input please try again");
						}
						r.setDeparture(depatureStation);

						System.out.println("Please enter departure time in format HH:MM :");
						String stringTime =s.nextLine();
						while(!r.setDepartureTime(stringTime)) {
							System.out.println("Invalid input please try again");
//							System.out.print("");
							stringTime=s.nextLine();
						}
						
						System.out.println("Please enter destination station's name: ");
						String destination = s.nextLine();
						Station destinationStation = new Station();
						while(!destinationStation.setStationName(destination)) {
							System.out.println("Invalid input please try again");
						}
						r.setDestination(destinationStation);
						
						System.out.println("Please enter destination time in format HH:MM :");
						stringTime =s.nextLine();
						while(!r.setDestinationTime(stringTime)) {
							System.out.println("Invalid input please try again");
							System.out.print("");
							stringTime=s.nextLine();
							System.out.println("stringTime input: " + stringTime);

							while(!r.checkIfTimeInRange(r.getDepartureClock(), r.getDestinationClock())) {
								System.out.println("Invalid time input please try again\n" +
										"Departure time: " + r.getDeparture().toString() + "\n" +
										"Destination time: " + r.getDestination().toString()
										+ "\nDestination time can not be entered before departure time! \n");
							}
						
						}
						
						manager.addRide(r);
						System.out.println("would you like to add another ride");
						addMoreRides = toContinue();

					}
					break;

				case 2:
					boolean addMoreStations = true;
					System.out.println("Please enter the main ride number: ");
					int choice = s.nextInt() - 1;
					s.nextLine();

					while (addMoreStations) {
						System.out.println("Please enter intermediate station name: ");
						String intermediateName = s.nextLine();
						System.out.println("Please enter estimated stop time in format HH:MM: ");
						String estimatedStopTime = s.nextLine();
						IntermediateStation i = new IntermediateStation(intermediateName);

						while(!i.setTime(estimatedStopTime)) {
							System.out.println("Please enter estimated stop time in format HH:MM: ");
							estimatedStopTime = s.nextLine();
						}

						i.setTime(estimatedStopTime);
						while(!i.checkIfTimeInRange(manager.allRides.get(choice).getDepartureClock(),
								manager.allRides.get(choice).getDestinationClock())) {
							System.out.println("Invalid time! \n" +
									"please make sure the the expected time is in the raid time range");
							System.out.println("Departure time: "
									+ manager.allRides.get(choice).getDepartureClock().toString() + "\n"
									+ "Destination time: " +
									manager.allRides.get(choice).getDestinationTime().toString());
							System.out.println("Please enter estimated stop time in format HH:MM: ");
							estimatedStopTime = s.nextLine();
							i.setTime(estimatedStopTime);
						}
						manager.allRides.get(choice).addIntermediateStation(i);
						System.out.println("would you like to add another intermediate station? ");
						addMoreStations = toContinue();
					}
					break;

				case 3:
					if(manager.allRides.isEmpty()) {
						System.out.println("Enter rides details first!");
						break;
					}else {
						Collections.sort(manager.allRides, new SortRideByDepartureTime());
						System.out.print(manager.toString());
//						manager.saveToFile(); // The location should change in another computer
//						System.out.println("\n The rides details are saved");
					}
					break;

					
				case 4:
					manager.saveToFile();
					break;
					
				case 5:
					manager.readFile();
					break;
					
				case 6:
					System.out.println("What station are you coming from?");
					String departure = s.next();
					System.out.println("What is your destination station?");
					String destination = s.next();
					System.out.println("When are you going to leave the departure station? \nPlease enter the time in format HH:MM: ");
					String time = s.next();
					manager.showRelevantRides(departure, destination, time);
					break;
					
				case 9:
					System.out.println("bye bye!");
					exit = true;
					break;

				default:
					System.out.println("Invalid Input!");
					break;
				}
			} catch (Exception e) {
				System.out.print("Invalid input please enter number from the select list");
				s.nextLine();
			}
		}
		s.close();
	}

	public static boolean toContinue() {
		Scanner s = new Scanner(System.in);
		System.out.println("please enter y for yes or any key to exit");
		char c = s.next().charAt(0);
		return  (c == 'y' || c == 'Y');
	}
}

