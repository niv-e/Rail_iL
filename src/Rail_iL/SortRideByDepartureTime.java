import java.util.Comparator;

public class SortRideByDepartureTime implements Comparator <Ride> {
    public int compare(Ride f , Ride s){
        if (f.departureTime.timeToCompare() > s.departureTime.timeToCompare())
            return 1;
        else if (f.departureTime.timeToCompare() < s.departureTime.timeToCompare())
            return -1;
        else return 0;
    }
    
}
