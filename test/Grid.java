public class Grid
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

	/*MAJ d'une région*/
	public void setRegion(Region[][] region)
	{
		this.grid = region;
	}

	/*La méthode vérifie si chaque case d'une région est vide ou si elle à une valeur.
	  Si toutes les cases d'une région sont remplies d'une valeur différente à chaque fois,
	  la fonction renvoie 'true'*/
	/*public boolean filledRegion()
	{
		boolean un = false;
		boolean deux = false;		
		boolean trois = false;
		boolean quatre = false;
		boolean cinq = false;
		boolean six = false;
		boolean sept = false;
		boolean huit = false;
		boolean neuf = false;

		for(int posBoxX = 0; posBoxX < 3; posBoxX++)
		{
			for(int posBoxY = 0; posBoxY < 3; posBoxY++)
			{
				if(this.region[posBoxX][posBoxY].getNumber() == 1)
				{
					un = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 2)
				{
					deux = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 3)
				{
					trois = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 4)
				{
					quatre = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 5)
				{
					cinq = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 6)
				{
					six = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 7)
				{
					sept = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 8)
				{
					huit = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 9)
				{
					neuf = true;
				}
			}
		}*/
}