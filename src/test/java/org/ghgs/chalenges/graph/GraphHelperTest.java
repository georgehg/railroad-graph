package org.ghgs.chalenges.graph;

import org.ghgs.chalenges.InputHelper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GraphHelperTest {

    private static RailRoad GRAPH;

    @BeforeClass
    public static void initGraph() {
        final String userGraphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        Set<String> routeSet = InputHelper.parseRouteSet(userGraphInput);

        GRAPH = GraphHelper.createGraph(routeSet);
    }


    @Test
    public void createRailRoadGraph() {
        assertEquals(3, GRAPH.getCityRoutes(City.of("A")).size());
        assertEquals(1, GRAPH.getCityRoutes(City.of("B")).size());
        assertEquals(2, GRAPH.getCityRoutes(City.of("C")).size());
        assertEquals(2, GRAPH.getCityRoutes(City.of("D")).size());
        assertEquals(1, GRAPH.getCityRoutes(City.of("E")).size());
    }

    @Test
    public void routeDistance_ABC() {
        assertEquals(9, GraphHelper.routeDistance(GRAPH, City.of("A"), City.of("B"), City.of("C")));
    }

    @Test
    public void routeDistance_AD() {
        assertEquals(5, GraphHelper.routeDistance(GRAPH, City.of("A"), City.of("D")));
    }

    @Test
    public void routeDistance_ADC() {
        assertEquals(13, GraphHelper.routeDistance(GRAPH, City.of("A"), City.of("D"), City.of("C")));
    }

    @Test
    public void routeDistance_AEBCD() {
        assertEquals(22, GraphHelper.routeDistance(GRAPH, City.of("A"), City.of("E"), City.of("B"), City.of("C"), City.of("D")));
    }

    @Test(expected = NoSuchRouteException.class)
    public void routeDistance_AED() {
        GraphHelper.routeDistance(GRAPH, City.of("A"), City.of("E"), City.of("D"));
    }

    @Test
    public void routesCountWithMaxStop_CC() {
        assertEquals(2, GraphHelper.routesCountWithMaxStops(GRAPH, City.of("C"), City.of("C"), 3, 0));
    }

    @Test
    public void routesCountWithFixedStops_AC() {
        assertEquals(3, GraphHelper.routesCountWithFixedStops(GRAPH, City.of("A"), City.of("C"), 4, 0, 0));
    }

    @Test
    public void shortestDistance_AC() {
        assertEquals(9, GraphHelper.shortestDistance(GRAPH, City.of("A"), City.of("C"), 0, 0, null));
    }

    @Test
    public void shortestDistance_BB() {
        assertEquals(9, GraphHelper.shortestDistance(GRAPH, City.of("B"), City.of("B"), 0, 0, null));
    }

    @Test
    public void totalRoutesCount_CC() {
        assertEquals(7, GraphHelper.totalRoutesCount(GRAPH, City.of("C"), City.of("C"), 30, 0, 0));
    }

}
