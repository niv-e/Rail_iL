package Rail_il;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		ArrayList<Ride> travels = new ArrayList<Ride>();
		while(!exit) {
			System.out.println("Hi!");
			System.out.println("Please select an option");
			System.out.println("1- Typing travils details");
			System.out.println("2- Data Display");
			System.out.println("9- Exit");
			int option = s.nextInt();
			
			switch(option) {
			case 1:
				boolean addMoreTravels;
				Ride r = new Ride();
				travels.add(r);
				
				do {
					System.out.println("Add More Travels? (true\false)");
					addMoreTravels = s.nextBoolean();
					if(addMoreTravels == true) {
					Ride r1 = new Ride();
			    	travels.add(r1);
					}
				}while(addMoreTravels);
		
			    	break;
			case 2:
				System.out.println(travels.toString());
				
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
