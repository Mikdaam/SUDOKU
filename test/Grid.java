public class Grid extends Region
{
	public Region[][] grid; //La grille de jeu complète

	/*Initialisation les regions*/
	public Grid()
	{
		this.grid = new Region[3][3];

		for(int posRegionX = 0; posRegionX < 3; posRegionX++)
		{
			for(int posRegionY = 0; posRegionY < 3; posRegionY++)
			{
				this.grid[posRegionX][posRegionY] = new Region();
			}
		}
	}

	/*Ecrire le constructeur à partir d'un fichier*/

	/*Pour accéder à une région*/
	public Region getRegion(int posRegionX, int posRegionY)
	{
		return this.grid[posRegionX][posRegionY];
	}

	public int getNbBox(Region region, int posBoxX, int posBoxY)
	{
		return this.grid.getRegion().getBox(posBoxX, posBoxY).getNumber();
	}

	/*MAJ d'une région*/
	public void setRegion(Region[][] region)
	{
		this.grid = region;
	}

	/*La méthode vérifie si chaque case d'une région est vide ou si elle à une valeur.
	  Si toutes les cases d'une région sont remplies d'une valeur différente à chaque fois,
	  la fonction renvoie 'true'*/
	public boolean filledLine(int nbLine, int posRegionX, int posRegionY)
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

		for(int posBoxX = 0; posBoxX < 9; posBoxX++)
		{
			if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 1)
			{
				one = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 2)
			{
				two = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 3)
			{
				three = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 4)
			{
				four = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 5)
			{
				five = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 6)
			{
				six = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 7)
			{
				seven = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 8)
			{
				eight = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(posBoxX, nbLine).getNumber() == 9)
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

	public boolean filledColumn(int nbColumn, int posRegionX, int posRegionY)
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

		for(int posBoxY = 0; posBoxY < 9; posBoxY++)
		{
			if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 1)
			{
				one = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 2)
			{
				two = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 3)
			{
				three = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 4)
			{
				four = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 5)
			{
				five = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 6)
			{
				six = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 7)
			{
				seven = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 8)
			{
				eight = true;
			}

			else if(this.grid[posRegionX][posRegionY].getBox(nbColumn, posBoxY).getNumber() == 9)
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

	
	public String toString(int posRegionX, int posRegionY)
	{
		StringBuffer strb = new StringBuffer();
		strb.append("-----------------------\n");

		for(int posBoxX = 0; posBoxX < 9; posBoxX++)
		{
			for(int posBoxY = 0; posBoxY < 9; posBoxY++)
			{
				if(posBoxY == 0)
				{
					strb.append("| ");
				}

				strb.append(this.grid[posRegionX][posRegionY].getBox(posBoxX, posBoxY).getNumber() + " ");

				if((posBoxY == 2) || (posBoxY == 5) || (posBoxY == 8))
				{
					strb.append("| ");
				}
			}

			if((posBoxX == 2) || (posBoxX == 5))
			{
				strb.append("\n|----------------------------|");
			}

			if(posBoxX == 8)
			{
				strb.append("\n");
			}
		}

		return strb.toString();
	}
}