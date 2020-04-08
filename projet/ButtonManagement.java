/*MAJ du bouton représentant une case*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonManagement implements ActionListener
{
	private Count counter;
	private JButton button;

	public ButtonManagement(Count c, JButton b)
	{
		this.counter = c;
		this.button = b;
	}

	@Override
	public void actionPerformed(ActionEvent event)
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
}