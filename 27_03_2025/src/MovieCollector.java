import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MovieCollector extends JFrame {
    private JButton addMovieButton;
    private JLabel titleLabel;
    private JPanel MainPanel;
    private JTextField addMovieTextField;
    private JComboBox genreComboBox;
    private JLabel authorLabel;
    private JTable movieTable;
    private JLabel movieCountLabel;
    private JComboBox sortComboBox;

    Movie[] movies = new Movie[30];
    int count = 0;

    public MovieCollector() {
        setContentPane(MainPanel);
        setTitle("Movie Collector Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 1000);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Title", "Genre"}, 0);
        movieTable.setModel(model);
        movieTable.setFont(new Font("Arial", Font.BOLD, 20));
        movieTable.setRowHeight(50);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));
        addMovieButton.setFont(new Font("Arial", Font.BOLD, 28));
        addMovieTextField.setFont(new Font("Arial", Font.BOLD, 28));
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 28));
        authorLabel.setFont(new Font("Arial", Font.BOLD, 28));
        movieCountLabel.setFont(new Font("Arial", Font.BOLD, 28));
        sortComboBox.setFont(new Font("Arial", Font.BOLD, 28));

        authorLabel.setForeground(Color.BLUE);

        setLocationRelativeTo(null);
        setVisible(true);

        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < count; i++) {
                    if (movies[i].getTitle().equals(addMovieTextField.getText())) {
                        highlightDisplayMovies();
                        return;
                    }
                }
                movies[count++] = new Movie(addMovieTextField.getText(), (String) genreComboBox.getSelectedItem());
                movieCountLabel.setText("Movie Count: " + count);
                displayMovies();
            }
        });
        sortComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sortComboBox.getSelectedItem().equals("Sort by genre")) {
                    sortMoviesByGenre();
                } else {
                    sortMoviesByTitle();
                }
                displayMovies();
            }

        });
    }

    public void displayMovies() {
        DefaultTableModel model = (DefaultTableModel) movieTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < count; i++) {
            Movie movie = movies[i];
            model.addRow(new Object[]{movie.getTitle(), movie.getGenre()});
        }
    }

    public void highlightDisplayMovies() {
        DefaultTableModel model = (DefaultTableModel) movieTable.getModel();
        movieTable.setSelectionBackground(Color.YELLOW);
        for (int i = 0; i < count; i++) {
            if (movies[i].getTitle().equalsIgnoreCase(addMovieTextField.getText())) {
                movieTable.setRowSelectionInterval(i, i);
                break;
            }
        }
    }

    public void sortMoviesByGenre() {
        Arrays.sort(movies, 0, count, (a, b) -> a.getGenre().compareTo(b.getGenre()));
    }

    public void sortMoviesByTitle() {
        Arrays.sort(movies, 0, count, (a, b) -> a.getTitle().compareTo(b.getTitle()));
    }

    public static void main(String[] args) {
        new MovieCollector();
    }
}

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
