import java.util.List;
import java.util.Random;

public class CheatStrategy implements Strategy {
    private final List<Integer> playerHistory;
    private final Random rand = new Random();

    public CheatStrategy(List<Integer> playerHistory) {
        this.playerHistory = playerHistory;
    }

    @Override
    public int determineMove() {
        if (playerHistory.isEmpty()) return rand.nextInt(3);

        // 10% chance to cheat
        if (rand.nextDouble() < 0.10) {
            int lastMove = playerHistory.get(playerHistory.size() - 1);
            return (lastMove + 1) % 3; // cheat to beat last move
        } else {
            return rand.nextInt(3); // normal random move
        }
    }

    @Override
    public String getName() {
        return "Cheat";
    }
}
