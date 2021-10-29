public class Station {

    private Properties properties;
    private Geometry geometry;

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
