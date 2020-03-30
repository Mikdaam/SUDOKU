/*Classe qui représente une région de la grille*/

public class Region
{
	private Box[][] region = new Box[3][3]; //Une région est une grille 3*3

	/*Initialisation des cases d'une région*/
	public Region()
	{
		for(int boxX = 0; boxX < 3; boxX++)
		{
			for(int boxY = 0; boxY < 3; boxY++)
			{
				this.region[boxX][boxY] = new Box(0, false);
			}
		}
	}

	/*Retourne les caractéristiques d'une case (valeur, statut)*/
	public Box getBox(int boxX, int boxY)
	{
		return this.region[boxX][boxY];
	}

	/*Retourne la valeur d'une case*/
	public int getBoxDigit(int boxX, int boxY)
	{
		return this.region[boxX][boxY].getDigit();
	}

	/*Retourne le statut d'une case*/
	public boolean getBoxIsFixed(int boxX, int boxY)
	{
		return this.region[boxX][boxY].getIsFixed();
	}

	/*MAJ de la valeur d'une case*/
	public void setBoxDigit(int boxX, int boxY, int d)
	{
		this.region[boxX][boxY].setDigit(d);
	}

	/*MAJ du statut d'une case*/
	public void setBoxIsFixed(int boxX, int boxY, boolean f)
	{
		this.region[boxX][boxY].setIsFixed(f);
	}
}