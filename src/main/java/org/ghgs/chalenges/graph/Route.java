package org.ghgs.chalenges.graph;

import java.util.Objects;

public class Route {

    private final City target;

    private final Integer distance;

    Route(City target, Integer distance) {
        this.target = target;
        this.distance = distance;
    }

    public City getTarget() {
        return target;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return target.equals(route.target) &&
                distance.equals(route.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, distance);
    }

    @Override
    public String toString() {
        return this.target.getName() + this.distance;
    }

}
