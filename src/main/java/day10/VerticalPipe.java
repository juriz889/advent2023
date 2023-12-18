package day10;

import day3.Coordinate;

import java.util.Set;

public class VerticalPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.SOUTH) {
            return new DirectionWithCoordinate(Direction.SOUTH, new Coordinate(current.x(), current.y() + 1));
        } else if (direction == Direction.NORTH) {
            return new DirectionWithCoordinate(Direction.NORTH, new Coordinate(current.x(), current.y() - 1));
        }
        throw new RuntimeException("Invalid direction " + direction);
    }

    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.SOUTH, Direction.NORTH);
    }
    @Override
    public String toString() {
        return "|";
    }
}
