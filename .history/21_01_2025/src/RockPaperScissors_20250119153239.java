import java.awt.*;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RockPaperScissors {

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
        startGameButton.addActionListener(e -> mainGame(frame));

    }

    public static void mainGame(JFrame frame) {
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

        rockButton.setBounds(100, 300, 300, 300);
        paperButton.setBounds(450, 150, 300, 300);
        scissorsButton.setBounds(800, 150, scaledWidth, scaledHeight);

        JLabel pickLabel = new JLabel("Pick your choice:");
        pickLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
        pickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pickLabel.setBounds(300, 50, 600, 100);

        JLabel nameLabel = new JLabel("Made by Victor Dichev ;)");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(450, 800, 300, 40);

        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
        frame.add(nameLabel);
        frame.add(pickLabel);
        frame.revalidate();
        frame.repaint();
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
