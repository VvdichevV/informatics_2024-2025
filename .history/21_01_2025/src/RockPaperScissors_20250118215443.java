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

        // Replace the text label with a GIF
        ImageIcon gifIcon = new ImageIcon("path/to/your/gif/file.gif");
        JLabel titleLabel = new JLabel(gifIcon);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Adjust bounds based on your GIF size
        titleLabel.setBounds(350, 200, 500, 200); // Adjust height as needed

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
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setForeground(Color.BLUE);
        button.setFocusPainted(false);
    }
}
