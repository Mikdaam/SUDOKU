/*Représentation d'une région*/

public class Region
{
	public Box[][] region;

	public Region()
	{
		this.region = new Box[3][3]; //Une région est une grille 3*3 de 9 cases

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.region[i][j] = new Box();
				//System.out.print(this.region[i][j].getDigit() + " ");
			}

			//System.out.println();
		}
	}

	/*Récupérer une case (valeur fixe ou non et chiffre)*/
	public Box getBox()

	public static void main(String[] args) {
		Region r = new Region();
	}
}