import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Victorium {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Victorium");
        frame.setSize(1200, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon gifIcon = new ImageIcon(Victorium.class.getResource("title.gif"));
        JLabel titleLabel = new JLabel(gifIcon);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 50, 600, 300);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setBounds(450, 400, 300, 60);
        buttonStyle(startGameButton);

        JButton exitGameButton = new JButton("Exit Game");
        exitGameButton.setBounds(450, 500, 300, 60);
        buttonStyle(exitGameButton);

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

        // Capture the original bounds (make sure the bounds are already set with
        // setBounds)
        final Rectangle originalBounds = new Rectangle(button.getBounds());

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            private Timer growTimer;
            private Timer shrinkTimer;
            // Increase steps and delay for more visible animation
            private final int ANIMATION_STEPS = 10;
            private final int ANIMATION_DELAY = 40;
            private int step = 0;

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(173, 216, 230)); // Light blue glow

                // Update original bounds if needed
                if (originalBounds.width == 0) {
                    originalBounds.setBounds(button.getBounds());
                }
                if (shrinkTimer != null && shrinkTimer.isRunning()) {
                    shrinkTimer.stop();
                }
                step = 0;
                growTimer = new Timer(ANIMATION_DELAY, e -> {
                    if (step < ANIMATION_STEPS) {
                        step++;
                        int growAmount = step * 2; // adjust multiplier for stronger effect if desired
                        button.setBounds(
                                originalBounds.x - growAmount,
                                originalBounds.y - growAmount,
                                originalBounds.width + (growAmount * 2),
                                originalBounds.height + (growAmount * 2));
                        // Force a repaint to see the change
                        button.repaint();
                    } else {
                        ((Timer) e.getSource()).stop();
                    }
                });
                growTimer.start();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);

                if (growTimer != null && growTimer.isRunning()) {
                    growTimer.stop();
                }
                step = 0;
                shrinkTimer = new Timer(ANIMATION_DELAY, e -> {
                    if (step < ANIMATION_STEPS) {
                        step++;
                        int shrinkAmount = (ANIMATION_STEPS - step) * 2;
                        button.setBounds(
                                originalBounds.x - shrinkAmount,
                                originalBounds.y - shrinkAmount,
                                originalBounds.width + (shrinkAmount * 2),
                                originalBounds.height + (shrinkAmount * 2));
                        button.repaint();
                    } else {
                        button.setBounds(originalBounds);
                        button.repaint();
                        ((Timer) e.getSource()).stop();
                    }
                });
                shrinkTimer.start();
            }
        });
    }
}
