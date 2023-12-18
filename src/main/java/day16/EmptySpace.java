package day16;

import java.util.List;

public class EmptySpace implements Tile {
    private boolean hasBeenVisited = false;

    @Override
    public boolean hasBeenVisited() {
        return hasBeenVisited;
    }


    @Override
    public List<Direction> visit(Direction currentDirection) {
        hasBeenVisited = true;
        return List.of(currentDirection);
    }
}
