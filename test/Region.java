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
				region[posBoxX][posBoxY] = new Box();
			}
		}
	}

	/*Pour accéder à une case d'une région et à ses données (valeur si non vide, fixe ou non)*/
	public Box getBox(int posBoxX, int posBoxY)
	{
		return region[posBoxX][posBoxY];
	}

	/*MAJ des données d'une case*/
	public void setBox(int posBoxX, int posBoxY)
	{
		region[posBoxX][posBoxY].setNumber(region[posBoxX][posBoxY].getNumber());
	}

	/*La méthode vérifie si chaque case d'une région est vide ou si elle à une valeur.
	  Si toutes les cases d'une région sont remplies, la fonction renvoie 'true'*/
	public boolean filledRegion()
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
				if(region[posBoxX][posBoxY].getNumber() == 1)
				{
					un = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 2)
				{
					deux = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 3)
				{
					trois = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 4)
				{
					quatre = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 5)
				{
					cinq = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 6)
				{
					six = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 7)
				{
					sept = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 8)
				{
					huit = true;
				}

				else if(region[posBoxX][posBoxY].getNumber() == 9)
				{
					neuf = true;
				}
			}
		}

		if(un && deux && trois && quatre && cinq && six && sept && huit && neuf)
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
				strb.append(region[posBoxX][posBoxY]);
			}

			strb.append("\n");
		}
		strb.append("\n\n");
		return strb.toString();
	}
}