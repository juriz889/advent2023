package day3;

public record Coordinate(int x, int y) implements Comparable<Coordinate> {

    @Override
    public int compareTo(Coordinate o) {
        if (this.y() == o.y()) {
            return Integer.compare(this.x(), o.x());
        }
        return Integer.compare(this.y(), o.y());
    }

}
