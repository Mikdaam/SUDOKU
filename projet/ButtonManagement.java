/*MAJ du bouton représentant une case*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonManagement implements ActionListener
{
	private Count counter;
	private JButton button;
	private boolean isFixed;

	public ButtonManagement(Count c, JButton b, boolean f)
	{
		this.counter = c;
		this.button = b;
		this.isFixed = f;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(this.isFixed == false)
		{
			this.counter.setDigit();

			if (this.counter.getDigit() == 0)
			{
				this.button.setText(" ");
			}

			else
			{
				this.button.setText(this.counter.toString());
			}
		}

		else
		{
			int d = this.counter.getDigit();
			this.button.setText(Integer.toString(d));
		}
	}
}