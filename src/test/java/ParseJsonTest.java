import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ParseJsonTest {


    @Test
    void jsonReaderParseStations() throws IOException {

        //given
        ParseJson parseStation = new ParseJson();

        //when
        AllStations stations = parseStation.jsonReader();
        Station station = stations.getStations().get(0);

        //then

        //name
        assertEquals("Astor Pl",
                stations.getStations().get(0).getProperties().getName());

        //objectId
        assertEquals(3,
                stations.getStations().get(2).getProperties().getObjectid());

        //coordinates
        assertEquals(-73.99106999861966,
                stations.getStations().get(0).getGeometry().getCoordinates().get(0));

    }

    @Test
    void jsonReaderParseLines() throws IOException {

        //given
        ParseLine parseLine = new ParseLine();

        //when
        ArrayList<Line> lines = parseLine.parseLine();

        //then

        //line
        assertEquals("A", lines.get(0).getLine());

        //stop
        assertEquals(55, lines.get(0).getStops().get(0));


    }

    @Test
    void getConnections() throws IOException {
        //given
        ParseJson parseStation = new ParseJson();
        ParseLine parseLine = new ParseLine();

        //when
        AllStations stations = parseStation.jsonReader();
        ArrayList<Line> lines = parseLine.parseLine();
        Station station = stations.getStations().get(83);
        Connections connections = new Connections();
        connections.setAllConnections(stations, lines);

        //then
        assertTrue(station.getConnections().contains(stations.getStations().get(440)));
        assertTrue(station.getConnections().contains(stations.getStations().get(432)));

    }

    @Test
    void setAllConnections() throws IOException {

        //given
        ParseJson parseStation = new ParseJson();
        ParseLine parseLine = new ParseLine();
        AllStations stations = parseStation.jsonReader();
        ArrayList<Line> lines = parseLine.parseLine();
        Connections connections = new Connections();
        HashSet<Station> conn;

        //when
        connections.setAllConnections(stations, lines);

        //then
        assertTrue(stations.getStations().get(0).getConnections().contains(stations.getStations().get(104)));
        assertTrue(stations.getStations().get(370).getConnections().contains(stations.getStations().get(432)));

    }

    @Test
    void closestStation() throws IOException {
        //given
        ParseJson parseStation = new ParseJson();
        ParseLine parseLine = new ParseLine();
        AllStations stations = parseStation.jsonReader();
        ArrayList<Line> lines = parseLine.parseLine();

        //when
        Station station = stations.getStations().get(83);

        //connection
        Connections connections = new Connections();

        //start point - astor pl
        Station startPoint = connections.getClosestStation(stations, -73.99106999861966,
                40.73005400028978);

        //end point - 238th street
        Station endPoint = connections.getClosestStation(stations, -73.90087000018522,
                40.88466700064975);

        //then
        assertEquals(stations.getStations().get(0), startPoint);
        assertEquals(stations.getStations().get(5), endPoint);

    }

    @Test
    void shortestPath() throws IOException {

        //given
        ParseJson parseStation = new ParseJson();
        ParseLine parseLine = new ParseLine();
        AllStations stations = parseStation.jsonReader();
        ArrayList<Line> lines = parseLine.parseLine();
        Connections connections = new Connections();
        connections.setAllConnections(stations, lines);
        ArrayList<Station> shortestPath;

        //when
        Station startStation = stations.getStations().get(83);
        Station destination = stations.getStations().get(370);

        //from "W 4th St - Washington Sq (Lower)" to "Lower East Side - 2nd Ave"
        ShortestPath path = new ShortestPath(stations, startStation, destination);
        shortestPath = path.getShortestPath();

        //then
        assertEquals(3, shortestPath.size());
        assertEquals(startStation, shortestPath.get(2));
        assertEquals("Broadway - Lafayette St", shortestPath.get(1).getProperties().getName());
        assertEquals(destination, shortestPath.get(0));
    }
}

