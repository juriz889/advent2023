package day17;

import day3.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solver {
    public int solve(String input) {
        BoardParser boardParser = new BoardParser();
        Board board = boardParser.parse(input);
        LinkedList<Path> paths = new LinkedList<>();
        Map<Coordinate, Map<Direction, Integer>> coordinateVSHeatloss = new HashMap<>();
        Path pathEast = new Path(Direction.EAST, 0, new Coordinate(0, 0), 0, 0, board.getBoard(), new ArrayList<>());
        Path pathSouth = new Path(Direction.SOUTH, 0, new Coordinate(0, 0), 0, 0, board.getBoard(), new ArrayList<>());
        paths.add(pathEast);
        paths.add(pathSouth);
        Coordinate goal = new Coordinate(board.getBoard()[0].length - 1, board.getBoard().length - 1);
        //Coordinate goal = new Coordinate(2, 1);
        Path bestPath = null;
        int bestNumberOfSteps = Integer.MAX_VALUE;
        int lowestHeatloss = Integer.MAX_VALUE;
        while (!paths.isEmpty()) {
            Path path = paths.poll();
            if (path.getCurrentCoordinate().equals(goal)) {
                if (lowestHeatloss > path.getHeatloss()) {
                    lowestHeatloss = path.getHeatloss();
                    bestNumberOfSteps = path.getNumberOfSteps();
                    System.out.println("New lowest heatloss: " + lowestHeatloss);
                    bestPath = path;
                }
                continue;
            }
            if (path.getHeatloss() > lowestHeatloss) {
                continue;
            }
            if (bestPath != null) {
                if (path.getHeatloss() + getMinHeatLos(path.getCurrentCoordinate(), goal) > lowestHeatloss) {
                    continue;
                }
            }
            coordinateVSHeatloss.putIfAbsent(path.getCurrentCoordinate(), new HashMap<>());
            Map<Direction, Integer> directionIntegerMap = coordinateVSHeatloss.get(path.getCurrentCoordinate());
            Integer i = directionIntegerMap.get(path.getCurrentDirection());
            if (i != null && i < path.getHeatloss()) {
                continue;
            } else {
                long bestValue = directionIntegerMap.values().stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
                if (bestValue + board.getBoard()[path.getCurrentCoordinate().y()][path.getCurrentCoordinate().x()] + 10 < path.getHeatloss()) {
                    continue;
                }
                directionIntegerMap.put(path.getCurrentDirection(), path.getHeatloss());
            }
            path.next().forEach(paths::addFirst);
            //System.out.println("Trying paths: " + paths.size());
        }
        return lowestHeatloss;
    }

    private int getMinHeatLos(Coordinate coordinate, Coordinate goal) {
        int numberOfSteps = (goal.x() - coordinate.x() * goal.y() - coordinate.y()) / 2;
        return numberOfSteps;
    }
}
