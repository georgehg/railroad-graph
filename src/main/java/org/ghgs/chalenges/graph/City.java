package org.ghgs.chalenges.graph;

import java.util.Objects;

public class City {

    private final String name;

    private City(String name) {
        this.name = name;
    }

    public static City of(String name) {
        Objects.requireNonNull(name);
        return new City(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
