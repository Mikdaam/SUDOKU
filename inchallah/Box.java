/*Représentation d'une case*/

public class Box
{
	public int digit;
	public boolean isFixed;

	/*Crée une case vide non fixée*/
	public Box()
	{
		this.digit = 0;
		this.isFixed = false;
	}

	/*Crée une case vide ou non, non fixée*/
	public Box(int d)
	{
		this.digit = d;
		this.isFixed = false;
	}

	/*Crée une case vide ou non, fixée ou pas*/
	public Box(int d, boolean f)
	{
		this.digit = d;
		this.isFixed = f;
	}

	/*Crée une cas vide fixe ou pas
	public Box(boolean f)
	{
		this.number = 0;
		this.isFixe = f;
	}*/

	/*Récupère la valeur d'une case*/
	public int getDigit()
	{
		return this.digit;
	}

	/*MAJ de la valeur d'une case*/
	public void setDigit(int d)
	{
		this.digit = d;
	}

	/*Retourne la valeur fixe d'une case*/
	public boolean getIsFixed()
	{
		return this.isFixed;
	}

	/*MAJ de la valeur fixe d'une case*/
	public void setIsFixed(boolean f)
	{
		this.isFixed = f;
	}

	/*@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();
		strb.append(number);return strb.toString();
	}*/
}