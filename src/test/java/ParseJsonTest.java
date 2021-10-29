import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParseJsonTest {

    @Test
    void jsonReaderParseStations() throws IOException {

        //given
        ParseJson parse = new ParseJson();

        //then
        AllStations stations = parse.jsonReader();
        Station station = stations.getStations().get(0);

        //when

        //name
        assertEquals("Astor Pl",
                stations.getStations().get(0).getProperties().getName());

        //objectId
        assertEquals("3",
                stations.getStations().get(2).getProperties().getObjectid());

        //coordinates
        assertEquals(-73.99106999861966,
                stations.getStations().get(0).getGeometry().getCoordinateInArray(0));

        //connection
       Connections connections = new Connections();
       ArrayList<Station> conn = connections.getConnections(station, stations);

       assertTrue(conn.contains(stations.getStations().get(0)));



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