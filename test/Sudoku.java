import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Sudoku extends JFrame implements ActionListener
{
	private Grid grid;

	/*Affichage des régions*/
	private JButton boxes[][] = new JButton[9][9];
	private GridLayout g = new GridLayout(3, 3);

	/*Gestion des cases*/
	private JPanel panel;
	private JPanel genPanel;
	private JPanel[][] p = new JPanel[3][3];
	private Container container;

	/*Menu*/

	public Sudoku()
	{
		super("Sudoku"); //Création de la fenêtre
		this.grid = new Grid(); //Nouvelle grille de jeu
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);

		/*Gestion menu*/

		/*Gestion des cases en tant que boutons*/
		this.panel = new JPanel();
		this.genPanel = new JPanel();
		this.container = getContentPane();

		this.panel.setLayout(this.g);
		this.genPanel.setLayout(new BorderLayout());
		this.genPanel.add(panel, BorderLayout.CENTER);

		/*Création des régions*/
		for(int posRegionX = 0; posRegionX < 3; posRegionX++)
		{
			for (int posRegionY = 0; posRegionY < 3; posRegionY++)
			{
				this.p[posRegionX][posRegionY] = new JPanel();
				(this.p[posRegionX][posRegionY]).setLayout(new GridLayout(3, 3));
				(this.p[posRegionX][posRegionY]).setBorder(BorderFactory.createEtchedBorder());

				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						this.panel.add(this.p[posRegionX][posRegionY].add(new JButton(Integer.toString(this.grid.getNbBox(posRegionX, posRegionY, i, j)))));
					}
				}
			}
		}

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				this.panel.add(this.p[posRegionX][posRegionY].add(new JButton(Integer.toString(this.grid.getNbBox(posRegionX, posRegionY, i, j)))));
			}
		}

		this.container.add(genPanel);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{

	}

	public static void main(String[] args)
	{
		Sudoku frame = new Sudoku();
	}
}