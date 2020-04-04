package org.ghgs.chalenges.graph;

import java.util.Objects;

public class Route {

    private final City target;

    private final Integer cost;

    Route(City target, Integer cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return target.equals(route.target) &&
                cost.equals(route.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, cost);
    }

    @Override
    public String toString() {
        return this.target.getName() + this.cost;
    }

}

