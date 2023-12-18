package day1;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public int parse(String s) {
        String[] split = s.split("\n");
        List<Integer> allSums = new ArrayList<>();
        for (String line : split) {
            List<Character> allNumbersInLine = new ArrayList<>();
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (Character.isDigit(charArray[i])) {
                    allNumbersInLine.add(charArray[i]);
                }
            }
            System.out.println(allNumbersInLine);
            allSums.add(Integer.parseInt("" + allNumbersInLine.get(0) + allNumbersInLine.get(allNumbersInLine.size() - 1)));
            System.out.println(allSums);

        }
        return allSums.stream().mapToInt(Integer::intValue).sum();
    }
}
