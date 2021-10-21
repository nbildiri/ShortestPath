

public class Geometry {

    private double[] coordinates;

    public Geometry(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public double getCoordinateInArray(int num) {
        return coordinates[num];
    }

}
