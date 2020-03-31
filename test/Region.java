/*Classe qui gère une région 3*3*/
public class Region
{
	public Box[][] region; //une région

	/*Initialisation des cases (vides) d'une région*/
	public Region()
	{
		this.region = new Box[3][3];
		for(int posBoxX = 0; posBoxX < 3; posBoxX++)
		{
			for(int posBoxY = 0; posBoxY < 3; posBoxY++)
			{
				this.region[posBoxX][posBoxY] = new Box();
			}
		}
	}

	/*Pour accéder à une case d'une région et à ses données (valeur si non vide, fixe ou non)*/
	public Box getBox(int posBoxX, int posBoxY)
	{
		return this.region[posBoxX][posBoxY];
	}

	/*MAJ des données d'une case*/
	public void setBox(int posBoxX, int posBoxY)
	{
		this.region[posBoxX][posBoxY].setNumber(region[posBoxX][posBoxY].getNumber());
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

		for(int posBoxX = 0; posBoxX < 3; posBoxX++)
		{
			for(int posBoxY = 0; posBoxY < 3; posBoxY++)
			{
				if(this.region[posBoxX][posBoxY].getNumber() == 1)
				{
					one = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 2)
				{
					two = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 3)
				{
					three = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 4)
				{
					four = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 5)
				{
					five = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 6)
				{
					six = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 7)
				{
					seven = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 8)
				{
					eight = true;
				}

				else if(this.region[posBoxX][posBoxY].getNumber() == 9)
				{
					nine = true;
				}
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

	@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();

		for(int posBoxX = 0; posBoxX < 3; posBoxX++)
		{
			for(int posBoxY = 0; posBoxY < 3; posBoxY++)
			{
				strb.append(this.region[posBoxX][posBoxY]);
			}

			strb.append("\n");
		}
		strb.append("\n\n");
		return strb.toString();
	}
}