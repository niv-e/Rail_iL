package Rail_il;

import java.util.Comparator;

public class SortRideByDepartureAndDestination implements Comparator<Ride>{

	@Override
	public int compare(Ride mainRide, Ride rideToComper) {
		String mainDepartureName = mainRide.getDeparture();
		String rideToComperDepartureName = rideToComper.getDeparture();
		
		String mainDestinationName = mainRide.getDestination();
		String rideToComperDestinationName = rideToComper.getDestination();

		
		if(mainDepartureName.equalsIgnoreCase(rideToComperDepartureName)
				&& mainDestinationName.equalsIgnoreCase(rideToComperDestinationName)){
			return 1;
		}
		
		return 0;
	}
	
	
}
