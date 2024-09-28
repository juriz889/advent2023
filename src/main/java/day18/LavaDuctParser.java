package day18;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class LavaDuctParser {
    public Collection<LavaDuctInstruction> parse(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private LavaDuctInstruction parseLine(String line) {
        var parts = line.split(" ");
        var direction = parts[0];
        var distance = Integer.parseInt(parts[1]);
        var color = parts[2];
        color = color.replace("(", "").replace(")", "");
        return new LavaDuctInstruction(direction, distance, color);
    }
}
