import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParseJsonTest {

    @Test
    void jsonReaderParseStations() throws IOException {

        //given
        ParseJson parse = new ParseJson();

        //then
        AllStations stations = parse.jsonReader();

        //when

        //name
        assertEquals("Astor Pl",
                stations.getFeatureInArray(0).getProperties().getName());

        //objectId
        assertEquals("3",
                stations.getFeatureInArray(2).getProperties().getObjectid());

        //coordinates
        assertEquals(-73.99106999861966,
                stations.getFeatureInArray(0).getGeometry().getCoordinateInArray(0));

    }

    @Test
    void jsonReaderParseLines() throws IOException {

        //given
        ParseLine parse = new ParseLine();

        //then
        ArrayList<Line> lines = parse.parseLine();

        //when

        //line
        assertEquals("A", lines.get(0).getLine());

        //stop
        assertEquals("55", lines.get(0).getStops().get(0));
    }

}