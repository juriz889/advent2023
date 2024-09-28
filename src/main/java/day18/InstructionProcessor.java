package day18;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import day3.Coordinate;

public class InstructionProcessor {
    private static final Map<String, Direction> DIRECTIONS = Map.of(
            "R", Direction.EAST,
            "U", Direction.NORTH,
            "D", Direction.SOUTH,
            "L", Direction.WEST);

    public Map<Integer, TreeSet<Coordinate>> process(Collection<LavaDuctInstruction> instruction) {
        Coordinate current = new Coordinate(0, 0);
        Set<Coordinate> visited = new HashSet<>();
        for (var lavaductinstruction1 : instruction) {
            var direction = DIRECTIONS.get(lavaductinstruction1.direction());
            for (int i = 0; i < lavaductinstruction1.distance(); i++) {
                current = direction.next(current);
                visited.add(current);
            }


        }
        Map<Integer, TreeSet<Coordinate>> result = new HashMap<>();
        for (var visit : visited) {
            result.putIfAbsent(visit.y(), new TreeSet<>());
            result.get(visit.y()).add(visit);
        }
        return result;
    }
}
