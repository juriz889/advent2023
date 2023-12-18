package day12;

import java.util.List;

public record ValidResult(boolean valid, List<Integer> numbers, int fineUntil) {
    public ValidResult(boolean valid) {
        this(valid, null, 0);
    }

    public ValidResult(boolean valid, List<Integer> numbers, int fineUntil) {
        this.valid = valid;
        this.numbers = numbers;
        this.fineUntil = fineUntil;
    }
}
