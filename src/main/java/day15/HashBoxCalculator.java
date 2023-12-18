package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashBoxCalculator {
    private Map<Integer, List<Lens>> lensMap = new HashMap<>();
    private HashCalculator hashCalculator = new HashCalculator();

    public HashBoxCalculator() {
        for (int i = 0; i <= 255; i++) {
            lensMap.put(i, new ArrayList<>());
        }
    }

    public int getHashFor(String input) {
        String[] split = input.split(",");
        for (String s : split) {
            if (s.contains("=")) {
                String[] split1 = s.split("=");
                Lens lens = new Lens(split1[0], getFocalLength(split1));
                int hash = hashCalculator.getHashFor(lens.label());
                List<Lens> lenses = lensMap.get(hash);
                int index = lenses.indexOf(lens);
                if (index != -1) {
                    lenses.set(index, lens);
                } else {
                    lenses.add(lens);
                }
            } else if (s.contains("-")) {
                String[] split1 = s.split("-");
                Lens lens = new Lens(split1[0], getFocalLength(split1));
                int hash = hashCalculator.getHashFor(lens.label());
                lensMap.get(hash).remove(lens);
            } else {
                throw new IllegalStateException("Input did not contain a valid operation " + s);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, List<Lens>> integerListEntry : lensMap.entrySet()) {
            for (int i = 0; i < integerListEntry.getValue().size(); i++) {
                result += (integerListEntry.getKey() +1) * integerListEntry.getValue().get(i).focalLength() * (i + 1);
            }
        }

        return result;
    }

    private static int getFocalLength(String[] split1) {
        if (split1.length == 1)
            return 0;
        return Integer.parseInt(split1[1]);
    }
}
