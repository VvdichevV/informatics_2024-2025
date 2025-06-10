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
    }

    public void placeCactus() {
        double cactusChance = Math.random();
        int cactusType;
        if(cactusChance > 0.90) {
             cactusType = 2;
        } else if (cactusChance > 0.7) {
            addCactus(1);
        } else {
            addCactus(2); // cactus3
        }
        int cactusWidth = cactusType == 0 ? cactus1Width : (cactusType == 1 ? cactus2Width : cactus3Width);
        Image cactusImg = cactusType == 0 ? cactus1Img : (cactusType == 1 ? cactus2Img : cactus3Img);
        Block newCactus = new Block(cactusX, cactusY, cactusWidth, cactusHeight, cactusImg);
        cactiArray.add(newCactus);
    } 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, this);
        // g.setColor(Color.darkGray);
        // g.fillRect(0, height - 50, width, 50);
    }

    public void move() {
        velocityY += gravity; // Apply gravity to the dinosaur
        dinosaur.y += velocityY;

        if (dinosaur.y > dinoY) {
            dinosaur.y = dinoY; // no falling below the ground
            velocityY = 0; // reset velocity when on the ground
            dinosaur.img = dinosaurImg;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
