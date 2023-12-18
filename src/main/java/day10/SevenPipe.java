package day10;

import day3.Coordinate;

import java.util.Set;

public class SevenPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.NORTH) {
            return new DirectionWithCoordinate(Direction.WEST, new Coordinate(current.x() - 1, current.y()));
        } else if (direction == Direction.EAST) {
            return new DirectionWithCoordinate(Direction.SOUTH, new Coordinate(current.x(), current.y() + 1));
        } else {
            throw new RuntimeException("Invalid direction " + direction);
        }
    }
    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.NORTH, Direction.WEST);
    }
    @Override
    public String toString() {
        return "7";
    }
}
