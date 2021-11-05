import java.util.ArrayList;

public class Station {

    private Properties properties;
    private Geometry geometry;
    private ArrayList<Station> connections;
    private int distance;

    public Station(Properties properties, Geometry geometry) {
        this.properties = properties;
        this.geometry = geometry;
        distance = Integer.MAX_VALUE;
    }

    public Properties getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public ArrayList<Station> getConnections() {
        return connections;
    }
}
