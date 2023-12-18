package day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyGame {
    public int findScore(String input) {
        GameParser gameParser = new GameParser();
        String[] split = input.split("\\n");
        int score = 0;
        Map<Integer, Game> gameVsCopy = new HashMap<>();
        for (String s : split) {
            Game game = gameParser.parse(s);
            gameVsCopy.put(game.getGameNumber(), game);
        }
        for (Game game : gameVsCopy.values()) {
            int winnings = 0;
            List<Integer> winningCard = game.getWinningCard();
            List<Integer> myCard = game.getMyCard();
            System.out.println("My cards " + myCard);
            for (Integer i : myCard) {
                if (winningCard.contains(i)) {
                    winnings++;
                }
            }
            System.out.println("Found winnings " + winnings);
            for (int i = 0; i < winnings; i++) {
                for (int j = 1; j <= game.getCopies(); j++) {
                    Game game1 = gameVsCopy.get(game.getGameNumber() + i + 1);
                    if (game1 != null)
                        game1.addCopy();
                }
            }

        }
        return gameVsCopy.values().stream().map(Game::getCopies).mapToInt(Integer::intValue).sum();

    }
}
