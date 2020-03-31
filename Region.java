/*Représentation d'un carré de la grille en 3x3*/

public class Region
{
	public Case[][] region;

	public Region()
	{
		region = new Case[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3 ;j++)
			{
				region[i][j] = new Case();
			}
		}
	}

	public Case getCase(int i, int j)
	{
		return region[i][j];
	}

	public void setCase(int i, int j, Case c)
	{
		(region[i][j]).setNum(c.getNum());
	}

	public int getCaseNum(int i, int j)
	{
		return (region[i][j]).getNum();
	}

	public void setCaseNum(int i, int j, int c)
	{
		(region[i][j]).setNum(c);
	}

	public boolean getCaseFixe(int i, int j)
	{
		return (region[i][j]).getFixe();
	}

	public void setCaseFixe(int i, int j, boolean f)
	{
		(region[i][j]).setFixe(f);
	}

	public boolean regionCompte()
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

		for(int i = 0 ; i < 3 ;i++)
		{
			for(int j = 0 ; j < 3; j++)
			{
				switch((region[i][j]).getNum())
				{
					case 1 : un = true;
					break;
					case 2 : deux = true;
					break;
					case 3 : trois = true; 
					break;
					case 4 : quatre = true; 
					break;
					case 5 : cinq = true; 
					break;
					case 6 : six = true; 
					break;
					case 7 : sept = true; 
					break;
					case 8 : huit = true; 
					break;
					case 9 : neuf = true; 
					break;
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

	public boolean regionOK(int _i, int _j)
	{
		if(this.getCaseNum(_i,_j) == 0)
		{
			return false;
		}

		int k=0;
		int l=0;
		int tmp;

		while(k < 3 && l < 3)
		{
			tmp = (region[k][l]).getNum();

			if(tmp != 0)
			{
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						if((i!=k) || (j!=l))
						{
							if((region[i][j]).getNum() == tmp)
							{
								return false;
							}
						}
					}

					k++;
					l++;
				}

			}
		}
		return true;
	}

	public boolean regionOK(int i, int j, int val)
	{
		if(val == 0)
		{
			return false;
		}

		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				if(this.getCaseNum(k,l) == val)
				{
					return false;
				}
			}
		}
			return true;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				sb.append(region[i][j]+" ");
			}

			sb.append("\n");
		}

		sb.append("\n");

		return sb.toString();
	}
}