package org.ghgs.chalenges.graph;

import java.util.*;

public class RailRoad {

    private Map<City, List<Route>> routes;

    public RailRoad() {
        this.routes = new HashMap<>();
    }

    private void addRoute(City city, Route route) {
        if (this.routes.containsKey(city)) {
            this.routes.get(city).add(route);
        } else {
            this.routes.put(city, new LinkedList<>(Collections.singletonList(route)));
        }
    }

    public List<Route> getCityRoutes(City city) {
        return Collections.unmodifiableList(this.routes.get(city));
    }

    public RouteBuilder route() {
        return new RouteBuilder(this);
    }

    public static class RouteBuilder {
        private RailRoad railRoad;
        private City from;
        private City to;

        public RouteBuilder(RailRoad railRoad) {
            this.railRoad = railRoad;
        }

        public RouteBuilder from(City from) {
            this.from = from;
            return this;
        }

        public RouteBuilder to(City to) {
            this.to = to;
            return this;
        }

        public RailRoad withCost(Integer cost) {
            Objects.requireNonNull(cost);
            this.railRoad.addRoute(from, new Route(to, cost));
            return this.railRoad;
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        routes.forEach((city, routeList) ->
            routeList.forEach(route -> {
                stringBuilder.append(city.getName());
                stringBuilder.append(route.toString());
                stringBuilder.append(", ");
            }));

        return stringBuilder.toString();
    }
}
