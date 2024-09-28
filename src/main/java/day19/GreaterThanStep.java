package day19;

import java.util.Map;
import java.util.Optional;

public class GreaterThanStep implements Step {
    private final int value;
    private final String variable;
    private final String goal;

    public GreaterThanStep(int value, String variable, String goal) {
        this.value = value;
        this.variable = variable.trim();
        this.goal = goal.trim();
    }

    @Override
    public Optional<String> next(Map<String, Integer> variables) {
        Integer value = variables.get(variable);
        if (value > this.value) {
            return Optional.of(goal);
        }
        return Optional.empty();
    }
}
