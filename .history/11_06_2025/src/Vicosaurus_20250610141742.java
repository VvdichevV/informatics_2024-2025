import  javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
public class Vicosaurus extends JPanel {
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
    // the dino is here
   

    int dinoWidth = 88;
    int dinoHeight = 94;
    int dinoX = 50;
    int dinoY = height - dinoHeight;
     
    
    Block dinosaur;
    public Vicosaurus() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.lightGray);
        
        dinosaurImg = (new ImageIcon(getClass().getResource("img/dino-run.png"))).getImage();
        dinosaurDeadImg = (new ImageIcon(getClass().getResource("img/dino-dead.png"))).getImage();
        dinosaurJumpImg = (new ImageIcon(getClass().getResource("img/dino-jump.png"))).getImage();
        cactus1Img = (new ImageIcon(getClass().getResource("img/cactus1.png"))).getImage();
        cactus2Img = (new ImageIcon(getClass().getResource("img/cactus2.png"))).getImage();
        cactus3Img = (new ImageIcon(getClass().getResource("img/cactus3.png"))).getImage();

        dinosaur = new Block(dinoX, dinoY, dinoWidth, dinoHeight, dinosaurImg);
    }
    public void paint(Graphics g){
        
    }
}
