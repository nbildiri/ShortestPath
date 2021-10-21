import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;

import com.google.gson.*;


public class ParseJson {

    public AllStations jsonReader() throws IOException {

        // create Gson instance
        Gson gson = new Gson();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        // convert JSON string to Station object
        AllStations allStations = gson.fromJson(reader, AllStations.class);

        // close reader
        reader.close();

        return allStations;

    }
}



