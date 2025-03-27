import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieCollector extends JFrame {
    private JButton addMovieButton;
    private JLabel titleLabel;
    private JPanel MainPanel;
    private JTextField addMovieTextField;
    private JComboBox genreComboBox;
    private JLabel authorLabel;
    private JTable movieTable;
    private JLabel movieCountLabel;

    Movie[] movies = new Movie[30];
    int count = 0;

    public MovieCollector() {
        setContentPane(MainPanel);
        setTitle("Movie Collector Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        addMovieButton.setFont(new Font("Arial", Font.BOLD, 28));
        addMovieTextField.setFont(new Font("Arial", Font.BOLD, 28));
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 28));
        authorLabel.setFont(new Font("Arial", Font.BOLD, 28));
        movieCountLabel.setFont(new Font("Arial", Font.BOLD, 28));

        authorLabel.setForeground(Color.BLUE);


        setLocationRelativeTo(null);
        setVisible(true);
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movies[count++] = new Movie(addMovieTextField.getText(), (String) genreComboBox.getSelectedItem());
                movieCountLabel.setText("Movie Count: " + count);
            }
        });
    }

    public static void main(String[] args) {
        new MovieCollector();
    }
}

class Movie{
    private String title;
    private String genre;
    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}