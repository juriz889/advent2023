package day19;

import java.util.Map;
import java.util.Optional;

public interface Step {

    Optional<String> next(Map<String, Integer> variables);
}
