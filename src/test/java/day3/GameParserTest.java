package day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameParserTest {
    private GameParser cut;

    @BeforeEach
    void setUp() {
        cut = new GameParser();
    }

    @Test
    void gameAsString_parse_parsedGame() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..""";
        char[][] parse = cut.parse(input);
        assertEquals(10, parse.length);
        assertEquals(8, Integer.parseInt("" +parse[9][7]));
    }
}