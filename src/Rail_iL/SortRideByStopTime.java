import java.util.Comparator;

public class SortRideByStopTime implements Comparator<IntermediateStation> {
	public int compare(IntermediateStation f, IntermediateStation s) {
		if (f.expectedStopTime.timeToCompare() > s.expectedStopTime.timeToCompare())
			return 1;
		else if (f.expectedStopTime.timeToCompare() < s.expectedStopTime.timeToCompare())
			return -1;
		else
			return 0;
	}

}
