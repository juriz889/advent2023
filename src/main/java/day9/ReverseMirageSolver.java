package day9;

import java.util.ArrayList;
import java.util.List;

public class ReverseMirageSolver {
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
                newNumbers.add(lastNumbers.get(i + 1) - lastNumbers.get(i));
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
            int firstNumberCurrentRow = currentRow.get(0);
            int firstNumberRowAbove = rowAbove.get(0);
            rowAbove.add(0, firstNumberRowAbove - firstNumberCurrentRow);
        }
        return initialNumbers.get(0);
    }
}
