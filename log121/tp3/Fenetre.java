import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Fenetre extends JFrame implements ActionListener{

	
	private JMenuBar menuBar;
	private JMenu menuFichier;
	private JMenuItem ouvrir, quitter;
	private Image image;
	
	/**
	 * Constructeur de la classe fenêtre
	 */
	public Fenetre()
	{
		setTitle("TP3");
		setLocation(0,0);
		setSize(400,400);
		
		
		creerMenu();
	
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		
		setVisible(true);
		
	}
	
	/**
	 * Methode permettant de creer le menu de la fenetre principale
	 */
	public void creerMenu()
	{
		menuBar = new JMenuBar();
		
		menuFichier=new JMenu("Fichier");
		ouvrir=new JMenuItem("Ouvrir");
		quitter=new JMenuItem("Quitter");
		
		menuFichier.add(ouvrir);
		ouvrir.addActionListener(this);
		
		menuFichier.add(quitter);
		quitter.addActionListener(this);
		
		menuBar.add(menuFichier);
		
		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les differentes actions des items
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ouvrir)
		{
			ouvrir();
		}
		else if(e.getSource()==quitter)
		{
			System.exit(0);
		}
	}
	
	/**
	 * Methode permettant d'ouvrir une image
	 */
	public void ouvrir()
	{
		
		JFileChooser fc= new JFileChooser();
		fc.showOpenDialog(this);
		
		Image image=new Image(fc.getSelectedFile().getAbsolutePath());
		
		new VueThumbnail(image);
		new VueImageModifie(image);
		new VueStatistiques(image);
		
		setVisible(true);
				
	}
	
}
