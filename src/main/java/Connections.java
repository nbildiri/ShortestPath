import java.util.ArrayList;
import java.util.HashMap;

public class Connections {

    public ArrayList<Station> getConnections(ArrayList<Line> lines, AllStations allStations, Station station) {

        HashMap<Integer, Station> nameToId = new HashMap<>();
        for (Station stat : allStations.getStations()) {
            nameToId.put(stat.getProperties().getObjectid(), stat);
        }

        ArrayList<Station> connections = new ArrayList<>();

        for (Line line : lines) {
            for (int index = 0; index < line.getStops().size(); index++) {
                if (line.getStops().get(index) == station.getProperties().getObjectid()) {

                    if (!connections.contains(nameToId.get(line.getStops().get(index - 1))) &&
                            !connections.contains(nameToId.get(line.getStops().get(index + 1)))) {
                        //if not first in list
                        if (index != 0) {
                            connections.add(nameToId.get(line.getStops().get(index - 1)));
                        }

                        //if not last in list
                        if (line.getStops().get(index) != line.getStops().get(line.getStops().size() - 1))
                            connections.add(nameToId.get(line.getStops().get(index + 1)));
                    }
                }
            }
        }
        return connections;
    }

    public Station getClosestStation(AllStations stations, double lat, double lon) {

        double closestDist = Integer.MAX_VALUE;
        double dist;
        Station closestStation = null;

        for (Station station : stations.getStations()) {
            dist = distance(station, lat, lon);

            if (dist < closestDist) {
                closestStation = station;
                closestDist = dist;
            }
        }
        return closestStation;
    }

    private double distance(Station station, double lat, double lon) {

        return Math.sqrt((Math.pow((station.getGeometry().getLatitude() - lat), 2)) +
                (Math.pow((station.getGeometry().getLongitude() - lon), 2)));
    }
}



