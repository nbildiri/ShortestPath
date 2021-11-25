import java.util.*;

public class ShortestPath {

    private AllStations allStations;
    private Station startPoint;
    private Station destination;

    public ShortestPath(AllStations stations, Station stationStart, Station destination) {
        this.allStations = stations;
        this.startPoint = stationStart;
        this.destination = destination;
    }

    public ArrayList<Station> getShortestPath() {

        ArrayList<Station> unvisited = allStations.getStations();
        ArrayList<Station> conn = new ArrayList<>();
        ArrayList<Station> shortestPath = new ArrayList<>();
        startPoint.setDistance(0);
        Station curr = startPoint;
        conn.add(startPoint);
        final int DISTANCE = 1;

        do {
            //get connections of current station
            for (Station station : curr.getConnections()) {

                if (unvisited.contains(station)) {
                    if (conn.contains(station)) {
                        if (station.getDistance() < curr.getDistance() + DISTANCE) {
                            station.setDistance(station.getDistance() + DISTANCE);
                        }
                    }
                    if (!conn.contains(station)) {
                        //set distance to stations connected to curr
                        station.setDistance(curr.getDistance() + DISTANCE);
                    }
                    conn.add(station);
                    station.setPrevious(curr);
                }
            }
            unvisited.remove(curr);
            conn.remove(conn.get(0));
            curr = conn.get(0);
        }
        while (unvisited.contains(destination));

        shortestPath.add(destination);
        Station previous = destination.getPrevious();
        shortestPath.add(previous);

        while (previous != startPoint && previous != null) {
            previous = previous.getPrevious();
            shortestPath.add(previous);
        }

        return shortestPath;
    }
}




