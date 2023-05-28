import java.security.SecureRandom;

public class ComputerMoveGenerator {
    private final SecureRandom random;
    private final int numOptions;

    public ComputerMoveGenerator(GameOptions options) {
        this.random = new SecureRandom();
        this.numOptions = options.getSize();
    }

    public int generateMove() {
        return random.nextInt(numOptions);
    }
}
