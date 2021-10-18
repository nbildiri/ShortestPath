import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.*;


public class ParseJson {

    public static void main(String[] args) {

        try{
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));


            // convert JSON string to Station object
            AllStations allStations = gson.fromJson(reader, AllStations.class);

            // print AllStations object
            System.out.println(allStations.toString());

            // close reader
            reader.close();

        } catch(Exception ex)

        {
            ex.printStackTrace();
        }

    }


}
