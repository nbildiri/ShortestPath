import java.util.ArrayList;
import java.util.HashSet;

public class Station {

    private Properties properties;
    private Geometry geometry;
    private transient HashSet<Station> connections;
    private transient int distance;
    private transient Station previous;

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

    public void connect(Station station) {
        if (connections == null) {
            connections = new HashSet<>();
        }
            connections.add(station);
    }

    public HashSet<Station> getConnections() {
        return connections;
    }

    public void setPrevious(Station previous) {
        this.previous = previous;
    }

    public Station getPrevious() {
        return previous;
    }
}


