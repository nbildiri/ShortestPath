import java.io.IOException;
import java.util.ArrayList;

public class Connections {

    private String station;
    private ArrayList<String> connections;

    public Connections(String station) {
        this.station = station;
    }

    public ArrayList<String> getConnections() throws IOException {

        ParseJson parseStation = new ParseJson();
        AllStations stations = parseStation.jsonReader();

        //get lines for station given
        ArrayList<String> connections = new ArrayList<>();

        ArrayList<String> lines = new ArrayList<>();
        for (Features eachStation : stations.getFeatures()) {
            if (eachStation.getProperties().getName().equalsIgnoreCase(station)) {
                lines = eachStation.getProperties().getLines();
            }
        }

        for (Features eachStation : stations.getFeatures()) {
            ArrayList<String> stationLines = eachStation.getProperties().getLines();

            for (String line : lines) {
                for (String stationLine : stationLines) {
                    if (stationLine.equals(line)) {
                        connections.add(eachStation.getProperties().getObjectid());
                    }
                }
            }
        }

        ArrayList<String> tempList = new ArrayList<String>();
        for (String element : connections) {
            // If this element is not present in tempList
            // then add it
            if (!tempList.contains(element)) {
                tempList.add(element);
            }
        }
        return tempList;
    }
}

