import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;

public class Sudoku
{
	private Frame frame = new Frame(); //Une fenêtre pour l'affichage du sudoku

	private Grid sudoku = new Grid(); //La grille générale de sudoku

	private JPanel gridPanel = new JPanel(); //Un pannel général qui contient la grille
	private JPanel[][] regionPanel = new JPanel[3][3]; //9 panneaux qui contiendront les régions

	private GridLayout gridLayout = new GridLayout(3, 3); //Disposition 3*3 de la grille et des régions
	private GridLayout regionLayout = new GridLayout(3, 3); //Disposition 3*3 d'une région

	public Sudoku()
	{

		this.gridLayout.setHgap(2);
		this.gridLayout.setVgap(2);

		this.gridPanel.setBackground(Color.BLACK);
		this.gridPanel.setLayout(this.gridLayout);
		
		for(int regionX = 0; regionX < 3; regionX++)
		{
			for(int regionY = 0; regionY < 3; regionY++)
			{
				this.regionPanel[regionX][regionY] = new JPanel();
				this.regionPanel[regionX][regionY].setLayout(this.regionLayout);

				for(int boxX = 0; boxX < 3; boxX++)
				{
					for(int boxY = 0; boxY < 3; boxY++)
					{
						int digit = this.sudoku.getRegion(regionX, regionY).getBoxDigit(boxX, boxY);
						if(digit == 0)
						{
							this.regionPanel[regionX][regionY].add(new Button(" "), BorderLayout.CENTER);
						}

						else
						{
							this.regionPanel[regionX][regionY].add(new Button(Integer.toString(digit)), BorderLayout.CENTER);
						}
					}
				}

				this.gridPanel.add(this.regionPanel[regionX][regionY]);
			}
		}

		this.frame.add(this.gridPanel);
		this.frame.setVisible(true);
	}
}