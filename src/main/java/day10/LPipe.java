package day10;

import day3.Coordinate;

import java.util.Set;

public class LPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.WEST) {
            return new DirectionWithCoordinate(Direction.NORTH, new Coordinate(current.x(), current.y() - 1));
        } else if (direction == Direction.SOUTH) {
            return new DirectionWithCoordinate(Direction.EAST, new Coordinate(current.x() + 1, current.y()));
        } else {
            throw new RuntimeException("Invalid direction");
        }
    }
    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.WEST, Direction.SOUTH);
    }
    @Override
    public String toString() {
        return "L";
    }
}
