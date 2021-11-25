import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;


public class ParseJson {

    public AllStations jsonReader() throws IOException {

        Gson gson = new Gson();

        InputStream in = getClass().getClassLoader().getResourceAsStream("SubwayStations.json");
        InputStreamReader reader = new InputStreamReader(in);

        AllStations allStations = gson.fromJson(reader, AllStations.class);

        reader.close();

        return allStations;

    }
}



