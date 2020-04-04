package org.ghgs.chalenges;

import org.ghgs.chalenges.graph.City;
import org.ghgs.chalenges.graph.GraphHelper;
import org.ghgs.chalenges.graph.RailRoad;

import java.util.Set;

public class RailroadGraphApplication {

    public static void main(String[] args) {
        String inputGraph = InputHelper.getInputGraph(args);
        Set<String> routeSet = InputHelper.parseRouteSet(inputGraph);
        RailRoad railRoadGraph = GraphHelper.createGraph(routeSet);
        printTestCases(railRoadGraph);
    }

    private static void printTestCases(RailRoad graph) {
        printSafe("1. A distância da rota A-B-C: ", graph, City.of("A"), City.of("B"), City.of("C"));
        printSafe("2. A distância da rota A-D: ", graph, City.of("A"), City.of("D"));
        printSafe("3. A distância da rota A-D-C: ", graph, City.of("A"), City.of("D"), City.of("C"));
        printSafe("4. A distância da rota A-E, -B-C-D: ", graph,  City.of("A"), City.of("E"), City.of("B"), City.of("C"), City.of("D"));
        printSafe("5. A distância da rota A-E-D: ", graph, City.of("A"), City.of("E"), City.of("D"));
    }

    private static void printSafe(String message, RailRoad graph,  City... cities) {
        try {
            System.out.println(message + GraphHelper.routeDistance(graph, cities));
        } catch (RuntimeException e) {
            System.out.println(message + e.getMessage()) ;
        }
    }

}
