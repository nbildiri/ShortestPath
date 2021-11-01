import java.util.ArrayList;

public class Geometry {

    private ArrayList<Double> coordinates;

    public Geometry(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public double getLatitude(){
        return  getCoordinates().get(0);
    }

    public double getLongitude(){
        return  getCoordinates().get(1);
    }

}
