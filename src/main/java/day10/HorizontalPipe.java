package day10;

import day3.Coordinate;

import java.util.Set;

public class HorizontalPipe implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        if (direction == Direction.EAST) {
            return new DirectionWithCoordinate(Direction.EAST, new Coordinate(current.x() + 1, current.y()));
        } else if (direction == Direction.WEST) {
            return new DirectionWithCoordinate(Direction.WEST, new Coordinate(current.x() - 1, current.y()));
        } else {
            throw new RuntimeException("Invalid direction");
        }


    }
    @Override
    public Set<Direction> getDirections() {
        return Set.of(Direction.SOUTH, Direction.NORTH);
    }
    @Override
    public String toString() {
        return "-";
    }
}
