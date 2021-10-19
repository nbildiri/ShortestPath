
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ParseJson {

    public static void main(String[] args) {

        try{
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

            // convert JSON string to User object
            Station station = gson.fromJson(reader, Station.class);

            // print user object
            System.out.println(station);

            // close reader
            reader.close();

        } catch(
                Exception ex)

        {
            ex.getMessage();
        }

    }


}
