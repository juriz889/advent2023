package day18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import day3.Coordinate;

public class LavaSolver {
    public int solve(String input) throws IOException {
        LavaDuctParser lavaDuctParser = new LavaDuctParser();
        var instructions = lavaDuctParser.parse(input);
        InstructionProcessor processor = new InstructionProcessor();
        var result = processor.process(instructions);
        int min = result.values().stream().mapToInt(t -> t.first().x()).min().getAsInt();
        int max = result.values().stream().mapToInt(t -> t.last().x()).max().getAsInt();
        int minPos = Math.abs(min);
        int minY = result.keySet().stream().mapToInt(Integer::valueOf).min().getAsInt();
        int minYPos = Math.abs(minY);
        char[][] map = new char[result.keySet().size()][max - min + 1];
        for (TreeSet<Coordinate> yLine : result.values()) {
            Coordinate first = yLine.first();
            Coordinate last = yLine.last();
            for (int i = first.x(); i <= last.x(); i++) {
                Coordinate current = new Coordinate(i, first.y());
                if (yLine.contains(current)) {
                    map[minYPos + first.y()][minPos + i] = '#';
                } else {
                    map[minYPos + first.y()][minPos + i] = '.';
                }
            }


        }

        clearFromTopToBottom(map);
        clearFromBottomToTop(map);
        clearFromTopToBottom(map);

        BufferedWriter writer = new BufferedWriter(new FileWriter("raw.txt"));
        writer.write(toString(map));
        writer.close();
        int solution = 0;
        for (int yMap = 0; yMap < map.length; yMap++) {
            char[] row = map[yMap];
            for (int x = 0; x < row.length; x++) {
                if (row[x] == '#' || row[x] == '.') {
                    solution++;
                } else {
                    if (hasHashLeft(row, x) && hasHashRight(row, x) && hasRowDown(map, yMap, x)
                            && hasRowUp(map, yMap, x)) {
                        //row[x] = '#';
                        //solution++;
                    }
                }
            }
        }
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("result.txt"));
        writer2.write(toString(map));
        writer2.close();
        for (char[] map2 : map) {
            System.out.println(String.valueOf(map2));
        }
        return solution;
    }

    private static void clearFromBottomToTop(char[][] map) {
        for (int yMap = map.length - 1; yMap >= 0; yMap--) {
            char[] row = map[yMap];
            for (int x = 0; x < row.length; x++) {
                if (row[x] == '.') {
                    Coordinate down = new Coordinate(x, yMap + 1);
                    Coordinate left = new Coordinate(x - 1, yMap);
                    Coordinate right = new Coordinate(x + 1, yMap);
                    Coordinate up = new Coordinate(x, yMap - 1);
                    checkIfNeighborIsBlank(map, down, row, x);
                    checkIfNeighborIsBlank(map, left, row, x);
                    checkIfNeighborIsBlank(map, right, row, x);
                    checkIfNeighborIsBlank(map, up, row, x);
                }
            }
            for (int x = row.length - 1; x >= 0; x--) {
                if (row[x] == '.') {
                    Coordinate down = new Coordinate(x, yMap + 1);
                    Coordinate left = new Coordinate(x - 1, yMap);
                    Coordinate right = new Coordinate(x + 1, yMap);
                    Coordinate up = new Coordinate(x, yMap - 1);
                    checkIfNeighborIsBlank(map, down, row, x);
                    checkIfNeighborIsBlank(map, left, row, x);
                    checkIfNeighborIsBlank(map, right, row, x);
                    checkIfNeighborIsBlank(map, up, row, x);
                }
            }
        }
    }

    private static void clearFromTopToBottom(char[][] map) {
        for (int yMap = 0; yMap < map.length; yMap++) {
            char[] row = map[yMap];
            for (int x = 0; x < row.length; x++) {
                if (row[x] == '.') {
                    Coordinate down = new Coordinate(x, yMap + 1);
                    Coordinate left = new Coordinate(x - 1, yMap);
                    Coordinate right = new Coordinate(x + 1, yMap);
                    Coordinate up = new Coordinate(x, yMap - 1);
                    checkIfNeighborIsBlank(map, down, row, x);
                    checkIfNeighborIsBlank(map, left, row, x);
                    checkIfNeighborIsBlank(map, right, row, x);
                    checkIfNeighborIsBlank(map, up, row, x);
                }
            }
            for (int x = row.length - 1; x >= 0; x--) {
                if (row[x] == '.') {
                    Coordinate down = new Coordinate(x, yMap + 1);
                    Coordinate left = new Coordinate(x - 1, yMap);
                    Coordinate right = new Coordinate(x + 1, yMap);
                    Coordinate up = new Coordinate(x, yMap - 1);
                    checkIfNeighborIsBlank(map, down, row, x);
                    checkIfNeighborIsBlank(map, left, row, x);
                    checkIfNeighborIsBlank(map, right, row, x);
                    checkIfNeighborIsBlank(map, up, row, x);
                }
            }
        }
    }

    private static void checkIfNeighborIsBlank(char[][] map, Coordinate down, char[] row, int x) {
        if (!CoordinateChecker.isValid(map, down) || map[down.y()][down.x()] == '\u0000') {
            row[x] = '\u0000';
        }
    }

    private String toString(char[][] map) {
        StringBuilder builder = new StringBuilder();
        for (char[] row : map) {
            builder.append(String.valueOf(row));
            builder.append("\n");
        }
        return builder.toString();
    }

    private boolean hasRowDown(char[][] map, int yMap, int x) {
        for (int i = yMap + 1; i < map.length; i++) {
            if (map[i][x] == '#') {
                return true;
            }
        }
        return false;
    }

    private boolean hasRowUp(char[][] map, int yMap, int x) {
        for (int i = yMap - 1; i >= 0; i--) {
            if (map[i][x] == '#') {
                return true;
            }
        }
        return false;
    }

    private boolean hasHashRight(char[] row, int x) {
        for (int i = x + 1; i < row.length; i++) {
            if (row[i] == '#') {
                return true;

            }
        }
        return false;
    }

    private boolean hasHashLeft(char[] row, int x) {
        for (int i = x - 1; i >= 0; i--) {
            if (row[i] == '#') {
                return true;

            }
        }
        return false;
    }
}