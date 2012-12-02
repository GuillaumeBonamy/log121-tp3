import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class VueThumbnail extends JFrame implements ActionListener, Observer{

	private JMenuBar menuBar;
	private JMenu menuAction;
	private JMenuItem changerImage;
	private JPanel panelImage;
	private JLabel labelImage;
	private ImageIcon icon;
	private Image img;
	
	/**
	 * Constructeur de la classe VueThumbnail
	 * @param img L'image a afficher dans la fenetre
	 */
	public VueThumbnail(Image img)
	{
		setTitle("Vue vignette");
		setLocation(50,450);
		setSize(400,400);
		
		creerMenu();
		
		this.img=img;
		
		this.panelImage=new JPanel();
		this.icon =new ImageIcon(img.getCheminImage());
		this.labelImage	=new JLabel(icon);
		
		this.panelImage.add(labelImage);
		this.add(panelImage);
		
		modifierImage();
		
		setVisible(true);
	}
	
	/**
	 * Methode permettant de modifier les coordonnees de l'image
	 */
	public void modifierImage()
	{
		img.setX1(0);
		img.setX2(icon.getIconWidth());
		System.out.println("hauteur:" + icon.getIconWidth());
		img.setY1(0);
		img.setY2(icon.getIconHeight());
		System.out.println("largeur:" + icon.getIconHeight());
	}
	
	/**
	 * Methode permettant de creer le menu de la fenetre
	 */
	public void creerMenu()
	{
		menuBar = new JMenuBar();
		
		menuAction=new JMenu("Action");
		changerImage=new JMenuItem("Changer Image");
		
		
		menuAction.add(changerImage);
		changerImage.addActionListener(this);
		
		
		menuBar.add(menuAction);
		
		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les actions des items
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==changerImage)
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
	
	 public void update(Observable arg0, Object arg1) {
         // TODO Auto-generated method stub   
	 }
}
