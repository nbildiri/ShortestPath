import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> getLines(){
        return new ArrayList<>(Arrays.asList(line.split("-")));
    }


}
