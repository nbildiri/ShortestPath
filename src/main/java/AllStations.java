import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllStations {

    @SerializedName("features")
    private ArrayList<Station> stations;


    public AllStations(ArrayList<Station> features) {
        this.stations = features;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

}
