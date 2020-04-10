/*Gestion de la grille complète de sudoku en mode graphique*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/*
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
import java.io.FileNotFoundException;*/

public class Sudoku implements ActionListener
{
	private JMenuItem save;
	private JMenuItem close;
	private JMenuItem newGrid;
	private JMenuItem importFile;
	private JMenuItem saveAs;
	private JMenuItem solve;

	private Frame frame = new Frame();

	private Grid grid = new Grid();

	private Container c = new Container();
	private JPanel generalPanel = new JPanel();
	private Panel gridPanel = new Panel();
	private Panel[][] regionPanel = new Panel[3][3];

	private Button[][] boxesButton = new Button[9][9];

	private GridLayout gridLayout = new GridLayout(3, 3);
	private GridLayout regionLayout = new GridLayout(3, 3);

	private int digit; //Valeur d'une case
	private boolean isFixed; //Statut d'une case

	private int[][] sudoMatrix = new int[9][9];

	public Sudoku()
	{
		this.save = this.frame.getSave();
		this.close = this.frame.getClose();
		this.newGrid = this.frame.getNewGrid();
		this.importFile = this.frame.getImportFile();
		this.saveAs = this.frame.getSaveAs();
		this.solve = this.frame.getSolve();

		this.save.addActionListener(this);
		this.close.addActionListener(this);
		this.newGrid.addActionListener(this);
		this.importFile.addActionListener(this);
		this.saveAs.addActionListener(this);
		this.solve.addActionListener(this);

		/*Séparation entre les régions*/
		this.gridLayout.setHgap(3);
		this.gridLayout.setVgap(3);

		this.c = this.frame.getContentPane();

		this.gridPanel.setLayout(this.gridLayout);

		this.generalPanel.setLayout(new BorderLayout());
		this.generalPanel.add(this.gridPanel, BorderLayout.CENTER);

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.regionPanel[i][j] = new Panel();
				this.regionPanel[i][j].setLayout(this.regionLayout);
				this.regionPanel[i][j].setBorder(BorderFactory.createCompoundBorder());
			}
		}

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int d = this.grid.getBoxDigit(i, j);
				boolean f = this.grid.getBoxIsFixed(i, j);

				if(d == 0)
				{
					this.boxesButton[i][j] = new Button(" ");
					Count counter = new Count();
					this.boxesButton[i][j].addActionListener(new ButtonManagement(counter, this.boxesButton[i][j], f));
				}

				else if((d != 0) && (f == false))
				{
					this.boxesButton[i][j] = new Button(Integer.toString(d));
					Count counter = new Count();
					this.boxesButton[i][j].addActionListener(new ButtonManagement(counter, this.boxesButton[i][j], f));
				}

				else if((d != 0) && (f == true))
				{
					this.boxesButton[i][j] = new Button(Integer.toString(d));
					Font font = new Font("Arial", Font.PLAIN, 20);
					this.boxesButton[i][j].setFont(font);
					Count counter = new Count();
					this.boxesButton[i][j].addActionListener(new ButtonManagement(counter, this.boxesButton[i][j], f));
				}

				this.boxesButton[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.regionPanel[(int)(i/3)][(int)(j/3)].add(this.boxesButton[i][j]);
				this.gridPanel.add(this.regionPanel[(int)(i/3)][(int)(j/3)]);
			}
		}
		this.c.add(this.generalPanel);
		this.frame.setVisible(true);
	}

	public void openFile()
	{
		JFileChooser filePicked = new JFileChooser(new File("."));
		File file;
		String fileName = "";

		int[] buffer = new int[82];

		if(filePicked.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			file = filePicked.getSelectedFile();
			try
			{
				FileInputStream fileIn = new FileInputStream(file);
				DataInputStream read = new DataInputStream(fileIn);

				for(int i = 0; i < 9; i++)
				{
					buffer[i] = read.readInt();
					//System.out.println(Integer.toString(buffer[i]));
				}

				try
				{
					read.close();
				}

				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}

				fileIn.close();
			}

			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}



			for(int i = 0; i < 9; i++)
			{
				fileName = Integer.toString(buffer[i]);
				//System.out.println("fileName length = " + fileName.length());
				for(int j = 0; j < 9; j++)
				{	
					if(j-(9-fileName.length()) >= 0)
					{
						//System.out.println(fileName);
						//System.out.print("; j = "+j);
						//System.out.println("; New fileName = " + fileName);
						this.sudoMatrix[i][j] = Integer.parseInt(fileName.substring(j-(9-fileName.length()),j-(9-fileName.length())+1));
						//setValue(0,i,j,Integer.parseInt(fileName.substring(j-(9-fileName.length()),j-(9-fileName.length())+1)));
						//setValueGrille(i,j,Integer.parseInt(fileName.substring(j-(9-fileName.length()),j-(9-fileName.length())+1)));
					}

					else
					{
						//System.out.print("0");
						this.sudoMatrix[i][j] = 0;
						//setValue(0,i,j,0);
						//setValueGrille(i,j,0);
					}
				}
			}
		}

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int d = this.sudoMatrix[i][j];
				boolean f = false;

				if(d == 0)
				{
					f = false;
				}

				else
				{
					f = true;
				}

				this.grid.setBoxDigit(i, j, d);
				this.grid.setBoxIsFixed(i, j, f);

				this.digit = this.grid.getBoxDigit(i, j);
				this.isFixed = this.grid.getBoxIsFixed(i, j);

				if(this.digit == 0)
				{
					this.boxesButton[i][j].setText(" ");
				}

				else if((this.digit >= 0) && (this.digit <= 9) && (this.isFixed == false))
				{
					this.boxesButton[i][j].setText(Integer.toString(d));
				}

				else if((this.digit >= 0) && (this.digit <= 9) && (this.isFixed == true))
				{
					Font font = new Font("Arial", Font.BOLD, 20);
					this.boxesButton[i][j].setText(Integer.toString(d));
					this.boxesButton[i][j].setFont(font);
				}
			}
		}


		/*On refet une grille de jeu*/
		/*this.grid = new Grid();

		this.gridLayout.setHgap(3);
		this.gridLayout.setVgap(3);

		this.c = new Container();
		this.c = this.frame.getContentPane();

		this.generalPanel = new JPanel();
		this.generalPanel.setLayout(new BorderLayout());
		this.generalPanel.add(this.gridPanel, BorderLayout.CENTER);

		this.boxesButton = new Button[9][9];

		this.gridLayout = new GridLayout(3, 3);
		this.regionLayout = new GridLayout(3, 3);

		this.regionPanel = new Panel[3][3];

		this.gridPanel = new Panel();
		this.gridPanel.setLayout(this.gridLayout);

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.regionPanel[i][j] = new Panel();
				this.regionPanel[i][j].setLayout(this.regionLayout);
				this.regionPanel[i][j].setBorder(BorderFactory.createCompoundBorder());
			}
		}

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int d = this.sudoMatrix[i][j];
				boolean f = false;

				if(d == 0)
				{
					f = false;
				}

				else
				{
					f = true;
				}

				this.grid.setBoxDigit(i, j, d);
				this.grid.setBoxIsFixed(i, j, f);

				if(d == 0)
				{
					this.boxesButton[i][j] = new Button(" ");
				}

				else if((d != 0) && (f == false))
				{
					this.boxesButton[i][j] = new Button(Integer.toString(d));
				}

				else if((d != 0) && (f == true))
				{
					this.boxesButton[i][j] = new Button(Integer.toString(d));
					Font font = new Font("Arial", Font.PLAIN, 20);
					this.boxesButton[i][j].setFont(font);
				}

				this.boxesButton[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.regionPanel[(int)(i/3)][(int)(j/3)].add(this.boxesButton[i][j]);
				this.gridPanel.add(this.regionPanel[(int)(i/3)][(int)(j/3)]);

				Count counter = new Count();
				this.boxesButton[i][j].addActionListener(new ButtonManagement(counter, this.boxesButton[i][j]));
			}
		}

		this.generalPanel.add(this.gridPanel);
		this.c.add(this.generalPanel);
		this.frame.setVisible(true);*/

		/*String fileNamee = new String("");
		JFileChooser filePicked = new JFileChooser();

		filePicked.setDialogTitle("Choisir un file");
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

	public static void main(String[] args) {
		Sudoku sudo = new Sudoku();
	}
}