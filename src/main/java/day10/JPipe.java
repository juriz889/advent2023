package day10;

import day3.Coordinate;

import java.util.Set;

public class JPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.SOUTH) {
            return new DirectionWithCoordinate(Direction.WEST, new Coordinate(current.x() - 1, current.y()));
        } else if (direction == Direction.EAST) {
            return new DirectionWithCoordinate(Direction.NORTH, new Coordinate(current.x(), current.y() - 1));
        } else {
            throw new RuntimeException("Invalid direction");
        }
    }
    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.SOUTH, Direction.EAST);
    }
    @Override
    public String toString() {
        return "J";
    }
}
