public class Features {

    private Properties properties;
    private Geometry geometry;

    public Features(Properties properties, Geometry geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setProperties(Properties properties) {
        this.properties= properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry= geometry;
    }

    @Override
    public String toString() {
        return "Features [Properties=" + properties + ", Geometry=" + geometry + "]";
    }
}
