/*Gestion de la grille complète de sudoku en mode graphique*/

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;

public class Sudoku
{
	private Frame frame = new Frame(); //Une fenêtre pour l'affichage du sudoku

	private Grid sudoku = new Grid(); //La grille générale de sudoku

	private Panel gridPanel = new Panel(); //Un pannel général qui contient la grille
	private Panel[][] regionPanel = new Panel[3][3]; //9 panneaux qui contiendront les régions
	private Button[][] boxes = new Button[3][3];

	private GridLayout gridLayout = new GridLayout(3, 3); //Disposition 3*3 de la grille et des régions
	private GridLayout regionLayout = new GridLayout(3, 3); //Disposition 3*3 d'une région

	private int digit; //Valeur d'une case
	private boolean isFixed; //Statut d'une case

	/*Initialisation d'une grille de sudoku vide*/
	public Sudoku()
	{

		/*Séparation entre les régions*/
		this.gridLayout.setHgap(3);
		this.gridLayout.setVgap(3);

		/*Séparation des cases*/
		this.regionLayout.setHgap(1);
		this.regionLayout.setVgap(1);

		/*MAJ de l'apparence du pannel général*/
		this.gridPanel.setLayout(this.gridLayout);
		
		/*Initialisation des régions*/
		for(int regionX = 0; regionX < 3; regionX++)
		{
			for(int regionY = 0; regionY < 3; regionY++)
			{
				this.regionPanel[regionX][regionY] = new Panel();
				this.regionPanel[regionX][regionY].setLayout(this.regionLayout);

				/*Initialisation des cases*/
				for(int boxX = 0; boxX < 3; boxX++)
				{
					for(int boxY = 0; boxY < 3; boxY++)
					{
						this.digit = this.sudoku.getRegion(regionX, regionY).getBoxDigit(boxX, boxY);
						this.isFixed = this.sudoku.getRegion(regionX, regionY).getBoxIsFixed(boxX, boxY);

						if((this.digit == 0))
						{
							this.boxes[boxX][boxY] = new Button(" ");
						}

						else if((this.digit > 0) && (this.digit <= 9) && (this.isFixed == false))
						{
							this.boxes[boxX][boxY] = new Button(Integer.toString(this.digit));
						}

						else
						{
							Font font = new Font("Arial", Font.BOLD, 20);
							this.boxes[boxX][boxY] = new Button(Integer.toString(this.digit));
							this.boxes[boxX][boxY].setFont(font);
						}

						/*Ajout d'un observateur aux boutons représentants les cases*/
						Count counter = new Count();
						this.boxes[boxX][boxY].addActionListener(new ButtonManagement(counter, this.boxes[boxX][boxY]));

						this.regionPanel[regionX][regionY].add(this.boxes[boxX][boxY]);
					}
				}

				this.gridPanel.add(this.regionPanel[regionX][regionY]);
			}
		}

		this.frame.add(this.gridPanel);
		this.frame.setVisible(true);
	}

	public boolean verifLine(int line)
	{
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		boolean seven = false;
		boolean eight = false;
		boolean nine = false;

		for(int column = 0; column < 9; column++)
		{
			if(this.digit == 1)
			{
				one = true;
			}

			else if(this.digit == 2)
			{
				two = true;
			}

			else if(this.digit == 3)
			{
				three = true;
			}

			else if(this.digit == 4)
			{
				four = true;
			}

			else if(this.digit == 5)
			{
				five = true;
			}

			else if(this.digit == 6)
			{
				six = true;
			}

			else if(this.digit == 7)
			{
				seven = true;
			}

			else if(this.digit == 8)
			{
				eight = true;
			}

			else if(this.digit == 9)
			{
				nine = true;
			}
		}

		if(one && two && three && four && five && six && seven && eight && nine)
		{
			return true;
		}

		else
		{
			return false;
		}
	}
	
}