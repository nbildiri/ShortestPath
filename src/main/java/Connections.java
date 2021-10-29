import java.util.ArrayList;
import java.util.stream.Collectors;

public class Connections {

    public ArrayList<Station> getConnections(Station station, AllStations allStations) {

        ArrayList<Station> connections = new ArrayList<>();

        for (Station eachStation : allStations.getStations()) {
            for (String stationLine : station.getProperties().getLines()) {
                for (String eachStationLine : eachStation.getProperties().getLines()) {
                    if (stationLine.equals(eachStationLine)) {
                        connections.add(eachStation);
                    }
                }
            }
        }
        //remove duplicates
        connections = (ArrayList<Station>) connections.stream()
                .distinct()
                .collect(Collectors.toList());

        return connections;
    }

}




