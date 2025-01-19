import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Full boxes shouldn't be filled
// Map existing input onto boxes




public class test {
    public static void main(String[] args) {
        System.out.println("The tic tac toe game");
        Player playerA = new Player();

        JFrame frame = new JFrame("TIC TAC TOE");
        frame.setSize(750, 750);
        frame.setLayout(new GridLayout (5 ,3));
        frame.setVisible(true);


        JLabel theRules = new JLabel("RESULT");
        theRules.setFont(new Font("Arial", Font.ITALIC, 32));
        theRules.setForeground(Color.GREEN);
        frame.add(theRules);


        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout (3,3));








        JLabel Box00 = new JLabel("RESULT");
        Box00.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box00);


        JLabel Box10 = new JLabel("RESULT");
        Box10.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box10);


        JLabel Box20 = new JLabel("RESULT");
        Box20.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box20);


        JLabel Box01 = new JLabel("RESULT");
        Box01.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box01);


        JLabel Box11 = new JLabel("RESULT");
        Box11.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box11);


        JLabel Box21 = new JLabel("RESULT");
        Box21.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box21);


        JLabel Box02 = new JLabel("RESULT");
        Box02.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box02);


        JLabel Box12 = new JLabel("RESULT");
        Box12.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box12);


        JLabel Box22 = new JLabel("RESULT");
        Box22.setFont(new Font("Arial", Font.ITALIC, 32));
        frame.add(Box22);




        JButton button1 = new JButton("START");
        button1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        button1.setForeground(Color.RED);
        frame.add(button1);








        JTextField input1 = new JTextField("Input 1",1);
        frame.add(input1);




        JTextField input2 = new JTextField("Input 2",1);
        frame.add(input2);




        do {
            playerA.player1Move();
            playerA.printGrid();
            playerA.player2Move();
            playerA.printGrid();
        } while (playerA.checkRows() || playerA.checkColumns() || playerA.checkDiagonals());




    }
}


class Player {


    char[][] grid = new char[3][3];


    void player1Move() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        grid[a][b] = 'X';
    }


    void player2Move() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        grid[a][b] = 'O';
    }

    void printGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]){
                return true;
            }
        }
        return false;


    }


    boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] &&  grid[i][1] == grid[i][2]){
                return true;
            }
        }
        return false;
    }
    boolean checkDiagonals() {


        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
            return true;
        }
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2]){
            return true;
        }
        else {
            return false;
        }




    }
}
