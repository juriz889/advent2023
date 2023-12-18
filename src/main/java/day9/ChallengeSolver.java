package day9;

public class ChallengeSolver {
    public int solve(String input) {
        String[] split = input.split("\\n");
        MirageSolver mirageSolver = new MirageSolver();
        int result = 0;
        for (String s : split) {
            result += mirageSolver.solve(s);
        }
        return result;
    }
    public int solvePart2(String input) {
        String[] split = input.split("\\n");
        ReverseMirageSolver mirageSolver = new ReverseMirageSolver();
        int result = 0;
        for (String s : split) {
            result += mirageSolver.solve(s);
        }
        return result;
    }
}
