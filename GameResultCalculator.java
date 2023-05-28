public class GameResultCalculator {
    private final int numOptions;

    public GameResultCalculator(GameOptions options) {
        this.numOptions = options.getSize();
    }

    public String calculateResult(int userMove, int computerMove) {
        if (userMove == computerMove) {
            return "Draw!";
        } else if ((userMove > computerMove && userMove - computerMove <= numOptions / 2) ||
                (userMove < computerMove && computerMove - userMove > numOptions / 2)) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
