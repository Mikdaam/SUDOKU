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
		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier;
		String buf = "";
		int[] buffer = new int[82];

		if(dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			fichier = dialogue.getSelectedFile();
			try
			{
				FileInputStream fis = new FileInputStream(fichier);
				DataInputStream lire = new DataInputStream(fis);

				for(int i = 0; i < 9; i++)
				{
					buffer[i] = lire.readInt();
					System.out.println(Integer.toString(buffer[i]));
				}

				try
				{
					lire.close();
				}

				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}

				fis.close();
			}

			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}

			for(int i = 0; i < 9; i++)
			{
				buf = Integer.toString(buffer[i]);
				//System.out.println("buf length = " + buf.length());
				for(int j = 0; j < 9; j++)
				{	
					if(j-(9-buf.length()) >= 0)
					{
						//System.out.println(buf);
						//System.out.print("; j = "+j);
						//System.out.println("; New buf = " + buf);
						//setValue(0,i,j,Integer.parseInt(buf.substring(j-(9-buf.length()),j-(9-buf.length())+1)));
						//setValueGrille(i,j,Integer.parseInt(buf.substring(j-(9-buf.length()),j-(9-buf.length())+1)));
					}

					else
					{
						//System.out.print("0");
						//setValue(0,i,j,0);
						//setValueGrille(i,j,0);
					}
				}
			}
		}
		/*String fileName = new String("");
		JFileChooser filePicked = new JFileChooser();

		filePicked.setDialogTitle("Choisir un fichier");
		filePicked.setApproveButtonText("OK");

		int returnVal = filePicked.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = filePicked.getSelectedFile();
        }
        
        this.f = filePicked.getSelectedFile();*/
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.importFile)
		{
			openFile();
		}
	}
}