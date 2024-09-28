package day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowParser {
    public Map<String, List<Step>> parse(String input) {
        String[] split = input.split("\\n");
        Map<String, List<Step>> result = new HashMap<>();
        for (String s : split) {
            String[] split1 = s.split("\\{");
            String name = split1[0].trim();
            List<Step> steps = new ArrayList<>();
            String instructions = split1[1].trim();
            instructions = instructions.replace("}", "");
            String[] workflows = instructions.split(",");
            for (String workflow : workflows) {
                String[] split2 = workflow.split(":");
                if (split2.length > 1) {
                    String s1 = split2[0];
                    if (s1.contains(">")) {
                        String[] split3 = s1.split(">");
                        steps.add(new GreaterThanStep(Integer.parseInt(split3[1].trim()), split3[0].trim(), split2[1].trim()));
                    } else if (s1.contains("<")) {
                        String[] split3 = s1.split("<");
                        steps.add(new LessThanStep(Integer.parseInt(split3[1].trim()), split3[0].trim(), split2[1].trim()));
                    } else {
                        throw new IllegalStateException("Unexpected value: " + s1);
                    }
                } else {
                    steps.add(new TrueStep(split2[0].trim()));
                }

            }
            result.put(name, steps);
        }
        return result;
    }
}
