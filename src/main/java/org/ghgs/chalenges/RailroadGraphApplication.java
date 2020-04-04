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
        printSafe("4. A distância da rota A-E-B-C-D: ", graph,  City.of("A"), City.of("E"), City.of("B"), City.of("C"), City.of("D"));
        printSafe("5. A distância da rota A-E-D: ", graph, City.of("A"), City.of("E"), City.of("D"));

        System.out.println("6. O número de viagens começando em C e terminando em C com no máximo 3 paradas: " +
                GraphHelper.routesCountWithMaxStops(graph, City.of("C"), City.of("C"), 3, 0));
        System.out.println("7. O número de viagens começando em A e terminando em C com exatamente 4 paradas: " +
                GraphHelper.routesCountWithFixedStops(graph, City.of("A"), City.of("C"), 4, 0, 0));

        System.out.println("8. O comprimento da rota mais curta (em termos de distância a percorrer) de A a C: " +
                GraphHelper.shortestDistance(graph, City.of("A"), City.of("C"), 0, 0, null));
        System.out.println("9. O comprimento da rota mais curta (em termos de distância a percorrer) de B a B: " +
                GraphHelper.shortestDistance(graph, City.of("B"), City.of("B"), 0, 0, null));

        System.out.println("10. O número de rotas diferentes de C para C com uma distância inferior a 30: " +
                GraphHelper.totalRoutesCount(graph, City.of("C"), City.of("C"), 30, 0, 0));
    }

    private static void printSafe(String message, RailRoad graph,  City... cities) {
        try {
            System.out.println(message + GraphHelper.routeDistance(graph, cities));
        } catch (RuntimeException e) {
            System.out.println(message + e.getMessage()) ;
        }
    }

}
