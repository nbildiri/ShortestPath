import java.util.ArrayList;
import java.util.HashMap;

public class Connections {

    public ArrayList<Station> getConnections(ArrayList<Line> lines, AllStations allStations, Station station) {

        HashMap<Integer, Station> nameToId = new HashMap<>();
        for (Station stat : allStations.getStations()) {
            nameToId.put(stat.getProperties().getObjectid(), stat);
        }

        ArrayList<Station> connections = new ArrayList<>();
        connections.add(station);
        Station currStation;

        for (Line line : lines) {
            for (int index = 0; index < line.getStops().size(); index++) {
                if (line.getStops().get(index) == station.getProperties().getObjectid()) {

                    //if not first in list
                    if (index != 0)
                        connections.add(nameToId.get(line.getStops().get(index - 1)));

                    //if not last in list
                    if (line.getStops().get(index) != line.getStops().get(line.getStops().size() - 1))
                        connections.add(nameToId.get(line.getStops().get(index + 1)));
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


    public double getDistanceBetweenStations(Station station1, Station station2) {

        return distance(station1, station2.getGeometry().getLatitude(), station2.getGeometry().getLongitude());
    }

    private double distance(Station station, double lat, double lon) {

        return Math.sqrt((Math.pow((station.getGeometry().getLatitude() - lat), 2)) +
                (Math.pow((station.getGeometry().getLongitude() - lon), 2)));
    }

    /*
    public void stationConnections(AllStations stations, double lat_1, double lon_1, double lat_2, double lon_2) {

        Station startPoint = getClosestStation(stations, lat_1, lon_1);
        Station endPoint = getClosestStation(stations, lat_2, lon_2);

        double dist = getDistanceBetweenStations(startPoint, endPoint);

        ArrayList<Station> connectionsStartPoint = getConnections(stations, startPoint);


    }

    // get specific connections using connection array and distance between each connection
    public Station getConnections(ArrayList<Station> connections, Station station) {
        double closestDist = Integer.MAX_VALUE;
        double dist;
        Station closestStation = null;

        for (Station stat : connections) {
            dist = Math.sqrt((Math.pow((stat.getGeometry().getLatitude() - station.getGeometry().getLatitude()), 2)) +
                    (Math.pow((stat.getGeometry().getLongitude() - station.getGeometry().getLongitude()), 2)));

            if (dist < closestDist) {
                closestStation = station;
                closestDist = dist;
            }
        }
        return closestStation;
    }*/

}




