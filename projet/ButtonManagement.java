import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonManagement implements ActionListener
{

	public void actionPerformed(ActionEvent event)
	{
		String strDigit = event.getActionCommand();
		int digit = Integer.parseInt(strDigit);

		if((digit >= 0) && (digit <=9))
		{
			digit += 1;
		} 

		if((digit < 0) || (digit > 9))
		{
			digit = 0;
		}

		strDigit = Integer.toString(digit);
	}
}