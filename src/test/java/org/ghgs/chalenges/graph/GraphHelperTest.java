package org.ghgs.chalenges.graph;

import org.ghgs.chalenges.InputHelper;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GraphHelperTest {

    @Test
    public void createRailRoadGraph() {
        final String userGraphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        Set<String> routeSet = InputHelper.parseRouteSet(userGraphInput);

        RailRoad graph = GraphHelper.createGraph(routeSet);

        assertEquals(3, graph.getCityRoutes(City.of("A")).size());
        assertEquals(1, graph.getCityRoutes(City.of("B")).size());
        assertEquals(2, graph.getCityRoutes(City.of("C")).size());
        assertEquals(2, graph.getCityRoutes(City.of("D")).size());
        assertEquals(1, graph.getCityRoutes(City.of("E")).size());
    }

}
