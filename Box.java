/*Classe qui gère une case de la grille de sudoku*/

public class Box
{
	public int digit; //Valeur d'une case
	public boolean isFixed; //Renvoie 'true' si la case est censée être fixe

	/*Les constructeurs suivants crées une case soit vide, soit initialisé avec une valeur et fixe ou non*/
	public Box()
	{
		this.digit = 0;
		this.isFixed = false;
	}

	public Box(int d)
	{
		this.digit = d;
		this.isFixed = false;
	}

	public Box(int d, boolean f)
	{
		this.digit = d;
		this.isFixed = f;
	}

	/*Accéder à la valeur de la case*/
	public int getDigit()
	{
		return this.digit;
	}

	/*Savoir si une case est fixe ou non*/
	public boolean getIsFixed()
	{
		return this.isFixed;
	}

	/*MAJ de la valeur d'une case*/
	public void setDigit(int d)
	{
		this.digit = d;
	}

	/*MAJ de la valeur fixe d'une case*/
	public void setIsFixed(boolean f)
	{
		this.isFixed = f;
	}

	/*Méthode qui convertit en chaine de caractère modifiable
	@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();
		
		return strb.append(this.digit).toString();
	}*/
}