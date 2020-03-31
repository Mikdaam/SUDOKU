/*Gestion de l'apparence d'un bouton*/

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class Button extends JButton
{
	public Button(String strDigit)
	{
		super(strDigit);
		this.setBorderPainted(false);
		this.setBackground(Color.WHITE);

		Font font = new Font("Arial", Font.PLAIN, 20);
		this.setFont(font);
	}
}