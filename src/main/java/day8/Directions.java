package day8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directions implements Iterator<Direction> {
    private final List<Direction> directions = new ArrayList<>();
    private int currentIndex = 0;

    public Directions(String input) {
        String[] split = input.split("");
        for (String s : split) {
            directions.add(Direction.valueOf(s));
        }
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Direction next() {
        if (currentIndex == directions.size()) {
            currentIndex = 0;
        }
        return directions.get(currentIndex++);
    }
}
