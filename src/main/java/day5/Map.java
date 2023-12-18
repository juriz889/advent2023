package day5;

import java.util.List;

public class Map {
    private final List<Mapping> mappings;

    public Map(List<Mapping> mappings) {
        this.mappings = mappings;
    }

    long getDestination(long source) {
        for (Mapping mapping : mappings) {
            if (mapping.fits(source)) {
                return mapping.getDestination(source);
            }
        }
        return source;
    }
}
