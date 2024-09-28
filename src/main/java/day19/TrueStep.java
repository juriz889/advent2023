package day19;

import java.util.Map;
import java.util.Optional;

public class TrueStep implements Step {
    private final String goal;

    public TrueStep(String goal) {
        this.goal = goal.trim();
    }

    @Override
    public Optional<String> next(Map<String, Integer> variables) {
        return Optional.of(goal);
    }
}
