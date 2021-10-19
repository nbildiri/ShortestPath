import java.util.Arrays;

public class Geometry {

    private double[] coordinates;

    public Geometry(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
