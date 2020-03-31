public class Count 
{
	private int digit;

	@Override 
	public String toString()
	{
		if(this.digit == 0)
		{
			return " ";
		}

		else
		{
			return Integer.toString(this.digit);
		}
	}

	public void setDigit()
	{
		if((this.digit >= 0) && (this.digit < 9))
		{
			this.digit++;
		}

		else
		{
			this.digit = 0;
		}
	}
}