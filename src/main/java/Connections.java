import java.util.ArrayList;
import java.util.HashMap;

public class Connections {

    public void setAllConnections(AllStations allStations, ArrayList<Line> lines) {

        HashMap<Integer, Station> stationToId = new HashMap<>();
        for (Station stat : allStations.getStations()) {
            stationToId.put(stat.getProperties().getObjectid(), stat);
        }

        for (Line line : lines) {
            for (int index = 0; index < line.getStops().size(); index++) {

                Station station = stationToId.get(line.getStops().get(index));

                //if not first in list
                if (index != 0) {
                    Station stationBefore = stationToId.get(line.getStops().get(index - 1));
                    station.connect(stationBefore);
                    stationBefore.connect(station);
                }

                //if not last in list
                if (index != line.getStops().size() - 1) {
                    Station stationAfter = stationToId.get(line.getStops().get(index + 1));
                    station.connect(stationAfter);
                    stationAfter.connect(station);
                }
            }

        }
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


