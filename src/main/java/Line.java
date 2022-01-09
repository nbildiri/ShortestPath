import java.util.List;

public class Line {

    private String line;
    private List<Integer> stops;

    public Line(String line, List<Integer> stops) {
        this.line = line;
        this.stops = stops;
    }

    public String getLine() {
        return line;
    }

    public List<Integer> getStops() {
        return stops;
    }

}
