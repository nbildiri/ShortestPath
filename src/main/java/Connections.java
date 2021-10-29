import java.util.ArrayList;
import java.util.HashMap;

public class Connections {

    private ArrayList<Station> connections = new ArrayList<>();

    public ArrayList<Station> getConnections(Station station, AllStations allStations) {

        for (Station eachStation : allStations.getStations()) {
            for (int i = 0; i < station.getProperties().getLines().size(); i++) {
                for (int j = 0; j < eachStation.getProperties().getLines().size(); j++) {
                    if (station.getProperties().getLines().get(i).equals
                            (eachStation.getProperties().getLines().get(j))) {
                        connections.add(eachStation);
                    }
                }
            }
        }
        connections = removeDuplicates(connections);
        return connections;
    }

    public ArrayList<Station> removeDuplicates(ArrayList<Station> connections) {
        ArrayList<Station> tempList = new ArrayList<>();
        for (Station element : connections) {
            // If this element is not present in tempList
            // then add it
            if (!tempList.contains(element)) {
                tempList.add(element);
            }
        }
        return tempList;
    }
}




