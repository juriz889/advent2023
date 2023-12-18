package day16;

import java.util.List;

public class BackSlashSpace implements Tile{
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
                return List.of(Direction.WEST);
            case EAST:
                return List.of(Direction.SOUTH);
            case SOUTH:
                return List.of(Direction.EAST);
            case WEST:
                return List.of(Direction.NORTH);
        }
        throw new IllegalStateException("Unexpected value: " + currentDirection);
    }

}
