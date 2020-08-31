
public class IntermediateStation extends Station {

    Clock estimatedStopTime = new Clock();
    public IntermediateStation(String stationName , String estimatedStopTime) {
        super(stationName);
        while(!this.estimatedStopTime.setTime(estimatedStopTime))
            this.estimatedStopTime.setTime(estimatedStopTime);
    }

    public boolean checkIfTimeInRange(Clock departureTime , Clock destinationTime){
        if(estimatedStopTime.timeToCompare()<departureTime.timeToCompare() ||
                estimatedStopTime.timeToCompare()>destinationTime.timeToCompare()) {
            return false;
        }
        return true;
        }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + stationName +":" +" expected stop time: " + estimatedStopTime.toString()+"\n" );

        return sb.toString();

    }
}
