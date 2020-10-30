package Rail_il;

import java.util.Comparator;

public class SortRideByStopTime implements Comparator<IntermediateStation> {
	public int compare(IntermediateStation f, IntermediateStation s) {
		if (f.estimatedStopTime.timeToCompare() > s.estimatedStopTime.timeToCompare())
			return 1;
		else if (f.estimatedStopTime.timeToCompare() < s.estimatedStopTime.timeToCompare())
			return -1;
		else
			return 0;
	}

}


