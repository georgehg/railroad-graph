package org.ghgs.chalenges;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputHelper {

    private static final String GRAPH_OPT = "-g";

    public static String getInputGraph(String[] args) {
        try {
            if (args.length > 0 && GRAPH_OPT.equals(args[0])) {
                return args[1];
            }
        } catch (Exception e) {
            System.out.println("Could not read your graph: " + e);
            throw e;
        }

        try(Scanner console = new Scanner(System.in)) {
            System.out.println("Please insert your Railroad Graph: ");
            String graph = console.nextLine();
            return graph;

        } catch (Exception e) {
            System.out.println("Could not read your graph: " + e.getMessage());
            throw e;
        }

    }

    public static Set<String> parseRouteSet(String graphInput) {
        return Arrays.stream(graphInput.split("[,|;]"))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

}
