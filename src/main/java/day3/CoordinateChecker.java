package day3;

public class CoordinateChecker {
    public static boolean isValid(char[][] map, Coordinate coordinate) {
        if (coordinate.y() < 0 || coordinate.x() < 0) {
            return false;
        }
        return coordinate.y() < map.length && coordinate.x() < map[0].length;
    }
}
