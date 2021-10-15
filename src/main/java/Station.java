import java.util.List;

public class Station {

    private String name;
    private String objectId;
    private double[] coordinates;
    List<Station> connections;

    public Station(String name, String objectId, double[] coordinates, List<Station> connections) {
        this.name = name;
        this.objectId = objectId;
        this.coordinates = coordinates;
        this.connections = connections;
    }
}
