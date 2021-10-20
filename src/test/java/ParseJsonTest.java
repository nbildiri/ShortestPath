import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParseJsonTest {

    @Test
    void jsonReader() throws IOException {

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
                stations.getFeatureInArray(2).getProperties().getObjectId());

        //coordinates
        assertEquals( -73.99106999861966,
                40.73005400028978,
                stations.getFeatureInArray(0).getGeometry().getCoordinateInArray(0));

    }

}