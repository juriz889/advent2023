package day17;

import day16.Tile;
import day3.Coordinate;

public class CoordinateChecker {
    public static boolean isValid(Object[][] map, Coordinate coordinate) {
        if (coordinate.y() < 0 || coordinate.x() < 0) {
            return false;
        }
        return coordinate.y() < map.length && coordinate.x() < map[0].length;
    }
}
