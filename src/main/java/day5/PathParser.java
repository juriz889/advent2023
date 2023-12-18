package day5;

import java.util.ArrayList;
import java.util.List;

public class PathParser {
    public Map parse(String path) {
        String[] parts = path.split("\\n");
        List<Mapping> mappings = new ArrayList<>();
        for (String part : parts) {
            String[] split = part.split(" ");
            mappings.add(new Mapping(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
        }
        return new Map(mappings);
    }
}
