import java.util.Random;

public class RandomStrategy implements Strategy {
    private final Random rand = new Random();

    @Override
    public int determineMove() {
        return rand.nextInt(3); // 0 = Rock, 1 = Paper, 2 = Scissors
    }

    @Override
    public String getName() {
        return "Random";
    }
}
