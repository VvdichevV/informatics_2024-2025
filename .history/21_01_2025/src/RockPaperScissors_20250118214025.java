import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RockPaperScissors {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setSize(1200, 800);
        frame.setLayout(new GridLayout(4, 3));

        JPanel title = new JPanel(new FlowLayout());
        JLabel titleLabel = new JLabel("Rock, Paper, Scissors");
        titleLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
        title.add(titleLabel);

        JPanel startGame = new JPanel(new FlowLayout());
        JButton startGameButton = new JButton("Start Game");
        buttonStyle(startGameButton);
        startGame.add(startGameButton);

        JPanel exitGame = new JPanel(new FlowLayout());
        JButton exitGameButton = new JButton("Exit Game");
        buttonStyle(exitGameButton);
        exitGame.add(exitGameButton);


        JPanel name = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Made by Victor Dichev ;)");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
        name.add(nameLabel);

        // Footer with the best programmer(me)'s name


        // Adding panels to the frame
        frame.add(title);
        frame.add(startGame);
        frame.add(exitGame);
        frame.add(name);
        frame.setVisible(true);

        // Action liste
        // Action listener for "Update Product" button

// Applies consistent styling to buttons
    }
    public static void buttonStyle (JButton button){
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setForeground(Color.BLUE);
    }
}