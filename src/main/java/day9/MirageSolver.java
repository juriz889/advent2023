package day9;

import java.util.ArrayList;
import java.util.List;

public class MirageSolver {
    public int solve(String input) {
        String[] split = input.split(" ");
        List<Integer> initialNumbers = new ArrayList<>();
        for (String s : split) {
            initialNumbers.add(Integer.parseInt(s));
        }
        List<List<Integer>> allNumbers = new ArrayList<>();
        allNumbers.add(initialNumbers);
        while (true) {
            List<Integer> lastNumbers = allNumbers.get(allNumbers.size() - 1);
            List<Integer> newNumbers = new ArrayList<>();
            for (int i = 0; i < lastNumbers.size() - 1; i++) {
                newNumbers.add(lastNumbers.get(i + 1) -lastNumbers.get(i));
            }
            allNumbers.add(newNumbers);
            if (newNumbers.stream().allMatch(i -> i == 0)) {
                break;
            }
        }
        System.out.println("allNumbers = " + allNumbers);
        for (int i = allNumbers.size() - 1; i > 0; i--) {
            List<Integer> currentRow = allNumbers.get(i);
            List<Integer> rowAbove = allNumbers.get(i - 1);
            int lastNumberCurrentRow = currentRow.get(currentRow.size() - 1);
            int lastNumberRowAbove = rowAbove.get(rowAbove.size() - 1);
            rowAbove.add(lastNumberCurrentRow + lastNumberRowAbove);
        }
        return initialNumbers.get(initialNumbers.size() - 1);
    }
}
