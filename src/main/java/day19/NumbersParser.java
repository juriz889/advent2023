package day19;

import java.util.HashMap;
import java.util.Map;

public class NumbersParser {
    public Map<String, Integer> parse(String input) {
        String replace = input.replace("{", "").replace("}", "");
        String[] split = replace.split(",");
        Map<String, Integer> result = new HashMap<>();
        for (String s : split) {
            String[] split1 = s.split("=");
            result.put(split1[0], Integer.parseInt(split1[1]));
        }
        return result;
    }
}
