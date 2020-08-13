package Rail_iL;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ride {
	String departmentName;
	String destinationName;
	int[] departmentTime;
	int[] destinationTime;

	Scanner s = new Scanner(System.in);

	public Ride() {
		boolean flag = true;
		departmentTime = new int[] { 0, 0, 0, 0 };
		destinationTime = new int[] { 0, 0, 0, 0 };
		setDeptureName();
		while(!setDeptureTime()) {
			System.out.printf("\nPlease enter a valid time\n");
			setDeptureTime();
		}
		flag = setDestinationName();
		flag = setDeptureTime();

		// this.departmentStation = new Station(departmentStation);
		// this.departmentTime = departmentTime;

	}

	public boolean setDeptureTime() {
		System.out.println("Please enter depture time: ");
		String StrDeptureTime = s.nextLine();
		String[] split = StrDeptureTime.split(":");
		int departmentHours = Integer.parseInt(split[0]);
		int departmentMinutes = Integer.parseInt(split[1]);
		if (departmentHours >= 0 && departmentHours <= 23) {
			if (departmentHours >= 10) {
				departmentTime[1] = departmentHours % 10;
				departmentTime[0] = departmentHours / 10;
				
			} else
				departmentTime[1] = departmentHours;
			return true;
		}
		if (departmentMinutes <= 59 && departmentMinutes >= 0) {
			if (departmentMinutes >= 10) {
				departmentTime[3] = departmentMinutes % 10;
				departmentTime[2] = departmentMinutes / 10;
			} else
				departmentTime[3] = departmentMinutes;
			return true;

		}
		return false;
	}

	public int[] getDeptureTime() {
		return this.departmentTime;
	}

	public boolean setDeptureName() {
		System.out.println("Please enter department station: ");
		this.departmentName = s.nextLine();
		return true;
	}

	public String getDeptureName() {
		return departmentName;
	}

	public boolean setDestinationTime() {
		System.out.println("Please enter destination time: ");
		String StrDepartmentTime = s.next();
		String[] split = StrDepartmentTime.split(":");
		int destinationHours = Integer.parseInt(split[0]);
		int destinationMinutes = Integer.parseInt(split[1]);

		if (destinationHours >= 10) {
			destinationTime[1] = destinationHours % 10;
			destinationTime[0] = destinationHours / 10;
		} else
			destinationTime[1] = destinationHours;

		if (destinationMinutes >= 10) {
			destinationTime[3] = destinationMinutes % 10;
			destinationTime[2] = destinationMinutes / 10;
		} else
			destinationTime[3] = destinationMinutes;
		return true;

	}

	public int[] getDestinationTime() {
		return this.destinationTime;
	}

	public boolean setDestinationName() {
		System.out.println("Please enter destination station: ");
		this.destinationName = s.nextLine();

		return true;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDepartment name:\t" + departmentName + "\nDepartment time:\t" + timeToPrint(departmentTime)
				+ "\nDestination name:\t" + destinationName + "\nDestination time:\t" + timeToPrint(destinationTime));
		return sb.toString();
	}

	private String timeToPrint(int[] time) {
		StringBuilder sb = new StringBuilder();
		sb.append(time[0] + "" + time[1] + ":" + time[2] + "" + time[3]);
		return sb.toString();
	}
}
