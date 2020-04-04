package org.ghgs.chalenges.graph;

import java.util.ArrayList;
import java.util.List;
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

    public static int routesCountWithMaxStops(RailRoad graph, City start, City target, int maxStops, int pathCount) {
        if (maxStops == 0) {
            return pathCount;
        }

        for(Route route : graph.getCityRoutes(start)) {
            if (route.getTarget().equals(target)) {
                pathCount++;
            } else{
                int currentMaxStops = maxStops-1;
                pathCount = routesCountWithMaxStops(graph, route.getTarget(), target, currentMaxStops, pathCount);
            }
        }

        return pathCount;
    }

    public static int routesCountWithFixedStops(RailRoad graph, City start, City target, final int fixedStops, int stopCount, int pathCount) {
        if (stopCount == fixedStops) {
            return pathCount;
        }

        for(Route route : graph.getCityRoutes(start)) {
            int currentStopCount = stopCount+1;

            if (route.getTarget().equals(target) && currentStopCount == fixedStops) {
                pathCount++;
            } else{
                pathCount = routesCountWithFixedStops(graph, route.getTarget(), target, fixedStops, currentStopCount, pathCount);
            }
        }

        return pathCount;
    }

    public static int shortestDistance(RailRoad graph, City start, City target, int totalDistance, int shortestDistance, List<City> visited) {
        if (visited == null) {
            visited = new ArrayList<>();
        }

        if (visited.contains(start)) {
            return shortestDistance;
        } else {
            visited.add(start);
        }

        int currentTotalDistance = totalDistance;

        for(Route route : graph.getCityRoutes(start)) {
            if (route.getTarget().equals(target) ) {
                int currentShortestDistance = currentTotalDistance += route.getDistance();
                if (shortestDistance == 0) {
                    shortestDistance = currentShortestDistance;
                } else if (currentShortestDistance < shortestDistance) {
                    shortestDistance = currentShortestDistance;
                }

            } else{
                shortestDistance = shortestDistance(graph, route.getTarget(), target, currentTotalDistance + route.getDistance(), shortestDistance ,visited);

            }

        }

        visited.remove(start);
        return shortestDistance;

    }


    public static int totalRoutesCount(RailRoad graph, City start, City target, final int maxDistance, int totalDistance, int pathCount) {
        if (totalDistance == maxDistance) {
            return pathCount;
        }

        for(Route route : graph.getCityRoutes(start)) {
            if (totalDistance + route.getDistance() < maxDistance) {
                if (route.getTarget().equals(target)) {
                    pathCount++;
                }

                pathCount = totalRoutesCount(graph, route.getTarget(), target, maxDistance, totalDistance + route.getDistance(), pathCount);
            }
        }

        return pathCount;
    }

}
