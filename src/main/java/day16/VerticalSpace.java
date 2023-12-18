package day16;

import java.util.List;

public class VerticalSpace implements Tile {
    private boolean hasBeenVisited = false;

    @Override
    public boolean hasBeenVisited() {
        return hasBeenVisited;
    }

    @Override
    public List<Direction> visit(Direction currentDirection) {
        hasBeenVisited = true;
        if (currentDirection == Direction.NORTH || currentDirection == Direction.SOUTH) {
            return List.of(currentDirection);
        } else {
            return List.of(Direction.NORTH, Direction.SOUTH);
        }
    }

}
