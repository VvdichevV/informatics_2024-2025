import  javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
public class Vicosaurus extends JPanel {
    int width = 750;
    int height = 250;

    Image dinosaur;
    Image dinosaurDeadImg;
    Image dinosaurJumpImg;
    Image cactus1Img;
    Image cactus2Img;
    Image cactus3Img;
    public Vicosaurus() {

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.lightGray);
        
        dinosaur = (new ImageIcon("11_06_2025/src/dinosaur.png")).getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    }
}
