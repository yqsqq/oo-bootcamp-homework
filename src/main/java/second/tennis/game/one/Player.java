package second.tennis.game.one;

public class Player {
    private static final int INITIAL_SCORE = 0;

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = INITIAL_SCORE;
    }

    public boolean isTheSameScoreAs(Player player) {
        return this.score == player.score;
    }

    public void winScore(String name) {
        if (name.equals(this.name)) {
            ++this.score;
        }
    }

    public int getScore() {
        return score;
    }

    public boolean isScoreGreatThanFour() {
        return score >= 4;
    }

    public int differencialScoreTo(Player player) {
        return score - player.score;
    }
}
