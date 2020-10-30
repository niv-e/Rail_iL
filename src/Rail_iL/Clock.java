package Rail_il;

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

	public boolean setTime(String stringTime){
		int tempHours = 0;
		int tempMinutes = 0;

		try {
			tempHours = Integer.parseInt(stringTime.substring(0,2));
			tempMinutes = Integer.parseInt(stringTime.substring(3,5));

		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}


		if(checkTime(tempHours,tempMinutes)) {
			hours = tempHours;
			minutes = tempMinutes;
			return true;
		}
		return false; 
	}
	public boolean checkIfClose(Clock c) {
		Clock timeAfter = new Clock(this.hours, this.minutes) ;
		Clock timeBefore=new Clock(this.hours, this.minutes) ;
		if(this.minutes>=30) {
			timeAfter.hours++;
			timeAfter.minutes = this.minutes-30;
			timeBefore.minutes = this.minutes-30; 
		}
		else {
			timeBefore.hours--;
			timeBefore.minutes = this.minutes+30;
			timeAfter.minutes = this.minutes+30; 
		}
		if(c.hours==timeAfter.hours) {
			if((timeAfter.minutes-c.minutes<=30 && timeAfter.minutes-c.minutes>=0) 
					|| (timeBefore.minutes-c.minutes>=30))
				return true;
		}
		if(c.hours==timeBefore.hours) {
			if((c.minutes-timeBefore.minutes<=30 && c.minutes-timeBefore.minutes>=0)
					||(c.minutes-timeAfter.minutes>=30)) 
				return true;
		}
		return false;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
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
