import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParseLine {

   public ArrayList<Line> parseLine() throws IOException {

        ArrayList<Line> lines = new ArrayList<>();

            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));

            // convert JSON file to map
            Map<String, ArrayList<String>> map = gson.fromJson(reader, Map.class);

            // print map entries
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                Line line= new Line(entry.getKey(),entry.getValue());
                lines.add(line);
            }

            // close reader
            reader.close();

        return lines;
    }
}
