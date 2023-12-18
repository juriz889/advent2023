package day17;

import day3.Coordinate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Path implements Comparable<Path> {
    private final Direction currentDirection;
    private final int stepsInCurrentDirection;
    private final Coordinate currentCoordinate;
    private final int heatloss;
    private final Integer[][] board;


    public Path(Direction currentDirection, int stepsInCurrentDirection, Coordinate currentCoordinate, int heatloss, Integer[][] board) {
        this.currentDirection = currentDirection;
        this.board = board;
        if (stepsInCurrentDirection > 3) {
            throw new IllegalArgumentException("Steps in current direction cannot be greater than 3");
        }
        this.stepsInCurrentDirection = stepsInCurrentDirection;
        this.currentCoordinate = currentCoordinate;
        this.heatloss = heatloss;
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

    public int getStepsInCurrentDirection() {
        return stepsInCurrentDirection;
    }

    public List<Path> next() {
        List<Path> result = new ArrayList<>();
        Set<Direction> possibleDirections;

        possibleDirections = EnumSet.allOf(Direction.class);
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
                result.add(new Path(value, stepsInCurrentDirection + 1, nextCoordinate, heatloss, board));
            } else {
                result.add(new Path(value, 1, nextCoordinate, heatloss, board));
            }
        }
        return result;
    }

    @Override
    public int compareTo(Path o) {
        return Integer.compare(this.getHeatloss(), o.getHeatloss());
    }
}
