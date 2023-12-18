package day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MirageReverseSolverTest {
private ReverseMirageSolver cut;

    @BeforeEach
    void setUp() {
        cut = new ReverseMirageSolver();
    }

    @Test
    void example_solve_solve() {
        String input = "0 3 6 9 12 15";
        assertEquals(-3, cut.solve(input));
    }

    @Test
    void secondTest_solve_solved() {
        String input = "1 3 6 10 15 21";
        assertEquals(0, cut.solve(input));
    }
    @Test
    void thirdTest_solve_solved() {
        String input = "10 13 16 21 30 45";
        assertEquals(5, cut.solve(input));
    }
}