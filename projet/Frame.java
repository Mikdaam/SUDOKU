/*Classe qui initialise une Fenêtre*/

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Frame extends JFrame
{
	private Menu menu = new Menu();

	public Frame()
	{
		super("Sudoku");
		this.setSize(550, 550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(this.menu.getMenuBar());
	}

	public JMenuItem getSave()
	{
		return this.menu.getSave();
	}

	public JMenuItem getClose()
	{
		return this.menu.getClose();
	}

	public JMenuItem getNewGrid()
	{
		return this.menu.getNewGrid();
	}

	public JMenuItem getImportFile()
	{
		return this.menu.getImportFile();
	}

	public JMenuItem getSaveAs()
	{
		return this.menu.getSaveAs();
	}

	public JMenuItem getSolve()
	{
		return this.menu.getSolve();
	}
}