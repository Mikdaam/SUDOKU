/*Classe qui représente une case d'une région*/

public class Box 
{
	private int digit;
	private boolean isFixed;

	/*Initialise la valeur d'une case
	  et son statut (fixe ou non)*/
	public Box(int d, boolean f)
	{
		this.digit = d;
		this.isFixed = f;
	}

	/*Renvoie la valeur d'une case*/
	public int getDigit()
	{
		return this.digit;
	}

	/*Renvoie le statut d'une case*/
	public boolean getIsFixed()
	{
		return this.isFixed;
	}

	/*MAJ de la valeur d'une case*/
	public void setDigit(int d)
	{
		this.digit = d;
	}

	/*MAJ du statut d'une case*/
	public void setIsFixed(boolean f)
	{
		this.isFixed = f;
	}
}