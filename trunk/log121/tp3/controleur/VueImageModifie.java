package log121.tp3.controleur;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import log121.tp3.Image;

public class VueImageModifie extends JFrame implements ActionListener, Observer {

	private JMenuBar menuBar;
	private JMenu menuAction;
	private JMenuItem translate;
	private JMenuItem zoom;
	private JPanel panelImage;
	private JLabel labelImage;
	private ImageIcon iconeImage;
	private Image img;

	private ImageIcon dessinerIconeImage() {
		int w = img.getX2() - img.getX1();
		int h = img.getY2() - img.getY1();
		int type = BufferedImage.TYPE_INT_RGB;
		BufferedImage dst = new BufferedImage(img.getLargeurOriginal(), img.getHauteurOriginale(), type);
		Graphics2D g2 = dst.createGraphics();
		
		dst = dst.getSubimage(img.getX1(), img.getY1(), w, h);
						
		g2.drawImage(iconeImage.getImage(), 0, 0, img.getLargeurOriginal(), img.getHauteurOriginale(), this);		
		
		return new ImageIcon(dst);
	}

	/**
	 * Constructeur de la classe VueImageModifie
	 * 
	 * @param img
	 *            L'image a affiche dans la fenetre
	 */
	public VueImageModifie() {
		setTitle("Vue image modifie");
		setLocation(450, 450);
		setSize(400, 400);

		creerMenu();

		this.img = Controleur.getInstance().getImageModeleVue();
		iconeImage = new ImageIcon(img.getCheminImage());

		this.panelImage = new JPanel();
		this.labelImage = new JLabel(dessinerIconeImage());

		this.panelImage.add(labelImage);

		this.add(panelImage);
	}

	/**
	 * Methode permettant de creer le menu de la fenetre
	 */
	public void creerMenu() {
		menuBar = new JMenuBar();

		menuAction = new JMenu("Action");
		translate = new JMenuItem("Translater");
		zoom = new JMenuItem("Zoomer");

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
		if (e.getSource() == translate) {
			// test
			Image iClone = new Image(img.getCheminImage());
			iClone.setX1(img.getX1() + 100);
			iClone.setX2(img.getX2());
			iClone.setY1(img.getY1());
			iClone.setY2(img.getY2());
			iClone.setHauteurOriginale(img.getHauteurOriginale());
			iClone.setLargeurOriginal(img.getLargeurOriginal());
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == zoom) {
			// test
			Image iClone = new Image(img.getCheminImage());
			iClone.setX1(img.getX1() + 50);
			iClone.setX2(img.getX2() - 50);
			iClone.setY1(img.getY1() + 50);
			iClone.setY2(img.getY2() - 50);
			iClone.setHauteurOriginale(img.getHauteurOriginale());
			iClone.setLargeurOriginal(img.getLargeurOriginal());
			Controleur.getInstance().tempSetImage(iClone);
			// test
		}
	}

	public void update(Observable arg0, Object arg1) {
		img = Controleur.getInstance().getImageModeleVue();
		labelImage.setIcon(dessinerIconeImage());
	}
}
