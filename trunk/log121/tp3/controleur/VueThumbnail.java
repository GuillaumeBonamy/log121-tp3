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

	private ImageIcon dessinerIconeImage(Image iModifiee) {
		int w = img.getX2() - img.getX1();
		int h = img.getY2() - img.getY1();
		int type = BufferedImage.TYPE_INT_RGB;
		BufferedImage dst = new BufferedImage(img.getX2(), img.getY2(), type);
		Graphics2D g2 = dst.createGraphics();
		dst = dst.getSubimage(img.getX1(), img.getY1(), w, h);
		g2.drawImage(iconeImage.getImage(), 0, 0, img.getX2(), img.getY2(),
				this);

		g2.setColor(Color.RED);
		g2.drawRect(iModifiee.getX1(), iModifiee.getY1(), iModifiee.getX2()
				- iModifiee.getX1() - 1, iModifiee.getY2() - iModifiee.getY1()
				- 1);

		g2.dispose();
		return new ImageIcon(dst);
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
		this.labelImage = new JLabel(dessinerIconeImage(this.img));

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

			Image image = new Image(fc.getSelectedFile().getAbsolutePath());

			new VueThumbnail();
			new VueImageModifie();
			new VueStatistiques();
		}
	}

	public void update(Observable arg0, Object arg1) {
		labelImage.setIcon(dessinerIconeImage(Controleur.getInstance().getImageModeleVue()));
	}
}
