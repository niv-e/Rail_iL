
public class IntermediateStation extends Station {

    Clock expectedStopTime = new Clock();

    public IntermediateStation(String stationName) {
        super(stationName);
        System.out.println("please enter expected stop time: ");
        expectedStopTime.setTime();
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + stationName +":" +" expected stop time: " + expectedStopTime.toString()+"\n" );

        return sb.toString();

    }
}
