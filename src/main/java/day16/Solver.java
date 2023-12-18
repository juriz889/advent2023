package day16;

import day3.Coordinate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solver {

    public int solve(String input) {
        Set<DirectionWithCoordinate> situations = new HashSet<>();
        TileParser tileParser = new TileParser();
        TileBoard tileBoard = tileParser.parse(input);
        Coordinate current = new Coordinate(0, 0);
        Direction currentDirection = Direction.EAST;
        LinkedList<DirectionWithCoordinate> beams = new LinkedList<>();
        beams.add(new DirectionWithCoordinate(currentDirection, current));
        while (!beams.isEmpty()) {
            DirectionWithCoordinate directionWithCoordinate = beams.poll();
            if (situations.add(directionWithCoordinate) && CoordinateChecker.isValid(tileBoard.getTiles(), directionWithCoordinate.coordinate())) {
                Tile tile = tileBoard.getTiles()[directionWithCoordinate.coordinate().y()][directionWithCoordinate.coordinate().x()];
                    List<Direction> visit = tile.visit(directionWithCoordinate.direction());
                    for (Direction direction : visit) {
                        beams.add(new DirectionWithCoordinate(direction, direction.next(directionWithCoordinate.coordinate())));
                    }

            }
        }
        int result = 0;
        for (Tile[] tile : tileBoard.getTiles()) {
            for (Tile tile1 : tile) {
                if (tile1.hasBeenVisited()) {
                    result++;
                }
            }
        }
        return result;
    }
}
