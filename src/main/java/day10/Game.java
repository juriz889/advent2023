package day10;

import day3.Coordinate;

import java.util.Optional;
import java.util.Set;

public class Game {
    private final Tile[][] tiles;

    public Game(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int solve() {
        StartingPoint startingPoint = null;

        int startY = 0;
        int startX = 0;
        int y = 0;
        for (Tile[] tile : tiles) {
            startX = 0;
            boolean found = false;
            for (Tile tile1 : tile) {
                if (tile1 instanceof StartingPoint) {
                    startingPoint = (StartingPoint) tile1;
                    startY = y;
                    found = true;
                    break;
                }
                startX++;
            }
            if (found) {
                break;
            }
            y++;
        }
        Set<Direction> directions = startingPoint.getDirections();
        Direction currentDirection = directions.stream().findFirst().get();
        Tile currentTile = startingPoint;
        int result = 0;
        Coordinate current = new Coordinate(startX, startY);
        while (true) {
            result++;
            DirectionWithCoordinate move = currentTile.move(currentDirection, current);
            if (tiles[move.coordinate().y()][move.coordinate().x()] instanceof StartingPoint) {
                break;
            }
            current = move.coordinate();
            currentDirection = move.direction();
            currentTile = tiles[current.y()][current.x()];
            System.out.println("Currently at " + current + " with direction " + currentDirection + " and tile " + currentTile);

        }
        return result / 2;
    }
}
