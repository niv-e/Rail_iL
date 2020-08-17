
public class IntermediateStation extends Station {

    Clock expectedStopTime = new Clock();

    public IntermediateStation(String stationName) {
        super(stationName);
        System.out.println("please enter expected stop time: ");
        expectedStopTime.setTime();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + stationName +":" +" expected stop time: " + expectedStopTime.toString()+"\n" );

        return sb.toString();

    }
}
