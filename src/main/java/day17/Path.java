package day17;

import day3.Coordinate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Path {
    private final Direction currentDirection;
    private final int stepsInCurrentDirection;
    private final Coordinate currentCoordinate;
    private final int heatloss;

    private final int nubmerOfSteps;

    private final Integer[][] board;

    private final List<Coordinate> visited;

    public Path(Direction currentDirection, int stepsInCurrentDirection, Coordinate currentCoordinate, int heatloss, int nubmerOfSteps, Integer[][] board, List<Coordinate> visited) {
        this.currentDirection = currentDirection;
        this.nubmerOfSteps = nubmerOfSteps;
        this.board = board;
        this.visited = visited;
        if (stepsInCurrentDirection > 3) {
            throw new IllegalArgumentException("Steps in current direction cannot be greater than 3");
        }
        this.stepsInCurrentDirection = stepsInCurrentDirection;
        this.currentCoordinate = currentCoordinate;
        this.heatloss = heatloss;
    }

    public int getNumberOfSteps() {
        return nubmerOfSteps;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public int getHeatloss() {
        return heatloss;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public List<Path> next() {
        List<Path> result = new ArrayList<>();
        Set<Direction> possibleDirections = EnumSet.allOf(Direction.class);
        possibleDirections.remove(currentDirection.getOpposite());
        if (stepsInCurrentDirection == 3) {
            possibleDirections.remove(currentDirection);
        }
        for (Direction value : possibleDirections) {
            Coordinate nextCoordinate = value.next(currentCoordinate);
            if (!CoordinateChecker.isValid(board, nextCoordinate)) {
                continue;
            }
            int heatloss = this.heatloss + board[nextCoordinate.y()][nextCoordinate.x()];
            if (value == currentDirection) {
                result.add(new Path(value, stepsInCurrentDirection + 1, nextCoordinate, heatloss, nubmerOfSteps + 1, board, List.of()));
            } else {
                result.add(new Path(value, 1, nextCoordinate, heatloss, nubmerOfSteps + 1, board, List.of()));
            }
        }
        return result;
    }
}
