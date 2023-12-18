package day16;

import java.util.List;

public class SlashSpace implements Tile {
    private boolean hasBeenVisited = false;

    @Override
    public boolean hasBeenVisited() {
        return hasBeenVisited;
    }

    @Override
    public List<Direction> visit(Direction currentDirection) {
        hasBeenVisited = true;
        switch (currentDirection) {
            case NORTH:
                return List.of(Direction.EAST);
            case EAST:
                return List.of(Direction.NORTH);
            case SOUTH:
                return List.of(Direction.WEST);
            case WEST:
                return List.of(Direction.SOUTH);
        }
        throw new IllegalStateException("Unexpected value: " + currentDirection);
    }
}
