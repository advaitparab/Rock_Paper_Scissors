import java.util.List;

public class MostUsedStrategy implements Strategy {
    private final List<Integer> playerHistory;

    public MostUsedStrategy(List<Integer> playerHistory) {
        this.playerHistory = playerHistory;
    }

    @Override
    public int determineMove() {
        int[] counts = new int[3];
        for (int move : playerHistory) counts[move]++;
        int mostUsed = 0;
        for (int i = 1; i < 3; i++) {
            if (counts[i] > counts[mostUsed]) mostUsed = i;
        }
        return (mostUsed + 1) % 3; // beat the most used move
    }

    @Override
    public String getName() {
        return "Most Used";
    }
}
