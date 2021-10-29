import java.util.Arrays;
import java.util.List;

public class Properties {

    private String objectid;
    private String name;
    private String line;

    public Properties(String objectid, String name, String line) {
        this.objectid = objectid;
        this.name = name;
        this.line = line;

    }

    public String getObjectid() {
        return objectid;
    }

    public String getName() {
        return name;
    }

    public List<String> getLines(){
        return Arrays.asList(line.split("-"));
    }


}
