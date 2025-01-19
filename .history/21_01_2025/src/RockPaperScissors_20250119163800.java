import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Random;

public class RockPaperScissors {
    private static int playerScore = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setSize(1200, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon gifIcon = new ImageIcon("21_01_2025\\src\\title.gif");
        JLabel titleLabel = new JLabel(gifIcon);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 100, 600, 300);

        JButton startGameButton = new JButton("Start Game");
        buttonStyle(startGameButton);
        startGameButton.setBounds(450, 400, 300, 60);

        JButton exitGameButton = new JButton("Exit Game");
        buttonStyle(exitGameButton);
        exitGameButton.setBounds(450, 500, 300, 60);

        JLabel nameLabel = new JLabel("Made by Victor Dichev ;)");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(450, 800, 300, 40);

        frame.add(titleLabel);
        frame.add(startGameButton);
        frame.add(exitGameButton);
        frame.add(nameLabel);
        frame.getContentPane().setBackground(Color.decode("#ADEEE3"));
        frame.setVisible(true);

        exitGameButton.addActionListener(e -> System.exit(0));
        startGameButton.addActionListener(e -> mainGame(frame, nameLabel));

    }

    public static void mainGame(JFrame frame, JLabel nameLabel) {
        frame.getContentPane().removeAll();
        frame.repaint();

        ImageIcon scissorsOriginalIcon = new ImageIcon("21_01_2025\\src\\scissors.png");
        int originalWidth = scissorsOriginalIcon.getIconWidth();
        int originalHeight = scissorsOriginalIcon.getIconHeight();

        double scaleFactor = Math.min(300.0 / originalWidth, 300.0 / originalHeight);

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        Image scissors = scissorsOriginalIcon.getImage()
                .getScaledInstance(scaledWidth, scaledHeight,
                        Image.SCALE_SMOOTH);
        ImageIcon scissorsIcon = new ImageIcon(scissors);

        Image rock = (new ImageIcon("21_01_2025\\src\\rock.png"))
                .getImage()
                .getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon rockIcon = new ImageIcon(rock);

        Image paper = (new ImageIcon("21_01_2025\\src\\paper.png"))
                .getImage()
                .getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon paperIcon = new ImageIcon(paper);

        JButton rockButton = new JButton(rockIcon);
        JButton paperButton = new JButton(paperIcon);
        JButton scissorsButton = new JButton(scissorsIcon);

        choicesButtonStyle(rockButton);
        choicesButtonStyle(paperButton);
        choicesButtonStyle(scissorsButton);

        rockButton.setBounds(100, 250, 300, 300);
        paperButton.setBounds(450, 250, 300, 300);
        scissorsButton.setBounds(800, 250, scaledWidth, scaledHeight);

        JLabel pickLabel = new JLabel("Pick your choice:");
        pickLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
        pickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pickLabel.setBounds(300, 50, 600, 100);

        JLabel scoreLabel = new JLabel("Score: " + playerScore);
        scoreLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 32));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setBounds(1000, 800, 300, 50);

        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
        frame.add(nameLabel);
        frame.add(pickLabel);
        frame.add(nameLabel);
        frame.revalidate();
        frame.repaint();

        rockButton.addActionListener(e -> gameLoop(rockButton, paperButton, scissorsButton, frame, nameLabel));
        paperButton.addActionListener(e -> gameLoop(paperButton, scissorsButton, rockButton, frame, nameLabel));
        scissorsButton.addActionListener(e -> gameLoop(scissorsButton, rockButton, paperButton, frame, nameLabel));
    }

    public static void gameLoop(JButton playerChoice, JButton loseChoice, JButton winChoice, JFrame frame,
            JLabel nameLabel) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel pickLabel = new JLabel("Your pick:");
        pickLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 32));
        pickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pickLabel.setBounds(100, 150, 300, 50);

        JLabel computerPickLabel = new JLabel("Computer is thinking");
        computerPickLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 32));
        computerPickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerPickLabel.setBounds(750, 150, 350, 50);

        ImageIcon gifIcon = new ImageIcon("21_01_2025\\src\\vs.gif");
        JLabel vsLabel = new JLabel(gifIcon);
        vsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        vsLabel.setBounds(300, 250, 600, 300);

        JLabel resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 32));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBounds(420, 650, 350, 50);

        playerChoice.setBounds(100, 250, 300, 300);

        frame.add(pickLabel);
        frame.add(playerChoice);
        frame.add(computerPickLabel);
        frame.add(vsLabel);
        frame.add(nameLabel);
        frame.add(resultLabel);
        frame.revalidate();
        frame.repaint();

        Timer timer = new Timer(2500, e -> {
            int result = showComputerChoice();
            ImageIcon computerChoiceIcon = null;
            String resultText = "";
            switch (result) {
                case 0:
                    computerChoiceIcon = (ImageIcon) ((JButton) playerChoice).getIcon();
                    resultText = "Draw";
                    player
                    break;
                case 1:
                    computerChoiceIcon = (ImageIcon) ((JButton) loseChoice).getIcon();
                    resultText = "You lose";
                    break;
                case 2:
                    computerChoiceIcon = (ImageIcon) ((JButton) winChoice).getIcon();
                    resultText = "You win";
                    break;
            }

            JLabel computerPick = new JLabel(computerChoiceIcon);
            computerPick.setBounds(800, 250, 300, 300);
            frame.add(computerPick);

            computerPickLabel.setText("Computer pick:");
            computerPickLabel.setBounds(770, 150, 350, 50);
            resultLabel.setText(resultText);

            ((Timer) e.getSource()).stop();
        });

        timer.setRepeats(false);
        timer.start();
        frame.revalidate();
        frame.repaint();
        frame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getContentPane().removeAll();
                frame.repaint();
                mainGame(frame, nameLabel); 
            }
        });
    }

    public static int showComputerChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }

    public static void choicesButtonStyle(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setBackground(Color.decode("#86DEB7"));
        button.setForeground(Color.decode("#50723C"));
        button.setFocusPainted(false);
    }
}
