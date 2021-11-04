import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLine {

    public ArrayList<Line> parseLine() throws IOException {

        ArrayList<Line> lines = new ArrayList<>();

        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));

        // convert JSON file to map
        SubwayLinesJson map = gson.fromJson(reader, SubwayLinesJson.class);

        //  map entries
        for (HashMap.Entry<String, List<Integer>> entry : map.entrySet()) {
            Line line = new Line(entry.getKey(), entry.getValue());
            lines.add(line);
        }

        reader.close();

        return lines;
    }
}
