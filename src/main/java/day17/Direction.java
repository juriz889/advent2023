package day17;

import day3.Coordinate;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;


    public Direction getOpposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

    public Coordinate next(Coordinate current) {
        switch (this) {
            case NORTH:
                return new Coordinate(current.x(), current.y() - 1);
            case EAST:
                return new Coordinate(current.x() + 1, current.y());
            case SOUTH:
                return new Coordinate(current.x(), current.y() + 1);
            case WEST:
                return new Coordinate(current.x() - 1, current.y());
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
