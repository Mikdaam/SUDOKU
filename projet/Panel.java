import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

public class Panel extends JPanel
{
	@Override
	protected void paintComponent(Graphics brush)
	{
		Graphics secondBrush = brush.create();

		if(this.isOpaque())
		{
			secondBrush.setColor(this.getBackground());
			secondBrush.fillRect(0, 0, this.getWidth(), this.getHeight());
		}

		secondBrush.setColor(Color.BLACK);
		secondBrush.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}