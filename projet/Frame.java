/*Classe qui initialise une Fenêtre*/

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener
{
	private File fichierCourant;
	private JMenu menuFichier;
	private JMenuBar menu;
	private JMenuItem enregistrer, fermer, nouveau, nouveauAlea, ouvrir, enregistrerSous, enregistrerModele, effacer, resoudre;

	public Frame()
	{
		super("Sudoku");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* On ajoite la barre des menus */
		menu = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        ouvrir = new JMenuItem("Importer");
        fermer = new JMenuItem("Fermer");
        nouveau = new JMenuItem("Nouvelle grille");
        effacer = new JMenuItem("Effacer la grille");
        nouveau = new JMenuItem("Nouvelle grille");
        enregistrer = new JMenuItem("Enregistrer");
        enregistrerSous = new JMenuItem("Enregistrer sous...");
        resoudre = new JMenuItem("Resoudre ce Sudoku");
        //on definit les raccourcis clavier
        int shortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, shortcutKeyMask));
        fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, shortcutKeyMask));
        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, shortcutKeyMask));
        effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, shortcutKeyMask));
        enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKeyMask));
        enregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKeyMask | java.awt.event.InputEvent.SHIFT_MASK));
        resoudre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, shortcutKeyMask));
        //on ajoute les elements au menu
        menuFichier.add(nouveau);
       	menuFichier.addSeparator();
        menuFichier.add(ouvrir);
        menuFichier.add(fermer);
        menuFichier.addSeparator();
        menuFichier.add(effacer);
        menuFichier.addSeparator();
        menuFichier.add(enregistrer);
        menuFichier.add(enregistrerSous);
        menuFichier.addSeparator();
        menuFichier.add(resoudre);
        menu.add(menuFichier);
        // on ajoute des listener au menu
        ouvrir.addActionListener(this);
        setJMenuBar(menu);		
	}

	/***Ouvre un fichier enregistre sur le disque dur*/
    public void ouvrirFichier() {
        String nomFic = new String("");
        JFileChooser choix = new JFileChooser();
        choix.setDialogTitle("Choisir le fichier");
        choix.setApproveButtonText("Ok");
        //intitule du bouton
        int returnVal = choix.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fichier = choix.getSelectedFile();
        }
        fichierCourant = choix.getSelectedFile();
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == ouvrir)
            this.ouvrirFichier();
    }
}