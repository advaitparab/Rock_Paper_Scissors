import java.util.List;

public class LeastUsedStrategy implements Strategy {
    @Override
    public int determineMove(List<Integer> playerMoves) {
        if (playerMoves.isEmpty()) return new RandomStrategy().determineMove(playerMoves);

        int[] count = new int[3];
        for (int move : playerMoves) count[move]++;
        int leastUsed = count[0] <= count[1] ? (count[0] <= count[2] ? 0 : 2) : (count[1] <= count[2] ? 1 : 2);
        return (leastUsed + 1) % 3; // Pick what beats least used
    }

    @Override
    public String getName() {
        return "Least Used";
    }
}
