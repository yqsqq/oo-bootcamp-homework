package second.tennis.game.one.transform;

public class EqualScoreTransformer implements Transformer {
    @Override
    public String transform(int score) {
        String scoreString;
        switch (score) {
            case 0:
                scoreString = "Love-All";
                break;
            case 1:
                scoreString = "Fifteen-All";
                break;
            case 2:
                scoreString = "Thirty-All";
                break;
            default:
                scoreString = "Deuce";
                break;

        }
        return scoreString;
    }
}
