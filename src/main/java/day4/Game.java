package day4;

import java.util.List;

public class Game {
    private final List<Integer> winningCard;
    private final List<Integer> myCard;
    private final int gameNumber;

    private int copies = 1;

    public Game(int gameNumber,
                List<Integer> winningCard, List<Integer> myCard) {
        this.gameNumber = gameNumber;
        this.winningCard = winningCard;
        this.myCard = myCard;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public List<Integer> getWinningCard() {
        return winningCard;
    }

    public List<Integer> getMyCard() {
        return myCard;
    }

    public void addCopy() {
        copies++;
    }

    public int getCopies() {
        return copies;
    }
}
