package day10;

import day3.Coordinate;

import java.util.Set;

public interface Tile {
    Coordinate next(Coordinate previous, Coordinate current);

    DirectionWithCoordinate move(Direction direction, Coordinate current);

    Set<Direction> getDirections();
}
