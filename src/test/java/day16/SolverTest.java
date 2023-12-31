package day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {
    private Solver cut;

    @BeforeEach
    void setUp() {
        cut = new Solver();
    }

    @Test
    void sample_calc_result() {
        String input = """
                .|...\\....
                |.-.\\.....
                .....|-...
                ........|.
                ..........
                .........\\
                ..../.\\\\..
                .-.-/..|..
                .|....-|.\\
                ..//.|....""";
        assertEquals(46, cut.solve(input));
    }

    @Test
    void puzzle_solve() {
        String input = """
                \\.................-....-.-.|....................|......./.|.\\................|...........|....--..............
                ............-...................|.............|..-.......-/..............-....\\...............................
                |.......//...........................................|...............-......../.....\\....................\\....
                ....|......-.-.............-......\\.....\\......../..................../.......................................
                ..\\..\\../................../.............-............|....-.........................|......|...............|.
                -..|........................./.................\\.........\\./.............\\..|..-...-.............\\............
                .\\......||-..................../................-................./....|........................|.............
                ..............\\./...........-.........../-................-.........\\...\\........../-.......|.................
                ....-..........-.-.....\\......................../.......-..........-/.....................||................|.
                ./..........|/............................\\./............................./....../........\\...-|............\\-
                ........\\.............................-...../............---...........|...............|......\\\\..............
                ........//....|.\\......./...\\.............|..............\\............./...........-.|..-.............|.......
                ...................\\...........-/..-......\\...|........-.|................\\-.......|........\\.................
                |.|....../|............\\./..-........\\..............................-.....................|....../............
                ............-....................-..............-..-................|.//.............-.............-..........
                ..........-.......-......|-................./........../...\\........-.......................-..\\.......\\......
                ................../....|............-....../................./.....................|.................-........
                ...\\..............--..|.....||.....\\.............\\../................................................-.-...../
                .........-......|....-.................-.......\\-................./..|...................|\\.....\\.....|.|-....
                ......................-......................-............/....................\\...../...\\..../...............
                ...../......-...............\\...-....|......../.........\\................................|.........../........
                ........../.......\\..............-...............\\........-|....-......-.............|...........|........./..
                ./...............\\....../....../..../...................................................|.....|.|../......./..
                ....|\\........\\-...../...................-.............\\.\\..................................././..........\\...
                ....................................-..../......................-..///......-...|.|..........................|
                .........-\\.....-...........|........./..........-..\\.....\\./...................-........................-....
                ....../.......././......--.....|.\\..-...-....\\..........................-....-...-..|.|.....|.......\\-./......
                ...-....................-................|.............-../........|../........-.............|\\...............
                ...../...........-......../................|................|.....\\.....-.............../...|....../\\.........
                ./...\\.....\\..-./.........................|................................-....................-.............
                .............\\|.../....\\\\.....\\..|...........\\.....................|......|.|.....|.....-............\\.\\......
                ........................|......-..........-.../......-........|...../.\\|...-................................|.
                .......\\...-...\\..........|.....\\...................\\.........|..........-/.........\\...................../...
                .-|.......|............./..|./....-.../...\\............-......../..............-.......//...-...........||.\\..
                ..|..\\./..-........\\..|....-..\\.........../..............................|..\\..................../..|...../-..
                .|.........-.\\...........................\\..../......./....||............\\..........|............-.\\|.........
                ....................\\..../|............................\\.../..|........./...../............||........\\....../.
                ....................../.....|...................|......|.................|..|.......|................|........
                .....................\\.........-..../.........../../..-......\\.................|.../....................../...
                ........\\.-................/........\\...../....../.|.\\...|/../..........................................-.....
                ....................................|......./...../............-................-/..|.-....................\\..
                ..|.........................-....................../...|.....|.............../.........../.....|\\.............
                .......................................|.\\.|.......................-.......|..............\\............-./....
                ..........//................\\..|./................-.................-..../../|................................
                .|......................................./............/..-.......-.|.........................\\|..|............
                ............................/.-..................-./..../..............|-.........-|..........................
                .................-...|................\\.........|\\...............................\\...........\\...//...........
                ........\\..|.|--.............|.......\\.................|......|\\./.........................\\.|................
                .-|.............|\\|.....\\|././...|..\\.............\\..\\...................\\...........\\...../..................
                ..../..............-..|...|.........-.........\\.....-...........-.....|...\\.-....-../.................\\.......
                ........\\.|........\\\\.........-...............-.......-..................................../..........|.......
                ...............-...................\\/...............\\..-\\...........|.-........-.\\-.....\\....\\..../......-....
                .../-......./..............|.......|..//......-....................../.|....\\......|..\\.........../-\\.........
                .-....|./....-.../....../.....-..............\\..-..\\..-............\\................|...|..........-.......|..
                |......../...................\\..../....\\......./..|.................\\...............\\.........\\../.|......../.
                ../............/........|..|.......................................\\../\\...............\\............/.......\\.
                ........-.-...\\........../.......-....-............./.............-......./................\\..........-.......
                .../-................/......|/........-......|..........|..-..............|/..........................-.......
                ......./............../...................|../...../................./../..........\\../.....\\....\\............
                ..............-..|../-........................|...\\.../...-/..........\\.......\\......\\.................-....-.
                ......................................-/.\\........................../......-..\\..\\........\\...............|..\\
                .............-.........../-|........-........\\....-.....\\....../..\\........................\\......|.......\\...
                .././....................|\\.../\\.........\\.|.............../..../...|......./.\\...|.......\\.........|.........
                ......................./........./-./...........................|/...\\........-.../.................||........
                ..............|./........\\..............\\.............................|/................../............|.-..|.
                .........................-......../........./.....|....-..-.-..............-.-......../.......\\...\\./.........
                .-............../../....\\//......../...|......|......\\..................-......\\.....-....\\|.........|........
                ..............-.....................\\.................\\.|...-............................|......\\.............
                \\\\.....|...........\\............|............................../............................................\\.
                .-........../|...\\..............-...............................\\...........\\.....|......\\..........\\.........
                .\\............\\.|....-........./....../../.....-..\\........|...............-..................|............-.|
                .....\\......-.........-.........|....../..-....|.....\\..../....|........-.....................................
                ..........\\-..-..../\\.....................\\.........-...........|..../-.......................\\....-..........
                ...../............./..|..................../............../../.........|...............-../...................
                .....|...../.....|......-.............................|...........-......................./............/......
                .....................||./.-.................-.........\\.\\..................-..............\\...--.........\\....
                .|......-......-.\\.......-......\\....\\..\\..|.........../......./.....................-..........|.............
                .....\\.....\\............................--..................|..-........\\....\\...\\.|.\\.-...........\\...\\......
                ./...........\\.......\\/......|........./..|................\\-................/....\\...................\\.\\.....
                ..|...............................-.........-.|/......|.....|........\\........................................
                .......|............-............../............-......../..-...\\|-...-..../...........-..........-..-/.......
                ............................-..\\.......................................-.........................\\..........-.
                ........................\\.........|................||...-....\\......\\.....\\.................\\...\\\\....../.....
                ....\\../.....-.......-.................-|...................-../.|-............|........-|......./../...\\.....
                ..................................................\\.......|......./..\\./......../....|....-|.-................
                ....../.........|.......|...|.......\\.../|...............-.......-\\..\\......././..................|..\\.|...../
                ............|.....\\...........-.............................../.....-.................-.../............/.../..
                ...../.......\\............................|.....\\....\\................/..................\\......../...........
                ..................-....\\.........\\|................/|......../.-................|...\\......................--.
                ......-..-.....................................-\\.........|.../.....................|..|.-.....\\...|....\\....-
                ......-......-.................-......|..................................................|....................
                ..\\...............|......../........-......./.............../...........-..........|/.....///\\.....-..........
                .........../..|.............../..........\\|.........................\\...|.....\\||....\\...|.|/.....-....../....
                ...../...../.....-............................................|........|............|.........................
                ......-../\\................../..............\\............\\.................../|...........|.............\\.....
                ...........-..........................-....\\..\\..|.-..............................................\\........|..
                /.--..//....\\...............................-............|..././..............................................
                /...............|.........../..../......................\\.....|............|...........|...................-..
                ..-................\\../|......../...................../...........\\..|.|\\../..................................
                ....|...../.....-......\\.........................-.....//...............|.........-.......|...-....--.........
                ....|..\\.-..../....................|..........\\............./...........\\.../.................................
                ............................\\...................................../.......................|...........\\.......
                .........../.....-.....................\\..\\.-..|............-...............\\.........................-.......
                ......-.......-\\.\\......\\..-.-........./...........\\..........|........................\\.....-.....\\..........
                ..............-....../.-............./........../..............\\-....-.../...../.-............\\......./.-.....
                ......|...................................................||..../...|\\.....................-.../...\\........|.
                ......|.//........................-...../...........-..\\...|......|..................../........../...........
                .....................................................|.........//...........|\\.....\\....................|.../.
                ............-..||...........|....../....................\\...\\................................../.......|......
                ..\\....\\......./-\\.\\...........-\\................|.........../................||.../.....-...........\\........""";
        assertEquals(cut.solve(input), 1);
    }
}