import java.util.ArrayList;
import java.util.stream.Collectors;

public class Connections {

    public ArrayList<Station> getConnections(AllStations allStations, Station station) {

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

    public Station getClosestStation(AllStations stations, double lat, double lon) {

        double closestDist = Integer.MAX_VALUE;
        double dist;
        Station closestStation = null;

        for (Station station : stations.getStations()) {
            dist = Math.sqrt((Math.pow((station.getGeometry().getLatitude() - lat), 2)) +
                    (Math.pow((station.getGeometry().getLongitude() - lon), 2)));

            if (dist < closestDist) {
                closestStation = station;
                closestDist = dist;
            }
        }

        return closestStation;
    }

    public double getDistanceBetweenStations(Station station_1, Station station_2) {

        double dist = Math.sqrt((Math.pow((station_2.getGeometry().getLatitude() -
                station_1.getGeometry().getLatitude()), 2)) +
                (Math.pow((station_2.getGeometry().getLongitude() -
                        station_2.getGeometry().getLongitude()), 2)));

        return dist;
    }

    public void stationConnections(AllStations stations, double lat_1, double lon_1, double lat_2, double lon_2) {

        Station startPoint = getClosestStation(stations, lat_1, lon_1);
        Station endPoint = getClosestStation(stations, lat_2, lon_2);

        double dist = getDistanceBetweenStations(startPoint, endPoint);

        ArrayList<Station> connectionsStartPoint = getConnections(stations, startPoint);


    }

    // get specific connections using connection array
    public void getConnections(ArrayList<Station> connections, Station station) {
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
    }
}




