package log121.tp3.controleur;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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

import log121.tp3.Image;

public class VueThumbnail extends JFrame implements ActionListener, Observer {

	private JMenuBar menuBar;
	private JMenu menuAction;
	private JMenuItem changerImage;
	private JPanel panelImage;
	private JLabel labelImage;
	private ImageIcon iconeImage;
	private Image img;

	/**
	 * Cette fonction dessine la zone de l'image avec un carré rouge.
	 * @param iModifiee l'image de la modèle de la vue.
	 * @return l'icon de l'image.
	 */
	private ImageIcon dessinerZoneImage(Image iModifiee) {
		int type = BufferedImage.TYPE_INT_RGB;
		BufferedImage bi = new BufferedImage(img.getLargeurOriginal(),
				img.getHauteurOriginale(), type);
		Graphics2D g2 = bi.createGraphics();
		g2.drawImage(iconeImage.getImage(), 0, 0, img.getLargeurOriginal(),
				img.getHauteurOriginale(), this);

		g2.setColor(Color.RED);
		g2.drawRect(iModifiee.getX1(), iModifiee.getY1(), iModifiee.getX2()
				- iModifiee.getX1() - 1, iModifiee.getY2() - iModifiee.getY1()
				- 1);

		g2.dispose();
		return new ImageIcon(bi);
	}

	/**
	 * Constructeur de la classe VueThumbnail
	 * 
	 * @param img
	 *            L'image a afficher dans la fenetre
	 */
	public VueThumbnail() {
		setTitle("Vue vignette");
		setLocation(50, 450);
		setSize(400, 400);

		creerMenu();

		this.img = Controleur.getInstance().getImageModeleVue();

		this.panelImage = new JPanel();
		this.iconeImage = new ImageIcon(img.getCheminImage());
		this.labelImage = new JLabel(dessinerZoneImage(this.img));

		this.panelImage.add(labelImage);
		this.add(panelImage);

		// modifierImage();

		setVisible(true);
	}

	// /**
	// * Methode permettant de modifier les coordonnees de l'image
	// */
	// public void modifierImage()
	// {
	// img.setX1(0);
	// img.setX2(icon.getIconWidth());
	// System.out.println("hauteur:" + icon.getIconWidth());
	// img.setY1(0);
	// img.setY2(icon.getIconHeight());
	// System.out.println("largeur:" + icon.getIconHeight());
	// }

	/**
	 * Methode permettant de creer le menu de la fenetre
	 */
	public void creerMenu() {
		menuBar = new JMenuBar();

		menuAction = new JMenu("Action");
		changerImage = new JMenuItem("Changer Image");

		menuAction.add(changerImage);
		changerImage.addActionListener(this);

		menuBar.add(menuAction);

		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les actions des items
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changerImage) {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);

			Image image = new Image(fc.getSelectedFile().getAbsolutePath(), iconeImage.getIconWidth(), 
					iconeImage.getIconHeight());

			new VueThumbnail();
			new VueImageModifie();
			new VueStatistiques();
		}
	}

	public void update(Observable arg0, Object arg1) {
		labelImage.setIcon(dessinerZoneImage(Controleur.getInstance()
				.getImageModeleVue()));
	}
}
