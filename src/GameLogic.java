public class GameLogic {
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;

    public static String getMoveName(int move) {
        return switch (move) {
            case ROCK -> "Rock";
            case PAPER -> "Paper";
            case SCISSORS -> "Scissors";
            default -> "Unknown";
        };
    }

    public static String determineWinner(int player, int computer) {
        if (player == computer) return "Tie";
        if ((player == ROCK && computer == SCISSORS) ||
                (player == PAPER && computer == ROCK) ||
                (player == SCISSORS && computer == PAPER)) {
            return "Player";
        } else {
            return "Computer";
        }
    }
}
