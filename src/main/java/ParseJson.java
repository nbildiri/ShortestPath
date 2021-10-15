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

            // convert JSON string to Feature object
            Features feature = gson.fromJson(reader, Features.class);

            // print feature object
            System.out.println(feature);


            // close reader
            reader.close();

        } catch(
                Exception ex)

        {
            ex.printStackTrace();
        }

    }


}
