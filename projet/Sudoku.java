/*Gestion de la grille complète de sudoku en mode graphique*/

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;

/*Initialisation d'une grille de sudoku vide*/
public class Sudoku
{
	private Frame frame = new Frame(); //Une fenêtre pour l'affichage du sudoku

	private Grid sudoku = new Grid(); //La grille générale de sudoku

	private JPanel gridPanel = new JPanel(); //Un pannel général qui contient la grille
	private JPanel[][] regionPanel = new JPanel[3][3]; //9 panneaux qui contiendront les régions
	private JButton[][] boxes = new JButton[3][3];

	private GridLayout gridLayout = new GridLayout(3, 3); //Disposition 3*3 de la grille et des régions
	private GridLayout regionLayout = new GridLayout(3, 3); //Disposition 3*3 d'une région

	private int digit; //Valeur d'une case

	public Sudoku()
	{

		this.gridLayout.setHgap(3);
		this.gridLayout.setVgap(3);

		this.regionLayout.setHgap(1);
		this.regionLayout.setVgap(1);

		this.gridPanel.setBackground(Color.BLACK);
		this.gridPanel.setLayout(this.gridLayout);
		
		for(int regionX = 0; regionX < 3; regionX++)
		{
			for(int regionY = 0; regionY < 3; regionY++)
			{
				this.regionPanel[regionX][regionY] = new JPanel();
				this.regionPanel[regionX][regionY].setBackground(Color.BLACK);
				this.regionPanel[regionX][regionY].setLayout(this.regionLayout);

				for(int boxX = 0; boxX < 3; boxX++)
				{
					for(int boxY = 0; boxY < 3; boxY++)
					{
						this.digit = this.sudoku.getRegion(regionX, regionY).getBoxDigit(boxX, boxY);
						if(this.digit == 0)
						{
							this.boxes[boxX][boxY] = new JButton(" ");
						}

						else
						{
							this.boxes[boxX][boxY] = new JButton(Integer.toString(this.digit));
						}

						Count counter = new Count();
							this.boxes[boxX][boxY].addActionListener(new ButtonManagement(counter, this.boxes[boxX][boxY]));

						this.boxes[boxX][boxY].setBorderPainted(false);
						this.boxes[boxX][boxY].setBackground(Color.WHITE);
						this.regionPanel[regionX][regionY].add(this.boxes[boxX][boxY]);
					}
				}

				this.gridPanel.add(this.regionPanel[regionX][regionY]);
			}
		}

		this.frame.add(this.gridPanel);
		this.frame.setVisible(true);
	}

	/*MAJ d'une case*/
}