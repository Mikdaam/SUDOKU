import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Button extends JButton
{
	private String stringDigit;

	public Button(String d)
	{
		super(d);
		this.stringDigit = d;
	}

	@Override
	protected void paintComponent(Graphics brush)
	{
		Graphics secondBrush = brush.create();

		if(this.isOpaque())
		{
			secondBrush.setColor(this.getBackground());
			secondBrush.fillRect(0, 0, this.getWidth(), this.getHeight());
		}

		secondBrush.setColor(Color.WHITE);
		secondBrush.fillRect(0, 0, this.getWidth(), this.getHeight());

		secondBrush.drawString(this.stringDigit, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
	}
}