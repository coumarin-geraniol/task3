public class HelpTableGenerator {
    private final GameOptions gameOptions;

    public HelpTableGenerator(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public void printHelpTable() {
        String[] moves = gameOptions.getMoves();
        int movesCount = moves.length;

        System.out.println("+-----------+" + "-".repeat(6*movesCount));
        System.out.print("| v PC\\User > | ");
        for (String move : moves) {
            System.out.printf("%-5s | ", move);
        }
        System.out.println("\n+-----------+" + "-".repeat(6*movesCount));
        for (int i = 0; i < movesCount; i++) {
            System.out.printf("| %-9s | ", moves[i]);
            for (int j = 0; j < movesCount; j++) {
                if (i == j) {
                    System.out.printf("%-5s | ", "Draw");
                } else if (gameOptions.checkIfFirstBeatsSecond(i, j)) {
                    System.out.printf("%-5s | ", "Win");
                } else {
                    System.out.printf("%-5s | ", "Lose");
                }
            }
            System.out.println("\n+-----------+" + "-".repeat(6*movesCount));
        }
    }

}
