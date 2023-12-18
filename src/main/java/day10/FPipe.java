package day10;

import day3.Coordinate;

import java.util.Set;

public class FPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.WEST) {
            return new DirectionWithCoordinate(Direction.SOUTH, new Coordinate(current.x(), current.y() + 1));
        } else if (direction == Direction.NORTH) {
            return new DirectionWithCoordinate(Direction.EAST, new Coordinate(current.x() + 1, current.y()));

        } else {
            throw new RuntimeException("Invalid direction " + direction);
        }
    }

    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.WEST, Direction.NORTH);
    }

    @Override
    public String toString() {
        return "F";
    }
}
