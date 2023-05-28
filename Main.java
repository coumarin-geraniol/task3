import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int game = 0;

        if (args.length < 3) {
            System.out.println("Provide at least 3 options.");
            return;
        }

        if (args.length % 2 == 0) {
            System.out.println("Provide an odd number of options.");
            return;
        }

        GameOptions gameOptions = new GameOptions(args);
        if (!gameOptions.areUnique()) {
            System.out.println("All options should be unique.");
            return;
        }

        ComputerMoveGenerator moveGenerator = new ComputerMoveGenerator(gameOptions);
        GameResultCalculator resultCalculator = new GameResultCalculator(gameOptions);
        HelpTableGenerator helpTableGenerator = new HelpTableGenerator(gameOptions);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Game: " + game);

            HMACGenerator hmacGenerator = new HMACGenerator();
            int computerMove = moveGenerator.generateMove();
            String hmac = hmacGenerator.generateHmac(gameOptions.getOption(computerMove));

            System.out.println("HMAC: " + hmac);
            gameOptions.printOptions();

            System.out.print("Enter your move: ");
            String userInput = scanner.nextLine();

            if (userInput.equals("?")) {
                helpTableGenerator.printHelpTable();
                continue;
            }

            int userMove;
            try {
                userMove = Integer.parseInt(userInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (userMove == -1) {
                System.out.println("Exit game.");
                return;
            }

            if (userMove < 0 || userMove >= gameOptions.getSize()) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            System.out.println("Your move: " + gameOptions.getOption(userMove));
            System.out.println("Computer move: " + gameOptions.getOption(computerMove));
            System.out.println(resultCalculator.calculateResult(userMove, computerMove));
            System.out.println("HMAC key: " + hmacGenerator.getSecretKey());
            System.out.println();

            game ++;
        }

    }
}
