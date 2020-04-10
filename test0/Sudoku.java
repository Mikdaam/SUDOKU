import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class Sudoku extends JFrame implements ActionListener
{
	Jeu jeu;
	File fichierCourant;
	Container c;
	JPanel panel, panelGeneral, panelHaut;
	JPanel[][] jp = new JPanel[3][3];
	JButton  cases[][] = new JButton[9][9];
	GridLayout grille;
	JMenu menuFichier;
	JMenuBar menu;
	JMenuItem enregistrer, fermer, nouveau, nouveauAlea, ouvrir, enregistrerSous, enregistrerModele, effacer, resoudre;

	public Sudoku()
	{
		super("Sudoku");
		jeu = new Jeu();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650,650);

		menu = new JMenuBar();     
		menuFichier = new JMenu("Fichier"); 
		ouvrir = new JMenuItem("Ouvrir");
		fermer = new JMenuItem("Fermer");
		nouveau = new JMenuItem("Nouvelle grille");
		effacer = new JMenuItem("Effacer la grille");
		fermer = new JMenuItem("Fermer");
		nouveau = new JMenuItem("Nouvelle grille");
		nouveauAlea = new JMenuItem("Nouvelle grille aleatoire");    
		enregistrer = new JMenuItem("Enregistrer");    
		enregistrerSous = new JMenuItem("Enregistrer sous...");
		enregistrerModele = new JMenuItem("Enregistrer comme modele");
		resoudre = new JMenuItem("Resoudre ce Sudoku");

		int shortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, shortcutKeyMask));
		fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, shortcutKeyMask));
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, shortcutKeyMask));
		nouveauAlea.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, shortcutKeyMask | java.awt.event.InputEvent.SHIFT_MASK));
		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, shortcutKeyMask));
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKeyMask));
		enregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKeyMask | java.awt.event.InputEvent.SHIFT_MASK));
		enregistrerModele.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKeyMask | java.awt.event.InputEvent.ALT_MASK));
		resoudre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, shortcutKeyMask));

		menuFichier.add(nouveau);
		menuFichier.add(nouveauAlea);
		menuFichier.addSeparator();    
		menuFichier.add(ouvrir);
		menuFichier.add(fermer);
		menuFichier.addSeparator();
		menuFichier.add(effacer);
		menuFichier.addSeparator();
		menuFichier.add(enregistrer);     
		menuFichier.add(enregistrerSous);
		menuFichier.add(enregistrerModele);
		menuFichier.addSeparator();
		menuFichier.add(resoudre);
		menu.add(menuFichier);

		ouvrir.addActionListener(this);
		nouveau.addActionListener(this);
		nouveauAlea.addActionListener(this);
		fermer.addActionListener(this);
		effacer.addActionListener(this); 
		enregistrer.addActionListener(this);     
		enregistrerSous.addActionListener(this); 
		enregistrerModele.addActionListener(this);   
		resoudre.addActionListener(this);    
		setJMenuBar(menu);

		c = getContentPane();    
		panel = new JPanel();
		grille = new GridLayout(3,3);
		panel.setLayout(grille);
		panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		panelGeneral.add(panel, BorderLayout.CENTER);
		effacer.addActionListener(this);

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				jp[i][j] = new JPanel();
				(jp[i][j]).setLayout(new GridLayout(3,3));
				(jp[i][j]).setBorder(BorderFactory.createEtchedBorder());
			}
		}

		for(int i = 0; i < 9;i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int in;
				in = jeu.getCaseNum(i,j);

				if(in == 0)
				{
					cases[i][j] = new JButton("");
				}

				else
				{
					cases[i][j] = new JButton(Integer.toString(in));
				}

				if(jeu.getCaseFixe(i,j))
				{
					(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.BOLD, 25));
				}

				else
				{
					(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 25));
				}

				(cases[i][j]).setSize(10,10);
				(jp[(int)(i/3)][(int)(j/3)]).add(cases[i][j]);
				panel.add(jp[(int)(i/3)][(int)(j/3)]);

				(cases[i][j]).addActionListener(this);
			}
		}

		c.add(panelGeneral);

		this.setVisible(true);
	}

	public void boutonFix(int i,int j)
	{
		if(jeu.getCaseFixe(i,j))
		{
			(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.BOLD, 25));
		}
	}

	public void verif(int i, int j)
	{
		this.boutonFix(i,j);
		this.coloreRegion(i,j);

		if(jeu.ligneCompte(i))
		{
			coloreLigne(i);
		}

		else
		{
			decoloreLigne(i);
		}

		if(jeu.colonneCompte(j))
		{
			coloreColonne(j);
		}

		else
		{
			decoloreColonne(j);
		}

		if(jeu.gagne())
		{
			JOptionPane.showMessageDialog(this, "Vous avez gagne !", "Felicita-tions", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void coloreRegion(int i, int j)
	{
		if((jeu.getRegionDeCase(i,j)).regionCompte())
		{
			(jp[(int)(i/3)][(int)(j/3)]).setBorder(BorderFactory.createLineBorder(Color.red));
		}

		else
		{
			(jp[(int)(i/3)][(int)(j/3)]).setBorder(BorderFactory.createEtchedBorder());
		}
	}

	public void coloreLigne(int i)
	{
		for(int j = 0; j < 9; j++)
		{
			if((cases[i][j]).getForeground() == Color.green)
			{
				(cases[i][j]).setForeground(Color.red);
				this.boutonFix(i,j);
			}

			else
			{
				(cases[i][j]).setForeground(Color.blue);
				(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 25));
				this.boutonFix(i,j);
			}
		}
	}

	public void decoloreLigne(int i)
	{
		for(int j = 0; j < 9; j++)
		{
			if(((cases[i][j]).getForeground() == Color.red) || ((cases[i][j]).getForeground() == Color.green))
			{
				(cases[i][j]).setForeground(Color.green);
				this.boutonFix(i,j);
			}

			else
			{
				(cases[i][j]).setForeground(Color.black);
				(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 25));
				this.boutonFix(i,j);
			}
		}
	}

	public void coloreColonne(int j)
	{
		for(int i = 0; i < 9; i++)
		{
			if((cases[i][j]).getForeground() == Color.blue)
			{
				(cases[i][j]).setForeground(Color.red);
				this.boutonFix(i,j);
			}

			else
			{
				(cases[i][j]).setForeground(Color.green);
				(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 25));
				this.boutonFix(i,j);
			}
		}
	}

	public void decoloreColonne(int j)
	{
		for(int i = 0; i < 9; i++)
		{
			if(((cases[i][j]).getForeground() == Color.red) || ((cases[i][j]).getForeground() == Color.blue))
			{
				(cases[i][j]).setForeground(Color.blue);
				this.boutonFix(i,j);
			}

			else
			{
				(cases[i][j]).setForeground(Color.black);
				(cases[i][j]).setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 25));
				this.boutonFix(i,j);
			}
		}
	}

	public void appuieBouton(int i, int j)
	{
		if(!jeu.getCaseFixe(i,j))
		{
			if(jeu.getCaseNum(i,j) < 9)
			{
				jeu.setCaseNum(i,j,jeu.getCaseNum(i,j) + 1);
			}

			else
			{
				jeu.setCaseNum(i, j, 0);
			}

			Integer in = new Integer(jeu.getCaseNum(i,j));

			if (in == 0)
			{
				(cases[i][j]).setText("");
			}

			else
			{
				(cases[i][j]).setText(in.toString());
			}
		}
	}

	public void nouveauFichier()
	{
		Jeu tmp = new Jeu();
		jeu = tmp;
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				(cases[i][j]).setText("");
			}
		}

		fichierCourant = null;
	}

	public void nouveauFichierAlea()
	{
		jeu.remplirRandom();

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				Integer in = new Integer((jeu.getCaseNum(i,j)));

				if(in == 0)
				{
					(cases[i][j]).setText("");
				}

				else
				{
					(cases[i][j]).setText(in.toString());
				}

				this.boutonFix(i,j);
			}
		}
	}

	public void ouvrirFichier()
	{
		String nomFic = new String("");
		JFileChooser choix = new JFileChooser();
		choix.setDialogTitle("Choisir le fichier");
		choix.setApproveButtonText("Ok");

		int returnVal = choix.showOpenDialog(this);

		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			File fichier = choix.getSelectedFile();
			Jeu jeuTmp = new Jeu(fichier);
			jeu = jeuTmp;
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					Integer in = new Integer((jeu.getCaseNum(i,j)));

					if(in == 0)
					{
						(cases[i][j]).setText("");
					}

					else
					{
						(cases[i][j]).setText(in.toString());
					}

					this.boutonFix(i,j);
				}
			}

			fichierCourant = choix.getSelectedFile();
		}
	}

	public void sauverModele()
	{
		String nomFic = new String("");
		JFileChooser choix = new JFileChooser();
		int returnVal = choix.showSaveDialog(this);

		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			nomFic = choix.getSelectedFile().getAbsolutePath();

			try
			{
				FileWriter fichier = new FileWriter(nomFic);

				for(int i = 0; i < 9; i++)
				{
					for(int j = 0; j < 9; j++)
					{
						fichier.write(jeu.getCaseNum(i,j)+" ");

						if(jeu.getCaseNum(i,j) != 0)
						{
							fichier.write("1"+" ");
							jeu.setCaseFixe(i,j,true);
						}

						else
						{
							fichier.write("0"+" ");
							jeu.setCaseFixe(i,j,false);
						}

						this.boutonFix(i,j);
					}

					fichier.write("\n");
				}

				fichier.close();
				fichierCourant = choix.getSelectedFile();
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this, "Impossible d'enregistrer le fichier !", "Dommage", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void sauverFichier()
	{
		String nomFic = new String("");

		try
		{
			nomFic = fichierCourant.getAbsolutePath();

			try
			{
				FileWriter fichier = new FileWriter(nomFic);

				for(int i = 0; i < 9; i++)
				{
					for(int j = 0; j < 9; j++)
					{
						fichier.write(jeu.getCaseNum(i,j)+" ");
						fichier.write(jeu.getCaseFixeInt(i,j)+" ");
					}

					fichier.write("\n");
				}

				fichier.close();
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this, "Impossible d'enregis-trer le fichier !", "Dommage", JOptionPane.ERROR_MESSAGE);
			}
		}

		catch(NullPointerException e)
		{
			this.sauverFichierSous();
		}
	}

	public void sauverFichierSous()
	{
		String nomFic = new String("");
		JFileChooser choix = new JFileChooser();
		int returnVal = choix.showSaveDialog(this);

		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			nomFic = choix.getSelectedFile().getAbsolutePath();

			try
			{
				FileWriter fichier = new FileWriter(nomFic);

				for(int i = 0; i < 9; i++)
				{
					for(int j = 0; j < 9; j++)
					{
						fichier.write(jeu.getCaseNum(i,j)+" ");
						fichier.write(jeu.getCaseFixeInt(i,j)+" ");
					}

					fichier.write("\n");
				}

				fichier.close();
				fichierCourant = choix.getSelectedFile();
			}

			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this, "Impossible d'enregistrer le fichier !", "Dommage", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void effacer()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(!jeu.getCaseFixe(i,j))
				{
					jeu.setCaseNum(i,j,0);
					(cases[i][j]).setText("");
					this.verif(i,j);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(e.getSource() == cases[i][j])
				{
					this.appuieBouton(i, j);
					this.verif(i, j);
				}
			}
		}

		if(e.getSource() == enregistrer)
		{
			this.sauverFichier();
		}

		if(e.getSource() == enregistrerSous)
		{
			this.sauverFichierSous();
		}

		if(e.getSource() == ouvrir)
		{
			this.ouvrirFichier();
		}

		if(e.getSource() == fermer)
		{
			int reponse = JOptionPane.showConfirmDialog(this,"Voulez vous enre-gistrer le fichier ?","Attention", JOptionPane.YES_NO_OPTION);

			if(reponse == JOptionPane.YES_OPTION)
			{
				this.sauverFichier();
			}
			System.exit(0);
		}

		if(e.getSource() == effacer)
		{
			this.effacer();
		}

		if(e.getSource() == nouveau)
		{
			this.nouveauFichier();
		}

		if(e.getSource() == nouveauAlea)
		{
			this.nouveauFichierAlea();
		}

		if(e.getSource() == enregistrerModele)
		{
			this.sauverModele();
		}
	}

	public static void main(String[] args)
	{
		System.setProperty("apple.laf.useScreenMenuBar","true");
		Sudoku fenetre = new Sudoku();
	}
}

