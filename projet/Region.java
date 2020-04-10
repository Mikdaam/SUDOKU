/*Classe qui gère une région 3*3*/

public class Region
{
	public Box[][] region; //une région

	/*Initialisation des cases (vides) d'une région*/
	public Region()
	{
		this.region = new Box[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.region[i][j] = new Box();
			}
		}
	}

	/*Pour accéder à une case d'une région et à ses données (valeur si non vide, fixe ou non)*/
	public Box getBox(int i, int j)
	{
		return this.region[i][j];
	}

	/*MAJ des données d'une case*/
	public void setBox(int i, int j, Box box)
	{
		this.region[i][j].setDigit(box.getDigit());
	}

	/*Récupère le chiffre d'une case*/
	public int getBoxDigit(int i, int j)
	{
		return this.region[i][j].getDigit();
	}

	/*MAJ du chiffre d'une case*/
	public void setBoxDigit(int i, int j, int digit)
	{
		this.region[i][j].setDigit(digit);
	}

	/*Vérifie si la case est fixe ou non*/
	public boolean getBoxIsFixed(int i, int j)
	{
		return this.region[i][j].getIsFixed();
	}

	/*MAJ de la valeur fixe d'une case*/
	public void setBoxIsFixed(int i, int j, boolean isFixed)
	{
		this.region[i][j].setIsFixed(isFixed);
	}

	/*La méthode vérifie si chaque case d'une région est vide ou si elle à une valeur.
	  Si toutes les cases d'une région sont remplies d'une valeur différente à chaque fois,
	  la fonction renvoie 'true'*/
	public boolean filledRegion()
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
				if(this.region[i][j].getDigit() == 1)
				{
					one = true;
				}

				else if(this.region[i][j].getDigit() == 2)
				{
					two = true;
				}

				else if(this.region[i][j].getDigit() == 3)
				{
					three = true;
				}

				else if(this.region[i][j].getDigit() == 4)
				{
					four = true;
				}

				else if(this.region[i][j].getDigit() == 5)
				{
					five = true;
				}

				else if(this.region[i][j].getDigit() == 6)
				{
					six = true;
				}

				else if(this.region[i][j].getDigit() == 7)
				{
					seven = true;
				}

				else if(this.region[i][j].getDigit() == 8)
				{
					eight = true;
				}

				else if(this.region[i][j].getDigit() == 9)
				{
					nine = true;
				}
			}
		}

		return (one && two && three && four && five && six && seven && eight && nine);
	}

	/*@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				strb.append(this.region[i][j]);
			}

			strb.append("\n");
		}
		strb.append("\n\n");
		return strb.toString();
	}*/
}