package day5;

public class Mapping {
    private final long destination;
    private final long source;
    private final long range;

    public Mapping(long destination, long source, long range) {
        this.destination = destination;
        this.source = source;
        this.range = range;
    }

    boolean fits(long value) {
        return value >= source && value < source + range;
    }

    long getDestination(long value) {
        return destination + (value - source);
    }
}
