import java.util.Scanner;

public class Clock {
	int hours;
	int minutes;

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

	public int timeToCompare(){
		int tempHours =hours;
		int tempMinutes = minutes;
		int timeToCompare = tempMinutes;

		timeToCompare+=(tempHours%10)*100;
		tempHours/=10;
		timeToCompare+=tempHours*1000;
		return timeToCompare;
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
				System.out.println("Invalid time format! please try again\n" + e.getMessage());
				s.nextLine();
				setTime();
		}


		if(checkTime(tempHours,tempMinutes)) {
			hours = tempHours;
			minutes = tempMinutes;
			return true;
		}
		return false;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(hours<0)
			sb.append("0" + hours + ":");
		else
			sb.append(hours + ":");
		if (minutes < 10)
			sb.append("0" + minutes);
		else sb.append(minutes);

		return sb.toString();
	}
}