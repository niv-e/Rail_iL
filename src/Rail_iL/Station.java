


public class Station {
    String stationName;

    public Station(String stationName){
        this.stationName = stationName;
    }

    public Station(Station station){
        this.stationName= station.stationName;
    }
}
