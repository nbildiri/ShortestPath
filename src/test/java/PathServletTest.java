
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PathServletTest {

    @Test
    void doGet() throws IOException {

        // given
        PathServlet servlet = new PathServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("40.5876923").when(request).getParameter("lat1");
        doReturn("-73.9543462").when(request).getParameter("lon1");
        doReturn("40.768249531776064").when(request).getParameter("lat2");
        doReturn("-73.98164872301398").when(request).getParameter("lon2");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(anyString());
    }

    @Test
    void pathServletTest() throws IOException {
        //given
        ParseJson parseStation = new ParseJson();
        ParseLine parseLine = new ParseLine();
        AllStations stations = parseStation.jsonReader();
        ArrayList<Line> lines = parseLine.parseLine();

        //when
        Station station = stations.getStations().get(83);

        //connection
        Connections connections = new Connections();


        //start point - astor pl
        Station startPoint = connections.getClosestStation(stations, -73.99106999861966,
                40.73005400028978);

        //end point - 238th street
        Station endPoint = connections.getClosestStation(stations, -73.90087000018522,
                40.88466700064975);

        //then
        assertEquals(stations.getStations().get(0), connections.getClosestStation(stations, -73.9543462, 40.5876923));

    }


}


