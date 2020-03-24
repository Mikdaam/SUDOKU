import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gille extends JPanel {
    private JPanel sousPanneau;
    private GridLayout grille;
    private JLabel text;
    private int nb;
    //private int nbrCase;
    public Gille() {
       //nbrCase = 9;
        grille = new GridLayout(3, 3);
        grille.setHgap(2);
        grille.setVgap(2);
        this.setBackground(Color.BLACK);
        this.setLayout(grille);
        // Générateur de nombre aléatoire..........
        for (int j = 0; j < 9; j++) {
            sousPanneau = new JPanel();
            text = new JLabel();
            sousPanneau.setBackground(Color.WHITE);
            sousPanneau.add(text);
            this.add(sousPanneau);
        }

    }
}
