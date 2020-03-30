/*Classe qui représente la grille de sudoku*/

public class Grid
{
	private Region[][] grid = new Region[3][3]; //Une grille 3*3 de sudoku est composé de 9 régions

	/*Initialisation de la grille*/
	public Grid()
	{
		for(int regionX = 0; regionX < 3; regionX++)
		{
			for(int regionY = 0; regionY < 3; regionY++)
			{
				grid[regionX][regionY] = new Region();
			}
		}
	}

	/*Récupère une région*/
	public Region getRegion(int regionX, int regionY)
	{
		return this.grid[regionX][regionY];
	}	
}