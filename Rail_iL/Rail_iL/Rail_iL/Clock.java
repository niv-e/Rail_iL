package Rail_iL;

import java.util.Scanner;

public class Clock {
	private int hours;
	private int minutes;

	Scanner s = new Scanner(System.in);


	public Clock() {
		this.hours = 0;
		this.minutes = 0;
	}

	public Clock(int hours,int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public boolean checkTime(int Hours, int Minutes) {
		if ((Hours < 0 || Hours >= 24) || (Minutes < 0 || Minutes >= 60)) {
			return false;
		}return true;
	}

	public boolean setTime(){
		System.out.println("Please enter time in format HH:MM :");
		String stringTime = s.next();
		int tempHours = 0;
		int tempMinutes = 0;

		try {
			tempHours = Integer.parseInt(stringTime, 0, 2, 10);
			tempMinutes = Integer.parseInt(stringTime, 3, 5, 10);

		}catch(Exception e){
				System.out.println("Invalid time format! please try again" + e.getMessage());
		}

		if(checkTime(tempHours,tempMinutes)) {
			hours = tempHours;
			minutes = tempMinutes;
			return true;
		}
		return false;
	}

	public int compareTo(Clock otherClock) {
		if (!(otherClock instanceof Clock))
			return -3;
		if (hours < otherClock.hours)
			return -1;
		if (hours > otherClock.hours)
			return 1;
		if (hours == otherClock.hours) {
			if (minutes > otherClock.minutes)
				return 1;
			if (minutes < otherClock.minutes)
				return -1;
			if (hours == otherClock.hours && minutes == otherClock.minutes)
				return 0;
		}
		return -3;
	}

	public String toString(){
		return (hours + ":" +minutes);
	}


}