import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class VueImageModifie extends JFrame implements ActionListener, Observer{

	private JMenuBar menuBar;
	private JMenu menuAction;
	private JMenuItem translate;
	private JMenuItem zoom;
	private JPanel panelImage;
	private JLabel labelImage;
	
	/**
	 * Constructeur de la classe VueImageModifie
	 * @param img L'image a affiche dans la fenetre
	 */
	public VueImageModifie(Image img)
	{
		setTitle("Vue image modifie");
		setLocation(450,450);
		setSize(400,400);
		
		creerMenu();
		
		this.panelImage=new JPanel();
		this.labelImage=new JLabel(new ImageIcon(img.getCheminImage()));
		
		this.panelImage.add(labelImage);
		
		this.add(panelImage);
		
		
		
		setVisible(true);
	}
	
	/**
	 * Methode permettant de creer le menu de la fenetre
	 */
	public void creerMenu()
	{
		menuBar = new JMenuBar();
		
		menuAction=new JMenu("Action");
		translate=new JMenuItem("Translater");
		zoom=new JMenuItem("Zoomer");
		
		menuAction.add(translate);
		translate.addActionListener(this);
		
		menuAction.add(zoom);
		zoom.addActionListener(this);
		
		menuBar.add(menuAction);
		
		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les actions sur les items
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==translate)
		{
			
		}
		else if(e.getSource()==zoom)
		{
			
		}
	}
	
	 public void update(Observable arg0, Object arg1) {
         // TODO Auto-generated method stub
         
	 }
}
