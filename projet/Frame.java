/*Classe qui initialise une Fenêtre*/

import javax.swing.JFrame;

public class Frame extends JFrame
{

	public Frame()
	{
		super("Sudoku");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}