/*Classe qui gère une case de la grille de sudoku*/
public class Box
{
	public int number; //Valeur d'une case
	public boolean isFixed; //Renvoie 'true' si la case est censée être fixe

	/*Les constructeurs suivants crées une case soit vide, soit initialisé avec une valeur et fixe ou non*/
	public Box()
	{
		this.number = 0;
		this.isFixed = false;
	}

	public Box(int n)
	{
		this.number = n;
		this.isFixed = false;
	}

	public Box(int n, boolean f)
	{
		this.number = n;
		this.isFixed = f;
	}

	/*Accéder à la valeur de la case*/
	public int getNumber()
	{
		return this.number;
	}

	/*Savoir si une case est fixe ou non*/
	public boolean getIsFixed()
	{
		return this.isFixed;
	}

	/*MAJ de la valeur d'une case*/
	public void setNumber(int n)
	{
		this.number = n;
	}

	/*Méthode qui convertit en chaine de caractère modifiable*/
	@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();
		
		return strb.append(this.number).toString();
	}
}