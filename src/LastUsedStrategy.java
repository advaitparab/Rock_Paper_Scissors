import java.util.List;

public class LastUsedStrategy implements Strategy {
    private final List<Integer> playerHistory;

    public LastUsedStrategy(List<Integer> playerHistory) {
        this.playerHistory = playerHistory;
    }

    @Override
    public int determineMove() {
        if (playerHistory.isEmpty()) return 0; // default to Rock
        int lastMove = playerHistory.get(playerHistory.size() - 1);
        return (lastMove + 1) % 3; // beat the last used move
    }

    @Override
    public String getName() {
        return "Last Used";
    }
}
