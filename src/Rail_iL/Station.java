
public class Station {
    String stationName;

    public Station(String stationName){
        setStationName(stationName);
    }

    public Station(Station station){
        this.stationName= station.stationName;
    }

    public boolean setStationName(String name){
        if(checkIfNameValid(name)) {
            stationName = name;
            return true;
        }
        return false;
    }

    public boolean checkIfNameValid(String name){
        String tempName = name;
        for(int i =0 ; i< tempName.length() ; i++) {
            char c = (char) tempName.indexOf(i);
            if (!Character.isLetter(c) || c == ' ')
                return false;
        }
        return true;
    }
}
