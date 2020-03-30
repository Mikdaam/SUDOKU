/*Classe qui initialise une Fenêtre*/

import javax.swing.JFrame;

public class Frame extends JFrame
{

	public Frame()
	{
		super("Sudoku");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}