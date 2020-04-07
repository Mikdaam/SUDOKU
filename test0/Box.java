public class Box
{
	public int number;
	public boolean isFixe;

	public Box()
	{
		this.number = 0;
		this.isFixe = false;
	}

	public Box(int n)
	{
		this.number = n;
		this.isFixe = false;
	}

	public Box(int n, boolean f)
	{
		this.number = n;
		this.isFixe = f;
	}

	public Box(boolean f)
	{
		this.number = 0;
		this.isFixe = f;
	}

	public int getNumber()
	{
		return this.number;
	}

	public void setNumber(int n)
	{
		this.number = n;
	}

	public boolean getFixe()
	{
		return this.isFixe;
	}

	public void setIsFixe(boolean f)
	{
		this.isFixe = f;
	}

	@Override
	public String toString()
	{
		StringBuffer strb = new StringBuffer();
		strb.append(number);return strb.toString();
	}
}