import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;


public class ParseJson {

    public AllStations jsonReader() throws IOException {

        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        AllStations allStations = gson.fromJson(reader, AllStations.class);

        reader.close();

        return allStations;

    }
}



