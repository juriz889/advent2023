package day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashCalculatorTest {
    private HashCalculator cut;

    @BeforeEach
    void setUp() {
        cut = new HashCalculator();
    }

    @Test
    void inputIsRn1_hash_30() {
        assertEquals(30, cut.getHashFor("rn=1"));
    }
    @Test
    void twoChars_hash_expected() {
        assertEquals(0, cut.getHashFor("rn"));
        assertEquals(1, cut.getHashFor("qp"));
    }
    @Test
    void inputIsCm_hash_253() {
        assertEquals(253, cut.getHashFor("cm-"));
    }
}