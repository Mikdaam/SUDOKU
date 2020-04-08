/*Classe qui initialise une Fenêtre*/

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener
{
	private File f;
	private JMenu fileMenu;
	private JMenuBar menu;
	private JMenuItem save, close, newGrid, importFile, saveAs, solve;

	public Frame()
	{
		super("Sudoku");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		this.importFile.addActionListener(this);
        setJMenuBar(this.menu);
	}

	public void openFile()
	{
		String fileName = new String("");
		JFileChooser filePicked = new JFileChooser();

		filePicked.setDialogTitle("Choisir un fichier");
		filePicked.setApproveButtonText("OK");

		int returnVal = filePicked.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = filePicked.getSelectedFile();
        }
        
        this.f = filePicked.getSelectedFile();
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.importFile)
		{
			openFile();
		}
	}
}