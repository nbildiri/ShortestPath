import java.lang.reflect.Array;
import java.util.ArrayList;

public class Line {

    private String line;
    private ArrayList<Integer> stops;

    public Line(String line, ArrayList<Integer> stops) {
        this.line = line;
        this.stops = stops;
    }

    public String getLine() {
        return line;
    }

    public ArrayList<Integer> getStops() {
        return stops;
    }

}
