package day19;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Solver {
    public int solve(String workflows, String numbers) {
        WorkflowParser parser = new WorkflowParser();
        Map<String, List<Step>> steps = parser.parse(workflows);
        NumbersParser parser1 = new NumbersParser();
        String[] split = numbers.split("\\n");
        List<Map<String, Integer>> approvedNumbers = new LinkedList<>();
        for (String s : split) {
            Map<String, Integer> numbersMap = parser1.parse(s);
            List<Step> currentSteps = steps.get("in");
            LinkedList<Step> stepsToTake = new LinkedList<>(currentSteps);
            while (!stepsToTake.isEmpty()) {
                Step step = stepsToTake.pop();
                Optional<String> next = step.next(numbersMap);
                if (next.isPresent()) {
                    String s1 = next.get();
                    if (s1.equals("A")) {
                        approvedNumbers.add(numbersMap);
                        break;
                    } else if (s1.equals("R")) {
                        break;
                    } else {
                        stepsToTake.clear();
                        stepsToTake.addAll(steps.get(s1));
                    }
                }
            }
        }
        int result = 0;
        for (Map<String, Integer> approvedNumber : approvedNumbers) {
            result += approvedNumber.values().stream().mapToInt(Integer::intValue).sum();
        }
        return result;
    }
}
