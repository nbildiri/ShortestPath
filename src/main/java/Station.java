import java.util.ArrayList;

public class Station {

    private Properties properties;
    private Geometry geometry;
    private ArrayList<Connections> connections;

    public Station(Properties properties, Geometry geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }


    @Override
    public String toString() {
        return "Station [Properties=" + properties + ", Geometry=" + geometry + "]";
    }
}
