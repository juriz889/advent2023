package day8;

import java.util.List;
import java.util.Map;

public class Solver {

    public int solve(String directionString, String nodes) {
        Directions directions = new Directions(directionString);
        NodeParser parser = new NodeParser();
        Map<String, Node> parse = parser.parse(nodes);
        Node currentNode = parse.get("AAA");
        int steps = 1;
        while (directions.hasNext()) {
            Direction next = directions.next();
            System.out.println("Direction is " + next + " for node " + currentNode.getName());
            currentNode = next.apply(currentNode);
            if (currentNode.getName().equals("ZZZ")) {
                return steps;
            }
            steps++;
        }
        return steps;
    }

    public int solvePart2(String directionString, String nodes) {
        Directions directions = new Directions(directionString);
        NodeParser parser = new NodeParser();
        Map<String, Node> parse = parser.parse(nodes);
        List<String> currentNodes = parse.keySet().stream().filter(s -> s.endsWith("A")).toList();
        for (String currentNodeStr : currentNodes) {
            int steps = solveStep(currentNodeStr, directions, parse);
            System.out.println("Finished " + currentNodeStr + " in " + steps);
        }

        return -1;
    }

    private int solveStep(String currentNodeStr, Directions directions, Map<String, Node> parse) {
        Node currentNode = parse.get(currentNodeStr);
        int steps = 1;
        while (directions.hasNext()) {
            Direction next = directions.next();
            //System.out.println("Direction is " + next + " for node " + currentNode.getName());
            currentNode = next.apply(currentNode);
            if (currentNode.getName().endsWith("Z")) {
                return steps;
            }
            steps++;
        }
        throw new IllegalStateException("Should not happen");
    }
}
