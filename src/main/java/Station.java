import java.util.ArrayList;

public class Station {

    private Properties properties;
    private Geometry geometry;
    private ArrayList<Station> connections;
    private double distance = Integer.MAX_VALUE;
    Connections conn = new Connections();

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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance(Station station)
    {
        return  conn.getDistanceBetweenStations(this, station);
    }

    /*public void connect(Station station)
    {
        connections.add(station);
        station.connections.add(this);
    }*/

}
