import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Fenetre extends JFrame {
    private JMenuBar menu;
    private JMenu fichier;
    private JMenuItem nouvelGrille;
    private JMenuItem nouvelGrilleAlea;
    private JMenuItem enregistrer;
    private JMenuItem resoudre;
    private JMenuItem ouvrir;
    private JMenuItem quitter;
    private GridLayout grille;
    private JPanel panGen;
    private Grille pan;
    public Fenetre() {
        // appel le constructeur par défaut
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // On ajoute la barre des menus
        menu = new JMenuBar();
        fichier = new JMenu("Fichier");
        nouvelGrille = new JMenuItem("Nouvelle grille");
        nouvelGrilleAlea = new JMenuItem("Nouvelle grille aléatoire");
        ouvrir = new JMenuItem("Ouvrir");
        enregistrer = new JMenuItem("Enregistrer");
        resoudre = new JMenuItem("Resoudre");
        quitter = new JMenuItem("Quitter le jeu!");
        // On définit les raccourcis clavier par défaut
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        nouvelGrille.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        resoudre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        // On ajoute les éléments au menu
        fichier.add(nouvelGrille);
        fichier.add(nouvelGrilleAlea);
        fichier.addSeparator();
        fichier.add(ouvrir);
        fichier.add(enregistrer);
        fichier.addSeparator();
        fichier.add(resoudre);
        fichier.add(quitter);
        menu.add(fichier);
        setJMenuBar(menu);
        //On créé un gestionnaire de fenetre
        grille = new GridLayout(3, 3);
        grille.setVgap(3);
        grille.setHgap(3);
        //On créé un panneau de fond noir
        panGen = new JPanel();
        panGen.setBackground(Color.BLACK);
        panGen.setLayout(grille);
        for (int i = 0; i < 9; i++) {
            pan = new Grille();
            panGen.add(pan);
        }
        this.add(panGen);
    }
}
