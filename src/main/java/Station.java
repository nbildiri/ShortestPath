import java.util.ArrayList;

public class Station {

    private Properties properties;
    private Geometry geometry;
    private ArrayList<Station> connections;
    private double distance;
    Connections conn = new Connections();

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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance()
    {
        return  distance;
    }

    /*public void connect(Station station)
    {
        connections.add(station);
        station.connections.add(this);
    }*/

}
