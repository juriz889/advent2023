package day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
private Game cut;

    @BeforeEach
    void setUp() {
        cut = new Game(new Config(Map.of(Color.RED, 12, Color.GREEN, 13, Color.BLUE, 14 )));
    }

    @Test
    void possible_possible_true() {
        assertTrue(cut.isPossible("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
    }
    @Test
    void oneLine_power_48() {
        assertEquals(cut.getPower("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"),48);
    }
    @Test
    void notPossible_possible_false() {
        assertFalse(cut.isPossible("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
    }
}