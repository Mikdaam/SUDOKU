import java.util.*;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jeu
{
	public Region[][] jeu;

	public Jeu()
	{
		int m = 0;
		jeu = new Region[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				jeu[i][j] = new Region();
			}
		}
	}

	public Jeu(File fichier)
	{
		int m = 0;
		jeu = new Region[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				jeu[i][j] = new Region();
			}
		}

		try
		{
			Scanner sc = new Scanner(fichier);
			String s;
			int courant;
			int fixe;
			boolean b;

			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					courant = sc.nextInt();
					this.setCaseNum(i,j,courant);
					fixe = sc.nextInt();

					if(fixe == 0)
					{
						b =false;
					}

					else
					{
						b = true;
					}

					this.setCaseFixe(i,j,b);
				}

				s = sc.nextLine();
			}
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Erreur : le fichier n'est pas au bon emplacement !");
		}
	}

	public Region getRegion(int i, int j)
	{
		return jeu[i][j];
	}

	public Region getRegionDeCase(int i, int j)
	{
		return (jeu[(int)(i/3)][(int)(j/3)]);
	}

	public void setRegion(Region[][] r)
	{
		jeu = r;
	}

	public int getCaseNum(int i, int j)
	{
		return (jeu[(int)(i/3)][(int)(j/3)]).getCaseNum(i%3,j%3);
	}

	public void setCaseNum(int i, int j, int c)
	{
		(jeu[(int)(i/3)][(int)(j/3)]).setCaseNum(i%3,j%3,c);
	}

	public boolean getCaseFixe(int i, int j)
	{
		return (jeu[(int)(i/3)][(int)(j/3)]).getCaseFixe(i%3,j%3);
	}

	public void setCaseFixe(int i, int j, boolean f)
	{
		(jeu[(int)(i/3)][(int)(j/3)]).setCaseFixe(i%3,j%3,f);
	}

	public int getCaseFixeInt(int i, int j)
	{
		if((jeu[(int)(i/3)][(int)(j/3)]).getCaseFixe(i%3,j%3))
		{
			return 1;
		}

		else
		{
			return 0;
		}
	}

	public boolean ligneCompte(int i)
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

		for(int j = 0; j < 9; j++)
		{
			switch(this.getCaseNum(i,j))
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

		if(un && deux && trois && quatre && cinq && six && sept && huit && neuf)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public boolean ligneOK(int i, int _j)
	{
		if(this.getCaseNum(i, _j) == 0)
		{
			return false;
		}

		int j = 0;
		int tmp;

		while(j < 9)
		{
			tmp = this.getCaseNum(i,j);

			if(tmp != 0)
			{
				for(int k = 0; k < 9; k++)
				{
					if(k != j)
					{
						if(tmp == this.getCaseNum(i,k))
						{
							return false;
						}
					}
				}
			}

			j++;
		}

		return true;
	}

	public boolean ligneOK(int i, int j, int val)
	{
		if(val == 0)
		{
			return false;
		}

		for(int k = 0; k < 9; k++)
		{
			if(val == this.getCaseNum(i,k))
			{
				return false;
			}
		}

		return true;
	}

	public boolean colonneCompte(int j)
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

		for(int i=0;i<9;i++)
		{
			switch(this.getCaseNum(i,j))
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

		if(un && deux && trois && quatre && cinq && six && sept && huit && neuf)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public boolean colonneOK(int i, int j, int val)
	{
		if(val == 0)
		{
			return false;
		}

		for(int k=0;k<9;k++)
		{
			if(val == this.getCaseNum(k,j))
			{
				return false;
			}
		}

		return true;
	}

	public boolean colonneOK(int _i, int j)
	{
		if(this.getCaseNum(_i,j) == 0)
		{
			return false;
		}

		int i = 0;
		int tmp;

		while(i<9)
		{
			tmp = this.getCaseNum(i,j);

			if(tmp != 0)
			{
				for(int k = 0; k < 9; k++)
				{
					if(k != i)
					{
						if(tmp == this.getCaseNum(k,j))
						{
							return false;
						}
					}
				}
			}

			i++;
		}

		return true;
	}

	public boolean gagne()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(!(jeu[i][j]).regionCompte())
				{
					return false;
				}
			}
		}

		for(int i = 0; i < 9; i++)
		{
			if(!colonneCompte(i) || !ligneCompte(i))
			{
				return false;
			}
		}
		
		return true;
	}

	public void remplirRandom()
	{
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int v = 0;

				while(v <= 0 )
				{
					v = rand.nextInt(10);

					if((this.getRegionDeCase(i,j).regionOK(i,j,v)) && (this.ligneOK(i,j,v)) && (this.colonneOK(i,j,v)))
					{
						this.setCaseNum(i,j,v);

						if(v != 0)
						{
							this.setCaseFixe(i,j,true);
						}

						else
						{
							this.setCaseFixe(i,j,false);
						}
					}

					else
					{
						this.setCaseNum(i,j,0);
						this.setCaseFixe(i,j,false);
					}
				}
			}
		}
	}
}