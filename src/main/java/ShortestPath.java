
import java.util.*;
import java.util.Queue;

public class ShortestPath {

    private AllStations allStations;
    private Station startPoint;
    private Station destination;

    public ShortestPath(AllStations stations, Station stationStart, Station destination) {
        this.allStations = stations;
        this.startPoint = stationStart;
        this.destination = destination;
    }

    public int getShortestPath() {

        ArrayList<Station> unvisited = allStations.getStations();
        ArrayList<Station> visited = new ArrayList<>();
        ArrayList<Station> conn = new ArrayList<>();
        ArrayList<Station> prev = new ArrayList<>();
        startPoint.setDistance(0);
        Station curr = startPoint;
        conn.add(startPoint);

        do {
            //get connections of current station
            for (Station station : curr.getConnections()) {
               
                prev.add(station);
                if(!visited.contains(station) && !conn.contains(station)) {
                    if (conn.contains(station)) {
                        if (station.getDistance() < curr.getDistance() + 1) {
                            station.setDistance(station.getDistance() + 1);
                        }
                    }
                    if (!conn.contains(station)) {
                        //set distance to stations connected to curr
                        station.setDistance(curr.getDistance() + 1);
                    }
                    conn.add(station);
                }
            }
            unvisited.remove(curr);
            conn.remove(conn.get(0));
            visited.add(curr);
            curr = conn.get(0);
        }
        while (!visited.contains(destination));

        return destination.getDistance();
    }
}




