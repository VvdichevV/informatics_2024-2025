import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
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
        startGameButton.addActionListener(e -> mainGame(frame, nameLabel));
    }

    // Game variables
    static int score = 0;
    static int playerY = 600;
    static boolean isJumping = false;
    static int jumpHeight = 0;
    static final int MAX_JUMP_HEIGHT = 150;
    static ArrayList<Rectangle> obstacles = new ArrayList<>();
    static Random random = new Random();
    static boolean gameOver = false;
    
    public static void mainGame(JFrame frame, JLabel nameLabel) {
        // Clear the frame
        frame.getContentPane().removeAll();
        
        // Reset game state
        score = 0;
        playerY = 600;
        isJumping = false;
        jumpHeight = 0;
        obstacles.clear();
        gameOver = false;
        
        // Create game panel
        JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw ground
                g.setColor(Color.WHITE);
                g.fillRect(0, 700, getWidth(), 5);
                
                // Draw player
                g.setColor(Color.CYAN);
                g.fillRect(100, playerY, 50, 100);
                
                // Draw obstacles
                g.setColor(Color.RED);
                for (Rectangle obstacle : obstacles) {
                    g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
                }
                
                // Draw score
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Score: " + score, 50, 50);
                
                // Draw game over message
                if (gameOver) {
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial", Font.BOLD, 70));
                    g.drawString("GAME OVER", 400, 400);
                    g.setFont(new Font("Arial", Font.BOLD, 30));
                    g.drawString("Press SPACE to restart", 450, 450);
                }
            }
        };
        
        gamePanel.setLayout(null);
        gamePanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        
        frame.add(gamePanel);
        frame.revalidate();
        frame.repaint();
        
        // Add key listener for jumping
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (gameOver) {
                        // Restart game
                        mainGame(frame, nameLabel);
                        return;
                    }
                    
                    if (!isJumping) {
                        isJumping = true;
                    }
                }
            }
        });
        frame.setFocusable(true);
        frame.requestFocus();
        
        // Game loop
        Timer gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameOver) {
                    return;
                }
                
                // Update score
                score++;
                
                // Handle jumping
                if (isJumping) {
                    if (jumpHeight < MAX_JUMP_HEIGHT) {
                        playerY -= 10;
                        jumpHeight += 10;
                    } else {
                        isJumping = false;
                    }
                } else if (playerY < 600) {
                    playerY += 10;
                    jumpHeight -= 10;
                }
                
                // Generate obstacles
                if (random.nextInt(50) == 0) {
                    int height = 50 + random.nextInt(50);
                    obstacles.add(new Rectangle(frame.getWidth(), 700 - height, 30, height));
                }
                
                // Move obstacles
                for (int i = 0; i < obstacles.size(); i++) {
                    Rectangle obstacle = obstacles.get(i);
                    obstacle.x -= 10;
                    
                    // Remove obstacles that are off-screen
                    if (obstacle.x + obstacle.width < 0) {
                        obstacles.remove(i);
                        i--;
                    }
                    
                    // Check for collision
                    if (obstacle.intersects(new Rectangle(100, playerY, 50, 100))) {
                        gameOver = true;
                    }
                }
                
                gamePanel.repaint();
            }
        }, 0, 50);
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
