package day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameSolver {
    public int solve(char[][] map) {
        int y = 0;
        int result = 0;
        for (char[] chars : map) {
            String currentNumber = "";
            for (int x = 0; x < chars.length; x++) {
                if (Character.isDigit(chars[x])) {
                    currentNumber += chars[x];
                } else {
                    currentNumber = "";
                }
                Coordinate right = new Coordinate(x + 1, y);
                if (!currentNumber.isEmpty()) {
                    if (!CoordinateChecker.isValid(map, right) || !Character.isDigit(chars[x + 1])) {
                        System.out.println("Checking for number " + currentNumber);
                        if (hasNeighbour(map, new Coordinate(x, y), currentNumber)) {
                            result += Integer.parseInt(currentNumber);
                        }
                    }
                }
            }
            y++;
        }
        return result;
    }

    public long solvePart2(char[][] map) {
        int y = 0;
        long result = 0;
        for (char[] chars : map) {
            for (int x = 0; x < chars.length; x++) {
                if (chars[x] == '*') {
                    result += getRatio(map, new Coordinate(x, y));
                }
            }
            y++;
        }
        return result;
    }

    private long getRatio(char[][] map, Coordinate coordinate
    ) {
        System.out.println("Checking for ration at " + coordinate + " for character " + map[coordinate.y()][coordinate.x()]);
        List<Coordinate> toCheck = new ArrayList<>();
        Coordinate topLeft = new Coordinate(coordinate.x() - 1, coordinate.y() - 1);
        Coordinate left = new Coordinate(coordinate.x() - 1, coordinate.y());
        Coordinate bottomLeft = new Coordinate(coordinate.x() - 1, coordinate.y() + 1);
        Coordinate topRight = new Coordinate(coordinate.x() + 1, coordinate.y() - 1);
        Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
        Coordinate bottomRight = new Coordinate(coordinate.x() + 1, coordinate.y() + 1);
        toCheck.add(topLeft);
        toCheck.add(left);
        toCheck.add(bottomLeft);
        toCheck.add(topRight);
        toCheck.add(right);
        toCheck.add(bottomRight);

        for (int i = 0; i < 1; i++) {
            toCheck.add(new Coordinate(coordinate.x() - i, coordinate.y() + 1));
            toCheck.add(new Coordinate(coordinate.x() - i, coordinate.y() - 1));
        }
        List<Coordinate> digits = new ArrayList<>();
        for (Coordinate coordinate1 : toCheck) {
            if (isDigit(map, coordinate1)) {
                System.out.println("Found digit for ration + at " + coordinate1 + " symbol is " + map[coordinate1.y()][coordinate1.x()]);
                digits.add(coordinate1);
            }
        }
        Set<NumberOnCoordinate> numbers = new HashSet<>();
        for (Coordinate digit : digits) {
            numbers.add(findNumber(map, digit));
        }
        System.out.println("Numbers are " + numbers);
        if (numbers.size() == 2) {
            return numbers.stream().map(NumberOnCoordinate::number).reduce(1, (a, b) -> a * b);
        }
        return 0;
    }

    private NumberOnCoordinate findNumber(char[][] map, Coordinate coordinate) {
        int startOfNumber = coordinate.x();
        for (int i = coordinate.x(); i >= 0; i--) {
            if (isDigit(map, new Coordinate(i, coordinate.y()))) {
                startOfNumber = i;
            } else {
                break;
            }
        }
        String number = "";
        for (int i = startOfNumber; i < map[0].length; i++) {
            if (isDigit(map, new Coordinate(i, coordinate.y()))) {
                number += map[coordinate.y()][i];
            } else {
                break;
            }
        }
        return new NumberOnCoordinate(new Coordinate(startOfNumber, coordinate.y()), Integer.parseInt(number));
    }

    private boolean hasNeighbour(char[][] map, Coordinate coordinate
            , String currentNumber) {
        int length = currentNumber.length();
        System.out.println("Checking for " + currentNumber + " at " + coordinate);
        List<Coordinate> toCheck = new ArrayList<>();
        Coordinate topLeft = new Coordinate(coordinate.x() - length, coordinate.y() - 1);
        Coordinate left = new Coordinate(coordinate.x() - length, coordinate.y());
        Coordinate bottomLeft = new Coordinate(coordinate.x() - length, coordinate.y() + 1);
        Coordinate topRight = new Coordinate(coordinate.x() + 1, coordinate.y() - 1);
        Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
        Coordinate bottomRight = new Coordinate(coordinate.x() + 1, coordinate.y() + 1);
        toCheck.add(topLeft);
        toCheck.add(left);
        toCheck.add(bottomLeft);
        toCheck.add(topRight);
        toCheck.add(right);
        toCheck.add(bottomRight);

        for (int i = 0; i < length; i++) {
            toCheck.add(new Coordinate(coordinate.x() - i, coordinate.y() + 1));
            toCheck.add(new Coordinate(coordinate.x() - i, coordinate.y() - 1));
        }
        for (Coordinate coordinate1 : toCheck) {
            if (isSymbol(map, coordinate1)) {
                System.out.println("Found neighbour for " + currentNumber + " at " + coordinate1 + " symbol is " + map[coordinate1.y()][coordinate1.x()]);
                return true;
            }
        }
        System.out.println("No neighbour for " + currentNumber);
        return false;
    }

    private boolean isSymbol(char[][] map, Coordinate coordinate) {
        if (CoordinateChecker.isValid(map, coordinate)) {
            char c = map[coordinate.y()][coordinate.x()];
            return !Character.isDigit(c) && c != '.';
        }
        return false;
    }

    private boolean isDigit(char[][] map, Coordinate coordinate) {
        if (CoordinateChecker.isValid(map, coordinate)) {
            char c = map[coordinate.y()][coordinate.x()];
            return Character.isDigit(c);
        }
        return false;
    }
}
