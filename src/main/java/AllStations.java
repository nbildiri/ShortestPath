import java.util.Arrays;

public class AllStations {

    private Features[] features;

    public AllStations(Features[] features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "AllStations{" +
                "features=" + Arrays.toString(features) +
                '}';
    }
}
