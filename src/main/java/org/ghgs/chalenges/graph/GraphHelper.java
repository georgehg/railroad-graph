package org.ghgs.chalenges.graph;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GraphHelper {

    public static RailRoad createGraph(Set<String> routeSet) {
        RailRoad railRoad = new RailRoad();

        routeSet.stream()
            .map(route -> route.split(""))
            .forEach(route -> railRoad.route()
                    .from(City.of(route[0]))
                    .to(City.of(route[1]))
                    .withCost(Integer.valueOf(route[2])));

        return railRoad;
    }

    public static int routeDistance(RailRoad graph, City... cities) {

        AtomicInteger visited = new AtomicInteger(0);

        int routeDistance = IntStream.range(0, cities.length - 1)
                .map(index -> graph.getCityRoutes(cities[index]).stream()
                        .filter(route -> route.getTarget().equals(cities[index + 1]))
                        .mapToInt(route -> {
                            visited.incrementAndGet();
                            return route.getDistance();
                            })
                        .sum())
                .sum();

        if (visited.get() != (cities.length - 1)) {
            throw new NoSuchRouteException();
        }

        return routeDistance;
    }

}
