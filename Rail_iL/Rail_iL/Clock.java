package Rail_iL;


public class Clock {
	private int hours;
	private int minutes;

	
	public Clock(Clock clock) {
		this.hours = 0;
		this.minutes = 0;
	}
	public Clock(int hours,int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public boolean checkTime(int Hours, int Minutes) {
		if ((Hours < 0 || Hours > 23) || (Minutes < 0 || Minutes > 59)) {
			return true;
		}return false;
	}

}