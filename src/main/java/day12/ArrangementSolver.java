package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArrangementSolver {
    public long solve(String input) {
        String[] split = input.split(" ");
        String conditionRecords = split[0];
        String numbers = split[1];
        List<Integer> brokenNumbers = parseBrokenNumbers(numbers);
        LinkedList<InputWithIndex> validPaths = new LinkedList<>();
        validPaths.add(new InputWithIndex(
                split[0],
                0,
                new ValidResult(true, brokenNumbers, 0)
        ));
        long foundSolutions = 0;
        while (!validPaths.isEmpty()) {
            InputWithIndex poll = validPaths.poll();
            if (poll.index() == conditionRecords.length()) {
                if (isValid(brokenNumbers, poll.input(), poll.index())) {
                    foundSolutions++;
                }
            } else {
                if (poll.input().charAt(poll.index()) == '?') {
                    char[] charArray = poll.input().toCharArray();
                    charArray[poll.index()] = '#';
                    String withBroken = String.valueOf(charArray);
                    charArray[poll.index()] = '.';
                    String withWorking = String.valueOf(charArray);
                    ValidResult stillValid = isStillValid( withBroken, poll.index() + 1, poll.validResult());
                    if (stillValid.valid()) {
                        validPaths.addFirst(new InputWithIndex(withBroken, poll.index() + 1, stillValid));
                    }
                    ValidResult stillValid1 = isStillValid( withWorking, poll.index() + 1, poll.validResult());
                    if (stillValid1.valid()) {
                        validPaths.addFirst(new InputWithIndex(withWorking, poll.index() + 1, stillValid1));
                    }
                } else {
                    validPaths.addFirst(new InputWithIndex(poll.input(), poll.index() + 1, poll.validResult()));
                }
                //System.out.println("Valid paths "  + validPaths);
            }
        }
        return foundSolutions;
    }

    ValidResult isStillValid(String input, int currentIndex, ValidResult validResult) {
        ParserResult brokensFromInput = getBrokensFromInput(input, validResult.fineUntil(), currentIndex);

        List<Integer> integers = brokensFromInput.brokenNumbers();
        if (integers.size() > validResult.numbers().size()) {
            return new ValidResult(false);
        }
        if (integers.size() > 1) {

        }

        int index = 0;
        for (Integer broken : integers) {
            if (broken > validResult.numbers().get(index)) {
                return new ValidResult(false);
            } else {
                if (index + 1 < validResult.numbers().size())
                    if (validResult.numbers().get(index) < broken) {
                        return new ValidResult(false);
                    }
            }
            index++;
        }


        int currentBroken = integers.stream().mapToInt(Integer::intValue).sum();
        int brokenToReach = validResult.numbers().stream().mapToInt(Integer::intValue).sum();
        int missing = brokenToReach - currentBroken;
        if (missing > getBrokensPosssible(input, currentIndex)) {
            return new ValidResult(false);
        }
        index--;
        if(index  < 0){
            index = 0;
        }
        return new ValidResult(true, validResult.numbers().subList(index, validResult.numbers().size()), brokensFromInput.index());

    }

    boolean isValid(List<Integer> numbers, String input, int currentIndex) {
        List<Integer> brokensInInput = getBrokensFromInput(input, 0, currentIndex).brokenNumbers();
        int index = 0;
        if (brokensInInput.size() != numbers.size()) {
            return false;
        }
        for (Integer number : numbers) {
            if (number != brokensInInput.get(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    private static int getBrokensPosssible(String input, int index) {
        char[] charArray = input.toCharArray();
        int numbersOfBroken = 0;
        for (int i = index - 1; i < charArray.length; i++) {
            if (charArray[i] == '#' || charArray[i] == '?') {
                numbersOfBroken++;
            }
        }
        return numbersOfBroken;
    }

    private static ParserResult getBrokensFromInput(String input, int start, int index) {
        char[] charArray = input.toCharArray();
        int numbersOfBroken = 0;
        List<Integer> currentBrokens = new ArrayList<>();
        int lastFineIndex = 0;
        for (int i = start; i < charArray.length; i++) {
            if (i > index) {
                break;
            }
            if (charArray[i] == '#') {
                numbersOfBroken++;
            } else if (numbersOfBroken > 0) {
                lastFineIndex = index;
                currentBrokens.add(numbersOfBroken);
                numbersOfBroken = 0;
            }
        }
        if (numbersOfBroken > 0) {
            currentBrokens.add(numbersOfBroken);
        }
        return new ParserResult(currentBrokens, lastFineIndex);
    }

    private static List<Integer> parseBrokenNumbers(String numbers) {
        List<Integer> brokenNumbers = new ArrayList<>();
        String[] numbersArray = numbers.split(",");
        for (String s : numbersArray) {
            brokenNumbers.add(Integer.parseInt(s));
        }
        return brokenNumbers;
    }
}
