import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

public class AllStations {

    @SerializedName("features")
    private ArrayList<Station> stations;


    public AllStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

}
