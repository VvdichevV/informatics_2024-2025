import java.awt.*;
import javax.swing.*;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Victorium {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Victorium");
        frame.setSize(1200, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon gifIcon = new ImageIcon("11_01_2025/src/title.gif");
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
        nameLabel.setForeground(Color.WHITE);

        frame.add(titleLabel);
        frame.add(startGameButton);
        frame.add(exitGameButton);
        frame.add(nameLabel);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

        exitGameButton.addActionListener(e -> System.exit(0));
        // startGameButton.addActionListener(e -> mainGame(frame, nameLabel));
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
