import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class VicRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Vicosaurus Scamperin'");
        frame.setSize(1200, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon gifIcon = new ImageIcon(VicRunner.class.getResource("img/title.gif"));
        JLabel titleLabel = new JLabel(gifIcon);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 1200, 600);

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
        startGameButton.addActionListener(e -> mainGame(frame, nameLabel));
    }

    
    public static void mainGame(JFrame frame, JLabel nameLabel) {
        frame.getContentPane().removeAll();
        frame.repaint();
        Vicosaurus vicosaurus = new Vicosaurus();
        frame.add(vicosaurus);
        frame.pack();
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(173, 216, 230)); 
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
            }
        });
    }
}
