package day16;

import java.util.List;

public class HorizontalSpace implements Tile {
    private boolean hasBeenVisited = false;

    @Override
    public boolean hasBeenVisited() {
        return hasBeenVisited;
    }

    @Override
    public List<Direction> visit(Direction currentDirection) {
        hasBeenVisited = true;
        if (currentDirection == Direction.EAST || currentDirection == Direction.WEST) {
            return List.of(currentDirection);
        } else {
            return List.of(Direction.WEST, Direction.EAST);
        }
    }


}
