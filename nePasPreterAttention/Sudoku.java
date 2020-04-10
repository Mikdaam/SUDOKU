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
	private Button[][] boxes = new Button[9][9];

	private GridLayout gridLayout = new GridLayout(3, 3); //Disposition 3*3 de la grille et des régions
	private GridLayout regionLayout = new GridLayout(3, 3); //Disposition 3*3 d'une région

	private int digit; //Valeur d'une case
	private boolean isFixed; //Statut d'une case

	/*private int[][][][] matriceSudo = {{ {{0,0,0},{5,3,0},{0,0,0}}, {{0,9,5},{4,0,8},{7,0,0}}, {{0,0,4},{7,0,2},{6,0,3}} },
									   { {{9,0,0},{0,4,0},{0,2,0}}, {{0,3,4},{0,1,0},{5,7,0}}, {{0,8,0},{0,7,0},{0,0,6}} },
									   { {{4,0,9},{6,0,7},{2,0,0}}, {{0,0,2},{9,0,3},{6,5,0}}, {{0,0,0},{0,2,1},{0,0,0}} } };*/
	private int[][] matriceSudo = {{0,0,0,0,9,5,0,0,4},
								   {5,3,0,4,0,8,7,0,2},
								   {0,0,0,7,0,0,6,0,3},
								   {9,0,0,0,3,4,0,8,0},
								   {0,4,0,0,1,0,0,7,0},
								   {0,2,0,5,7,0,0,0,6},
								   {4,0,9,0,0,2,0,0,0},
								   {6,0,7,9,0,3,0,2,1},
								   {2,0,0,6,5,0,0,0,0}};

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
			}
		}

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int d = this.matriceSudo[i][j];

				if(d == 0)
				{
					this.boxes[i][j] = new Button("");
				}

				else
				{
					this.boxes[i][j] = new Button(Integer.toString(d));
				}

				Count counter = new Count();
				this.boxes[i][j].addActionListener(new ButtonManagement(counter, this.boxes[i][j]));
				(this.regionPanel[(int)(i/3)][(int)(j/3)]).add(this.boxes[i][j]);
			}
		}

		for(int regionX = 0; regionX < 3; regionX++)
		{
			for(int regionY = 0; regionY < 3; regionY++)
			{
				this.gridPanel.add(this.regionPanel[regionX][regionY]);
			}
		}

				/*Initialisation des cases*/
				/*for(int boxX = 0; boxX < 3; boxX++)
				{
					for(int boxY = 0; boxY < 3; boxY++)
					{
						int d = this.matriceSudo[regionX][regionY][boxX][boxY];

						if(d != 0)
						{
							this.sudoku.getRegion(regionX, regionY).setBoxDigit(boxX, boxY, d);
							this.sudoku.getRegion(regionX, regionY).setBoxIsFixed(boxX, boxY, true);
						}

						this.digit = this.sudoku.getRegion(regionX, regionY).getBoxDigit(boxX, boxY);
						this.isFixed = this.sudoku.getRegion(regionX, regionY).getBoxIsFixed(boxX, boxY);

						if((this.digit == 0))
						{
							this.boxes[boxX][boxY] = new Button(" ");
							Count counter = new Count();
							this.boxes[boxX][boxY].addActionListener(new ButtonManagement(counter, this.boxes[boxX][boxY]));
							this.matriceSudo[regionX][regionY][boxX][boxY] = counter.getDigit();
						}

						else if((this.digit > 0) && (this.digit <= 9) && (this.isFixed == false))
						{
							this.boxes[boxX][boxY] = new Button(Integer.toString(this.digit));
							Count counter = new Count();
							this.boxes[boxX][boxY].addActionListener(new ButtonManagement(counter, this.boxes[boxX][boxY]));
							this.matriceSudo[regionX][regionY][boxX][boxY] = counter.getDigit();
						}

						else
						{
							Font font = new Font("Arial", Font.BOLD, 20);
							this.boxes[boxX][boxY] = new Button(Integer.toString(this.digit));
							this.boxes[boxX][boxY].setFont(font);
						}

						this.regionPanel[regionX][regionY].add(this.boxes[boxX][boxY]);
					}
				}

				this.gridPanel.add(this.regionPanel[regionX][regionY]);
			}*/
		

		this.frame.add(this.gridPanel);
		this.frame.setVisible(true);
	}

	/*public boolean verifLine(int regionLine, int regionY)
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

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(this.matriceSudo[regionY][i][regionLine][j] == 1)
				{
					one = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 2)
				{
					two = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 3)
				{
					three = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 4)
				{
					four = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 5)
				{
					five = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 6)
				{
					six = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 7)
				{
					seven = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 8)
				{
					eight = true;
				}

				else if(this.matriceSudo[regionY][i][regionLine][j] == 9)
				{
					nine = true;
				}

				System.out.print(this.matriceSudo[regionY][i][regionLine][j] + " ");
			}
		}

		return (one&&two&&three&&four&&five&&six&&seven&&eight&&nine);
	}
	
	public boolean verifColumn(int regionX, int regionColumn)
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

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(this.matriceSudo[i][regionColumn][j][regionX] == 1)
				{
					one = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 2)
				{
					two = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 3)
				{
					three = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 4)
				{
					four = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 5)
				{
					five = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 6)
				{
					six = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 7)
				{
					seven = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 8)
				{
					eight = true;
				}

				else if(this.matriceSudo[i][regionColumn][j][regionX] == 9)
				{
					nine = true;
				}

				System.out.println(this.matriceSudo[i][regionColumn][j][regionX] + " ");
			}
		}

		System.out.println((one&&two&&three&&four&&five&&six&&seven&&eight&&nine));
		return (one&&two&&three&&four&&five&&six&&seven&&eight&&nine);
	}

	public boolean verifRegion(int regionX, int regionY)
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

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(this.matriceSudo[regionY][regionX][i][j] == 1)
				{
					one = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 2)
				{
					two = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 3)
				{
					three = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 4)
				{
					four = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 5)
				{
					five = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 6)
				{
					six = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 7)
				{
					seven = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 8)
				{
					eight = true;
				}

				else if(this.matriceSudo[regionY][regionX][i][j] == 9)
				{
					nine = true;
				}

				System.out.print(this.matriceSudo[regionY][regionX][i][j] + " ");
			}

			System.out.println("");
		}

		System.out.println((one&&two&&three&&four&&five&&six&&seven&&eight&&nine));
		return (one&&two&&three&&four&&five&&six&&seven&&eight&&nine);
	}*/
}