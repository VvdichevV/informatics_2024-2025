import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventHandler {


    public static void main(String[] args) {


        JFrame frame = new JFrame("clicker game");
        JLabel showCLicks = new JLabel("0");
        JButton increaseButton = new JButton("increase me!");
        JButton resetButton = new JButton("reset");
        JButton decreaseButton = new JButton("decrease me!");
        JLabel emptyLabel1 = new JLabel("");
        JLabel emptyLabel2 = new JLabel("");


        frame.setLayout(new GridLayout(2,3));
        frame.setSize(300,300);
        frame.add(showCLicks);
        frame.add(emptyLabel1);
        frame.add(emptyLabel2);
        frame.add(increaseButton);
        frame.add(resetButton);
        frame.add(decreaseButton);


        frame.setVisible(true);


        increaseButton.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent e){
                int counter = Integer.parseInt(showCLicks.getText());
                counter++;
                showCLicks.setText(String.valueOf(counter));
            }
        });
        decreaseButton.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent e){
                int counter = Integer.parseInt(showCLicks.getText());
                counter = (counter > 0) ? counter - 1 : 0;
                showCLicks.setText(String.valueOf(counter));
            }
        });
        resetButton.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent e){
                showCLicks.setText("0");
            }
        });


/* TASK: Improve this game by adding another button to reset and to decrement the counter.
Your GUI should look like this:


------------
0
|+| |-| |reset|
------------


*/
    }
}

