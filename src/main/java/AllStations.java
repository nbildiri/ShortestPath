import java.util.Arrays;

public class AllStations {

    private Features[] features;


    public AllStations(Features[] features) {
        this.features = features;
    }

    public Features[] getFeatures() {
        return features;
    }

    public Features getFeatureInArray(int num) {
        return features[num];
    }

    @Override
    public String toString() {
        return "AllStations{" +
                "features=" + Arrays.toString(features) +
                '}';
    }
}
