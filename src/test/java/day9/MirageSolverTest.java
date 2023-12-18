package day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MirageSolverTest {
private MirageSolver cut;

    @BeforeEach
    void setUp() {
        cut = new MirageSolver();
    }

    @Test
    void example_solve_solve() {
        String input = "0 3 6 9 12 15";
        assertEquals(18, cut.solve(input));
    }

    @Test
    void secondTest_solve_solved() {
        String input = "1 3 6 10 15 21";
        assertEquals(28, cut.solve(input));
    }
    @Test
    void thirdTest_solve_solved() {
        String input = "10 13 16 21 30 45";
        assertEquals(68, cut.solve(input));
    }
}