package org.ghgs.chalenges;

import org.ghgs.chalenges.graph.City;
import org.ghgs.chalenges.graph.RailRoad;
import org.junit.Test;

import static org.junit.Assert.*;

public class RailRoadTest {

    @Test
    public void createRailRoadWithRoutes() {

        RailRoad railRoad = new RailRoad()
                .route()
                    .from(City.of("A"))
                    .to(City.of("B"))
                    .withCost(5)
                .route()
                    .from(City.of("C"))
                    .to(City.of("D"))
                    .withCost(8)
                .route()
                    .from(City.of("A"))
                    .to(City.of("D"))
                    .withCost(5)
                .route()
                    .from(City.of("C"))
                    .to(City.of("E"))
                    .withCost(2);

        assertEquals("B5", railRoad.getCityRoutes(City.of("A")).get(0).toString());
        assertEquals("D5", railRoad.getCityRoutes(City.of("A")).get(1).toString());
        assertEquals("D8", railRoad.getCityRoutes(City.of("C")).get(0).toString());
        assertEquals("E2", railRoad.getCityRoutes(City.of("C")).get(1).toString());
    }

}
