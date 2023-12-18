package day4;

import java.util.List;
import java.util.Set;

public class WinningGame {

    public int findScore(String input) {
        GameParser gameParser = new GameParser();
        String[] split = input.split("\\n");
        int score = 0;
        for (String s : split) {
            int winnings = 0;
            Game game = gameParser.parse(s);
            List<Integer> winningCard = game.getWinningCard();
            List<Integer> myCard = game.getMyCard();
            System.out.println("My cards " + myCard);
            for (Integer i : myCard) {
                if (winningCard.contains(i)) {
                    if (winnings == 0) {
                        winnings = 1;
                    } else {
                        winnings *= 2;
                    }
                }
            }
            score += winnings;
        }
        return score;
    }

}
