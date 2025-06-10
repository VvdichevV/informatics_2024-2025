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
    public Vicosaurus() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.lightGray);
        
        dinosaurImg = (new ImageIcon(getClass().getResource("img/dino-run.png"))).getImage();
        

    }
}
