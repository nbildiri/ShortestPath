import java.util.Arrays;
import java.util.List;

public class Properties {

    private int objectid;
    private String name;
    private String line;

    public Properties(Integer objectid, String name, String line) {
        this.objectid = objectid;
        this.name = name;
        this.line = line;

    }

    public int getObjectid() {
        return objectid;
    }

    public String getName() {
        return name;
    }

    public List<String> getLines() {
        return Arrays.asList(line.split("-"));
    }


}
