/*Représentation d'une case de la grille*/

public class Case{
	public int num;
	public boolean fixe;

	public Case()
	{
		num = 0;
		fixe = false;
	}

	public Case(int n)
	{
		num = n;
		fixe = false;
	}

	public Case(int n, boolean f)
	{
		num = n;
		fixe = f;
	}

	public Case(boolean f)
	{
		num = 0;
		fixe = f;
	}

	public int getNum()
	{
		return this.num;
	}

	public void setNum(int n)
	{
		num = n;
	}

	public boolean getFixe()
	{
		return this.fixe;
	}

	public void setFixe(boolean f)
	{
		this.fixe = f;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(num);return sb.toString();
	}
}