package day16;

import day3.Coordinate;

import java.util.List;

public interface Tile {
    boolean hasBeenVisited();

    List<Direction> visit(Direction currentDirection);
}
