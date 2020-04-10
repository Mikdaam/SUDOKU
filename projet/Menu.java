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

public class Menu extends JMenuBar
{
	private File f;
	private JMenu fileMenu;
	private JMenuBar menu;
	private JMenuItem save, close, newGrid, importFile, saveAs, solve;

	public Menu()
	{
		/*Barre de menu*/

		this.menu = new JMenuBar();

		this.fileMenu = new JMenu("Fichier");

		this.importFile = new JMenuItem("Importer");
		this.close = new JMenuItem("Fermer");
		this.newGrid = new JMenuItem("Nouveau");
		this.save = new JMenuItem("Enregistrer");
		this.saveAs = new JMenuItem("Enregistrer sous...");
		this.solve = new JMenuItem("Resoudre");

		this.fileMenu.add(this.importFile);
		this.fileMenu.add(this.close);
		this.fileMenu.add(this.newGrid);
		this.fileMenu.add(this.save);
		this.fileMenu.add(this.saveAs);
		this.fileMenu.add(this.solve);

		this.menu.add(this.fileMenu);
	}

	public JMenuBar getMenuBar()
	{
		return this.menu;
	}

	public JMenuItem getSave()
	{
		return this.save;
	}

	public JMenuItem getClose()
	{
		return this.close;
	}

	public JMenuItem getNewGrid()
	{
		return this.newGrid;
	}

	public JMenuItem getImportFile()
	{
		return this.importFile;
	}

	public JMenuItem getSaveAs()
	{
		return this.saveAs;
	}

	public JMenuItem getSolve()
	{
		return this.solve;
	}
}