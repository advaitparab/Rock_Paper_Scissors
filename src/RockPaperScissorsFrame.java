import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

    // Game stats
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    // UI components
    private final JTextArea resultsArea = new JTextArea(10, 30);
    private final JTextField playerWinsField = new JTextField("0", 5);
    private final JTextField computerWinsField = new JTextField("0", 5);
    private final JTextField tiesField = new JTextField("0", 5);

    private final Random rand = new Random();

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // ---------- TOP: Image Buttons Panel ----------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose your move"));

        // Scaled image buttons
        JButton rockButton = createImageButton("rock.png", 150, 150);
        JButton paperButton = createImageButton("paper.png", 150, 150);
        JButton scissorsButton = createImageButton("scissors.png", 150, 150);
        JButton quitButton = new JButton("Quit");

        // Button actions
        rockButton.addActionListener(e -> playGame(0));
        paperButton.addActionListener(e -> playGame(1));
        scissorsButton.addActionListener(e -> playGame(2));
        quitButton.addActionListener(e -> System.exit(0));

        // Add buttons to panel
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.NORTH);

        // ---------- CENTER: Stats Panel ----------
        JPanel statsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Stats"));

        statsPanel.add(new JLabel("Player Wins:"));
        statsPanel.add(playerWinsField);
        statsPanel.add(new JLabel("Computer Wins:"));
        statsPanel.add(computerWinsField);
        statsPanel.add(new JLabel("Ties:"));
        statsPanel.add(tiesField);

        // Make stats read-only
        playerWinsField.setEditable(false);
        computerWinsField.setEditable(false);
        tiesField.setEditable(false);

        add(statsPanel, BorderLayout.CENTER);

        // ---------- BOTTOM: Results Area ----------
        resultsArea.setEditable(false);
        resultsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Game Results"));

        add(scrollPane, BorderLayout.SOUTH);
    }

    // --- Play Game Logic ---
    private void playGame(int playerMove) {
        int computerMove = rand.nextInt(3);
        String[] moves = {"Rock", "Paper", "Scissors"};

        String playerMoveStr = moves[playerMove];
        String computerMoveStr = moves[computerMove];
        String outcome;

        if (playerMove == computerMove) {
            ties++;
            outcome = playerMoveStr + " vs. " + computerMoveStr + " — Tie!";
        } else if ((playerMove == 0 && computerMove == 2) ||
                (playerMove == 1 && computerMove == 0) ||
                (playerMove == 2 && computerMove == 1)) {
            playerWins++;
            outcome = playerMoveStr + " beats " + computerMoveStr + " — Player wins!";
        } else {
            computerWins++;
            outcome = computerMoveStr + " beats " + playerMoveStr + " — Computer wins!";
        }

        // Update UI
        resultsArea.append(outcome + "\n");
        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }

    // --- Utility Method to Load and Scale Images ---
    private JButton createImageButton(String filename, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/" + filename));
            Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new JButton(new ImageIcon(scaled));
        } catch (Exception e) {
            System.out.println("❌ Failed to load image: " + filename);
            return new JButton("Image not found");
        }
    }
}
