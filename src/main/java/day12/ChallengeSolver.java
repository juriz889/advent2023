package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChallengeSolver {
    public int solve(String input) {
        ArrangementSolver arrangementSolver = new ArrangementSolver();
        String[] split = input.split("\\n");
        int result = 0;
        for (String s : split) {
            result += arrangementSolver.solve(s);
        }
        return result;
    }

    public long solve2(String input) {
        ArrangementSolver arrangementSolver = new ArrangementSolver();
        String[] split = input.split("\\n");
        long result = 0;
        for (String s : split) {
            long original = arrangementSolver.solve(s);
            String current = s;
            String[] split1 = s.split(" ");
            String left = split1[0];
            String right = split1[1];
            for(int i = 0; i < 4; i++) {
                left += "?" + split1[0];
                right += "," + split1[1];
            }
            System.out.println("Solving " + left + " " + right);
            long unfolded = arrangementSolver.solve(left + " " + right);
            /*long multiplicator = unfolded / original;
            for (int i = 0; i < 4; i++) {
                original = original * multiplicator;
            } */
            result += unfolded;
            System.out.println("Current result is " + result);
        }
        return result;
    }
}
