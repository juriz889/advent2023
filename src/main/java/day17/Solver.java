package day17;

import day3.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solver {
    public int solve(String input) {
        BoardParser boardParser = new BoardParser();
        Board board = boardParser.parse(input);
        PriorityQueue<Path> paths = new PriorityQueue<>();
        Set<DirectionWithCoordinate> coordinateVSHeatloss = new HashSet<>();
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

            if (coordinateVSHeatloss.add(new DirectionWithCoordinate(path.getCurrentDirection(), path.getStepsInCurrentDirection(), path.getCurrentCoordinate()))) {
                paths.addAll(path.next());
            } else {
                continue;
            }

        }
        return lowestHeatloss;
    }

    private int getMinHeatLos(Coordinate coordinate, Coordinate goal) {
        int numberOfSteps = (goal.x() - coordinate.x() + goal.y() - coordinate.y());
        return numberOfSteps;
    }
}
