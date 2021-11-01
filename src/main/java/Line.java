import java.lang.reflect.Array;
import java.util.ArrayList;

public class Line {

    private String line;
    private ArrayList<String> stops;

    public Line(String line, ArrayList<String> stops) {
        this.line = line;
        this.stops = stops;
    }

    public String getLine() {
        return line;
    }

    public ArrayList<String> getStops() {
        return stops;
    }

}
