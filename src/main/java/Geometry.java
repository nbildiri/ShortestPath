import java.util.ArrayList;

public class Geometry {

    private ArrayList<Double> coordinates;

    public Geometry(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public double getCoordinateInArray(int num) {
        return coordinates.get(num);
    }

}
