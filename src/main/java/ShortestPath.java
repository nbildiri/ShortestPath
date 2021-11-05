
import java.util.ArrayList;

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
        ArrayList<Station> visited = new ArrayList<>();
        Station shortest = startPoint;
        startPoint.setDistance(0);
        Station curr = startPoint;
        int addDist = 1;


        do {
            for (Station connectedStation : curr.getConnections()) {
                if (connectedStation.getDistance() > curr.getDistance() + addDist) {
                    connectedStation.setDistance(curr.getDistance() + addDist);
                }
                if (connectedStation.getDistance() < shortest.getDistance()) {
                    shortest = connectedStation;
                }
                unvisited.remove(curr);
                visited.add(curr);
                curr = shortest;
            }
        } while (!visited.contains(destination));

        return visited;
    }
}



