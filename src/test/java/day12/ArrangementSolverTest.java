package day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrangementSolverTest {
private ArrangementSolver cut;

    @BeforeEach
    void setUp() {
        cut = new ArrangementSolver();
    }

    @Test
    void simpleInputWithOneSolution_solve_one() {
        String input = "???.### 1,1,3";
        assertEquals(1, cut.solve(input));
    }
    @Test
    void simpleInputWithFourSolution_solve_four() {
        String input = ".??..??...?##. 1,1,3";
        assertEquals(4, cut.solve(input));
    }
    @Test
    void simpleInputWithTenSolution_solve_ten() {
        String input = "?###???????? 3,2,1";
        assertEquals(10, cut.solve(input));
    }
    @Test
    void simpleInputWithTenSolutionUnfold1_solve_ten() {
        String input = "?###??????????###???????? 3,2,1,3,2,1";
        assertEquals(10, cut.solve(input));
    }
    @Test
    void simpleInputWithSlowSolutionUnfold1_solve_ten() {
        String input = "??????????????????.????????????????????.? 1,5,4,4,1,1,5,4,4,1";
        assertEquals(5, cut.solve(input));
    }

    @Test
    void simpleInputWithTenSolutionNonUfold1_solve_ten() {
        String input = "?###??????????###???????? 3,2,1,3,2,1";
        assertEquals(10, cut.solve(input));
    }
    @Test
    void simpleInputWithTenSolutionUnfold3_solve_ten() {
        String input = "?###??????????###??????????###???????? 3,2,1,3,2,1,3,2,1";
        assertEquals(2250, cut.solve(input));
    }
    @Test
    void simpleInputWithFourSolution_solve_four2() {
        String input = "????.######..#####. 1,6,5";
        assertEquals(4, cut.solve(input));
    }
    @Test
    void simpleInputWithFourSolutionUnfold1_solve_four2() {
        String input = "????.######..#####.?????.######..#####. 1,6,5,1,6,5";
        assertEquals(4, cut.solve(input));
    }
    @Test
    void simpleInputWithFourSolutionUnfold2_solve_four2() {
        String input = "????.######..#####.?????.######..#####.?????.######..#####. 1,6,5,1,6,5,1,6,5";
        assertEquals(100, cut.solve(input));
    }
    @Test
    void simpleInputWithOneSolution_solve_one2() {
        String input = "?#?#?#?#?#?#?#? 1,3,1,6";
        assertEquals(1, cut.solve(input));
    }
    @Test
    void simpleInputWithOneSolution_solve_one3() {
        String input = "????.#...#... 4,1,1";
        assertEquals(1, cut.solve(input));
    }
    @Test
    void unfold1_solve_one3() {
        String input = ".??..??...?##.?.??..??...?##.?.??..??...?##. 1,1,3,1,1,3,1,1,3";
        assertEquals(1, cut.solve(input));
    }

}