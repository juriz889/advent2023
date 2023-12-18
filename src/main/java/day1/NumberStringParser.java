package day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberStringParser {
    private static final Map<String, Integer> NUMBER_VS_VALUE = new HashMap<>();

    static {
        NUMBER_VS_VALUE.put("one", 1);
        NUMBER_VS_VALUE.put("two", 2);
        NUMBER_VS_VALUE.put("three", 3);
        NUMBER_VS_VALUE.put("four", 4);
        NUMBER_VS_VALUE.put("five", 5);
        NUMBER_VS_VALUE.put("six", 6);
        NUMBER_VS_VALUE.put("seven", 7);
        NUMBER_VS_VALUE.put("eight", 8);
        NUMBER_VS_VALUE.put("nine", 9);
        NUMBER_VS_VALUE.put("1", 1);
        NUMBER_VS_VALUE.put("2", 2);
        NUMBER_VS_VALUE.put("3", 3);
        NUMBER_VS_VALUE.put("4", 4);
        NUMBER_VS_VALUE.put("5", 5);
        NUMBER_VS_VALUE.put("6", 6);
        NUMBER_VS_VALUE.put("7", 7);
        NUMBER_VS_VALUE.put("8", 8);
        NUMBER_VS_VALUE.put("9", 9);
    }

    public int parse(String s) {
        String[] split = s.split("\n");
        List<Integer> allSums = new ArrayList<>();
        for (String line : split) {
            int indexOfFirstNumber = Integer.MAX_VALUE;
            int firstNumber = 0;
            int indexOfLastNumber = Integer.MIN_VALUE;
            int lastNumber = 0;
            for (String number : NUMBER_VS_VALUE.keySet()) {
                if (line.contains(number)) {
                    int i = line.indexOf(number);
                    System.out.println("Found " + number + " at " + i);
                    if (indexOfFirstNumber >= i) {
                        indexOfFirstNumber = i;
                        firstNumber = NUMBER_VS_VALUE.get(number);
                    }
                     i = line.lastIndexOf(number);
                    if (indexOfLastNumber < i) {
                        indexOfLastNumber = i;
                        lastNumber = NUMBER_VS_VALUE.get(number);
                    }
                }

            }
            allSums.add(Integer.parseInt("" + firstNumber + lastNumber));
            System.out.println(allSums);

        }
        return allSums.stream().mapToInt(Integer::intValue).sum();
    }
}
