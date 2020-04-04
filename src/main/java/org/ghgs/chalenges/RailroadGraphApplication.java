package org.ghgs.chalenges;

import org.ghgs.chalenges.graph.GraphHelper;
import org.ghgs.chalenges.graph.RailRoad;

import java.util.Set;

public class RailroadGraphApplication {

    public static void main(String[] args) {
        String inputGraph = InputHelper.getInputGraph(args);
        Set<String> routeSet = InputHelper.parseRouteSet(inputGraph);
        RailRoad railRoadGraph = GraphHelper.createGraph(routeSet);
    }

}
