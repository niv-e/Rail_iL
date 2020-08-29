
public class IntermediateStation extends Station {

    Clock expectedStopTime = new Clock();

    public IntermediateStation(String stationName) {
        super(stationName);
        System.out.println("please enter expected stop time: ");
        while(!expectedStopTime.setTime())
            System.out.println("Invalid input please try again");
    }
    
    	Ride r = new Ride();
	public boolean isCorrectExpectedStopTime(Ride r) {
		if(r.getDepartureTime().getHours() > expectedStopTime.getHours() || r.getDestinationTime().getHours() < expectedStopTime.getHours()) {
			return false;
		} else if(((r.getDepartureTime().getHours() == expectedStopTime.getHours())&&(r.getDepartureTime().getMinutes() > expectedStopTime.getMinutes())) 
				||((r.getDestinationTime().getHours() == expectedStopTime.getHours()) && (r.getDestinationTime().getMinutes() < expectedStopTime.getMinutes()))) {
			return false;
		}
		return true;
	}

    public boolean checkIfTimeInRange(Clock departureTime , Clock destinationTime){
        if(expectedStopTime.timeToCompare()<departureTime.timeToCompare() ||
                expectedStopTime.timeToCompare()>destinationTime.timeToCompare()) {
            System.out.println("Invalid time! \nplease make sure the the expected time is in the raid time range");
            System.out.println("Departure time: " + departureTime.toString() + "\n" +
                     "Destination time: " + destinationTime.toString());
            return false;
        }
        return true;
        }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + stationName +":" +" expected stop time: " + expectedStopTime.toString()+"\n" );

        return sb.toString();

    }
}
