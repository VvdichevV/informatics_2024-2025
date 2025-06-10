import  javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
public class Vicosaurus extends JPanel {
    int width = 750;
    int height = 250;
    public Vicosaurus() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        JLabel nameLabel = new JLabel("Vicosaurus");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(0, 0, width, height);
        add(nameLabel);
    }
}
