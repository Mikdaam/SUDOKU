import java.io.File;

public class Grid extends Region
{
	public Region[][] grid; //La grille de jeu complète

	/*Initialisation les regions*/
	public Grid()
	{
		this.grid = new Region[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.grid[i][j] = new Region();
			}
		}
	}

	/*Pour accéder à une région*/
	public Region getRegion(int i, int j)
	{
		return this.grid[i][j];
	}

	/*Pour accéder à la région de la case de coordonnées i, j (de 0 à 8)*/
	public Region getBoxRegion(int i, int j)
	{
		return this.grid[(int)(i/3)][(int)(j/3)];
	}

	/*Recupère la valeur d'une case dans une région donnée*/
	public int getBoxDigit(int i, int j)
	{
		return this.getBoxRegion(i, j).getBoxDigit(i % 3, j % 3);
	}

	/*Récupère la valeur fixe d'une case*/
	public boolean getBoxIsFixed(int i, int j)
	{
		return this.getBoxRegion(i,j).getBoxIsFixed(i % 3, j % 3);
	}

	/*MAJ d'une région*/
	public void setRegion(Region[][] region)
	{
		this.grid = region;
	}

	/*MAJ du chiffre de la case à la position i,j*/
	public void setBoxDigit(int i, int j, int digit)
	{
		this.getBoxRegion(i,j).setBoxDigit(i % 3, j % 3, digit);
	}

	/*MAJ de la valeur fixe d'une case*/
	public void setBoxIsFixed(int i, int j, boolean isFixed)
	{
		this.getBoxRegion(i,j).setBoxIsFixed(i % 3, j % 3, isFixed);
	}

	/*Les méthodes vérifient si chaque case d'une ligne/colonne est vide ou si elle à une valeur.
	  Si toutes les cases d'une ligne/colonne sont remplies d'une valeur différente à chaque fois,
	  la fonction renvoie 'true'*/
	public boolean filledLine(int line)
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

		for(int i = 0; i < 9; i++)
		{
			if(this.getBoxDigit(line, i) == 1)
			{
				one = true;
			}

			else if(this.getBoxDigit(line, i) == 2)
			{
				two = true;
			}

			else if(this.getBoxDigit(line, i) == 3)
			{
				three = true;
			}

			else if(this.getBoxDigit(line, i) == 4)
			{
				four = true;
			}

			else if(this.getBoxDigit(line, i) == 5)
			{
				five = true;
			}

			else if(this.getBoxDigit(line, i) == 6)
			{
				six = true;
			}

			else if(this.getBoxDigit(line, i) == 7)
			{
				seven = true;
			}

			else if(this.getBoxDigit(line, i) == 8)
			{
				eight = true;
			}

			else if(this.getBoxDigit(line, i) == 9)
			{
				nine = true;
			}
		}

		return (one && two && three && four && five && six && seven && eight && nine);
	}

	public boolean filledColumn(int column)
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

		for(int j = 0; j < 9; j++)
		{
			if(this.getBoxDigit(j, column) == 1)
			{
				one = true;
			}

			else if(this.getBoxDigit(j, column) == 2)
			{
				two = true;
			}

			else if(this.getBoxDigit(j, column) == 3)
			{
				three = true;
			}

			else if(this.getBoxDigit(j, column) == 4)
			{
				four = true;
			}

			else if(this.getBoxDigit(j, column) == 5)
			{
				five = true;
			}

			else if(this.getBoxDigit(j, column) == 6)
			{
				six = true;
			}

			else if(this.getBoxDigit(j, column) == 7)
			{
				seven = true;
			}

			else if(this.getBoxDigit(j, column) == 8)
			{
				eight = true;
			}

			else if(this.getBoxDigit(j, column) == 9)
			{
				nine = true;
			}
		}

		return (one && two && three && four && five && six && seven && eight && nine);
	}

	public boolean winner()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(this.grid[i][j].filledRegion() == false)
				{
					return false;
				}
			}
		}

		for(int i = 0; i < 9; i++)
		{
			if((filledLine(i) == false) || (filledColumn(i) == false))
			{
				return false;
			}
		}

		return true;
	}

	/*Algo de résolution*/

	/*public String toString(int i, int j)
	{
		StringBuffer strb = new StringBuffer();
		strb.append("-----------------------\n");

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(j == 0)
				{
					strb.append("| ");
				}

				strb.append(this.grid[i][j].getBox(i, j).getDigit() + " ");

				if((j == 2) || (j == 5) || (j == 8))
				{
					strb.append("| ");
				}
			}

			if((i == 2) || (i == 5))
			{
				strb.append("\n|----------------------------|");
			}

			if(i == 8)
			{
				strb.append("\n");
			}
		}

		return strb.toString();
	}*/
}