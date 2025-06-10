import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Vicosaurus extends JPanel implements ActionListener, KeyListener {
    int width = 750;
    int height = 250;

    Image dinosaurImg;
    Image dinosaurDeadImg;
    Image dinosaurJumpImg;
    Image cactus1Img;
    Image cactus2Img;
    Image cactus3Img;

    class Block {
        int x;
        int y;
        int width;
        int height;
        Image img;

        public Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

    int dinoWidth = 88;
    int dinoHeight = 94;
    int dinoX = 50;
    int dinoY = height - dinoHeight;

    Timer gameLoop;
    Timer  cactusTimer;

    Block dinosaur;

    // cacti

    int cactus1Width = 34;
    int cactus2Width = 69;
    int cactus3Width = 102;

    int cactusHeight = 70;
    int cactusX = 700;
    int cactusY = height - cactusHeight;

    ArrayList<Block> cactiArray;

    boolean gameOver = false;
    int score = 0;


    // physics woo
    int velocityX = -12;
    int velocityY = 0;
    int gravity = 1; // Gravity effect on the dinosaur


    public Vicosaurus() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.lightGray);
        setFocusable(true);
        addKeyListener(this);

        dinosaurImg = (new ImageIcon(getClass().getResource("img/dino-run.gif"))).getImage();
        dinosaurDeadImg = (new ImageIcon(getClass().getResource("img/dino-dead.png"))).getImage();
        dinosaurJumpImg = (new ImageIcon(getClass().getResource("img/dino-jump.png"))).getImage();
        cactus1Img = (new ImageIcon(getClass().getResource("img/cactus1.png"))).getImage();
        cactus2Img = (new ImageIcon(getClass().getResource("img/cactus2.png"))).getImage();
        cactus3Img = (new ImageIcon(getClass().getResource("img/cactus3.png"))).getImage();

        // dino is here
        dinosaur = new Block(dinoX, dinoY, dinoWidth, dinoHeight, dinosaurImg);

        // cacti are here
        cactiArray = new ArrayList<Block>();

        // game loop initialization with 60 fps

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

        //place cactus timer
        cactusTimer = new Timer(1500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                placeCactus();
            }
        });
        cactusTimer.start();
    }

    public void placeCactus() {
        if(gameOver) return;
        double cactusChance = Math.random();
        if(cactusChance > 0.90) {
            Block newCactus = new Block(cactusX, cactusY, cactus3Width, cactusHeight, cactus3Img);
            cactiArray.add(newCactus);
            return;
        } else if (cactusChance > 0.7) {
            Block newCactus = new Block(cactusX, cactusY, cactus2Width, cactusHeight, cactus2Img);
            cactiArray.add(newCactus);
            return; 
            
        } else if(cactusChance > 0.5) {
            Block newCactus = new Block(cactusX, cactusY, cactus1Width, cactusHeight, cactus1Img);
            cactiArray.add(newCactus);
            return;
        }
    } 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, this);

        for(Block cactus : cactiArray) {
            g.drawImage(cactus.img, cactus.x, cactus.y, cactus.width, cactus.height, null);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        if(gameOver){
            g.drawString("Game Over! Score: " + score, 10, 35);
        } else {
            g.drawString(score, 10, 35);
        }

    }

    public void move() {
        velocityY += gravity; // Apply gravity to the dinosaur
        dinosaur.y += velocityY;

        if (dinosaur.y > dinoY) {
            dinosaur.y = dinoY; // no falling below the ground
            velocityY = 0; // reset velocity when on the ground
            dinosaur.img = dinosaurImg;
        }

        // move cacti
        for(int i = 0; i < cactiArray.size(); i++) {
            Block cactus = cactiArray.get(i);
            cactus.x += velocityX;

            // remove cactus if it goes off screen
            if(cactus.x + cactus.width < 0) {
                cactiArray.remove(i);
                i--;
            }

            if(collision(dinosaur, cactus)) {
                // collision detected
                dinosaur.img = dinosaurDeadImg;
                gameOver = true;
                JOptionPane.showMessageDialog(this, "Game Over! You collided with a cactus.");
                System.exit(0); // end the game
            }
        }
        score++;

    }

    boolean collision(Block a, Block b) {
        return a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameOver) {
            cactusTimer.stop();
            gameLoop.stop();
        }
        move();
        repaint();
        // Update game logic here
        // we can move the dinosaur or handle collisions

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            // dinosaur.img = dinosaurJumpImg;
            if (dinosaur.y == dinoY) {
                velocityY = -17;
                dinosaur.img = dinosaurJumpImg;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
