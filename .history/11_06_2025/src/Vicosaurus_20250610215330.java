import  javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
public class Vicosaurus extends JPanel implements ActionListener {
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
    
    Block dinosaur;
    public Vicosaurus() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.lightGray);
        
        dinosaurImg = (new ImageIcon(getClass().getResource("img/dino-run.gif"))).getImage();
        dinosaurDeadImg = (new ImageIcon(getClass().getResource("img/dino-dead.png"))).getImage();
        dinosaurJumpImg = (new ImageIcon(getClass().getResource("img/dino-jump.png"))).getImage();
        cactus1Img = (new ImageIcon(getClass().getResource("img/cactus1.png"))).getImage();
        cactus2Img = (new ImageIcon(getClass().getResource("img/cactus2.png"))).getImage();
        cactus3Img = (new ImageIcon(getClass().getResource("img/cactus3.png"))).getImage();

        //dino is here
        dinosaur = new Block(dinoX, dinoY, dinoWidth, dinoHeight, dinosaurImg);

        // game loop initialization with 60 fps

        gameLoop = new Timer(1000 / 60, this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, this);
        // Draw the ground
        //g.setColor(Color.darkGray);
        //g.fillRect(0, height - 50, width, 50);
    }
}
