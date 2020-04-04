package org.ghgs.chalenges.graph;

import java.util.Set;

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

}
