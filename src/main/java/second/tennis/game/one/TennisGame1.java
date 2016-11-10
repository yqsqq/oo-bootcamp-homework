package second.tennis.game.one;

import second.TennisGame;
import second.tennis.game.one.transform.EqualScoreTransformer;
import second.tennis.game.one.transform.Transformer;

public class TennisGame1 implements TennisGame {

    private static final String FIRST_PLAYER = "player1";
    private static final String SECOND_PLAYER = "player2";

    private final Player firstPlayer;
    private final Player secondPlayer;

    private Transformer transformer;


    public TennisGame1() {
        firstPlayer = new Player(FIRST_PLAYER);
        secondPlayer = new Player(SECOND_PLAYER);
    }

    public void wonPoint(String playerName) {
        firstPlayer.winScore(playerName);
        secondPlayer.winScore(playerName);
    }

    public String getScore() {
        String score;
        if (firstPlayer.isTheSameScoreAs(secondPlayer)) {
            transformer = new EqualScoreTransformer();
            score = transformer.transform(firstPlayer.getScore());
        } else if (firstPlayer.isScoreGreatThanFour() || secondPlayer.isScoreGreatThanFour()) {
            score = getWinnerScoreString();
        } else {
            score = getOtherScoreString();
        }
        return score;
    }

    private String getOtherScoreString() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayer.getScore();
            else {
                score += "-";
                tempScore = secondPlayer.getScore();
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private String getWinnerScoreString() {
        String score;
        int minusResult = firstPlayer.differencialScoreTo(secondPlayer);
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

}
