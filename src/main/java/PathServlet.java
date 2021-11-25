import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PathServlet extends HttpServlet {
    private Gson gson;
    private ParseJson parseStation;
    private ParseLine parseLine;
    private AllStations stations;
    private ShortestPath shortestPath;
    private Connections connections;
    private ArrayList<Line> lines;

    public PathServlet() throws IOException {
        parseStation = new ParseJson();
        stations = parseStation.jsonReader();
        parseLine = new ParseLine();
        lines = parseLine.parseLine();
        connections = new Connections();
        connections.setAllConnections(stations, lines);
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();

        double lat1 = Double.parseDouble(request.getParameter("lat1"));
        double lon1 = Double.parseDouble(request.getParameter("lon1"));
        double lat2 = Double.parseDouble(request.getParameter("lat2"));
        double lon2 = Double.parseDouble(request.getParameter("lon2"));
        Station start = connections.getClosestStation(stations, lat1, lon1);
        Station end = connections.getClosestStation(stations, lat2, lon2);

        shortestPath = new ShortestPath(stations,start, end);

        List<Station> stationList = shortestPath.getShortestPath();
        String json = gson.toJson(stationList);

        out.println(json);
    }
}
