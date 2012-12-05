package log121.tp3.controleur;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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

public class VueImageModifie extends JFrame implements ActionListener,
		MouseWheelListener, MouseMotionListener, MouseListener, Observer {

	private JMenuBar menuBar;
	private JMenu menuAction;
	private JMenuItem translationHaut;
	private JMenuItem translationBas;
	private JMenuItem translationDroite;
	private JMenuItem translationGauche;
	private JMenuItem zoomIn;
	private JMenuItem zoomOut;
	private JPanel panelImage;
	private JLabel labelImage;
	private ImageIcon iconeImage;
	private Image img;

	/**
	 * Cette fonction dessine une image et retourne un icone correspondant à
	 * l'image.
	 * 
	 * @return l'icon de l'image.
	 */
	private ImageIcon dessinerIconeImage() {
		int type = BufferedImage.TYPE_INT_RGB;

		BufferedImage bi = new BufferedImage(img.getLargeurOriginal(),
				img.getHauteurOriginale(), type);
		Graphics2D g2 = bi.createGraphics();

		g2.drawImage(iconeImage.getImage(), 0, 0, img.getLargeurOriginal(),
				img.getHauteurOriginale(), img.getX1(), img.getY1(),
				img.getX2(), img.getY2(), this);

		return new ImageIcon(bi);
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
		labelImage.addMouseWheelListener(this);
		labelImage.addMouseMotionListener(this);
		labelImage.addMouseListener(this);

		this.panelImage.add(labelImage);

		this.add(panelImage);
	}

	/**
	 * Methode permettant de creer le menu de la fenetre
	 */
	public void creerMenu() {
		menuBar = new JMenuBar();

		menuAction = new JMenu("Action");
		translationBas = new JMenuItem("Translation en bas");
		translationDroite = new JMenuItem("Translation à droite");
		translationGauche = new JMenuItem("Translation à gauche");
		translationHaut = new JMenuItem("Translation en haut");
		zoomIn = new JMenuItem("Zoom In");
		zoomOut = new JMenuItem("Zoom Out");

		menuAction.add(translationBas);
		translationBas.addActionListener(this);

		menuAction.add(translationDroite);
		translationDroite.addActionListener(this);

		menuAction.add(translationGauche);
		translationGauche.addActionListener(this);

		menuAction.add(translationHaut);
		translationHaut.addActionListener(this);

		menuAction.add(zoomIn);
		zoomIn.addActionListener(this);

		menuAction.add(zoomOut);
		zoomOut.addActionListener(this);

		menuBar.add(menuAction);

		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les actions sur les items
	 */
	public void actionPerformed(ActionEvent e) {
		/*
		 * Ce code est temporaire. Il faut passer par GestionCommande.
		 */

		if (e.getSource() == translationBas) {
			// test
			Image iClone = img.getclone();
			iClone.setY1(img.getY1() + 50);
			iClone.setY2(img.getY2() + 50);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == translationDroite) {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() + 50);
			iClone.setX2(img.getX2() + 50);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == translationGauche) {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() - 50);
			iClone.setX2(img.getX2() - 50);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == translationHaut) {
			// test
			Image iClone = img.getclone();
			iClone.setY1(img.getY1() - 50);
			iClone.setY2(img.getY2() - 50);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == zoomIn) {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() + 25);
			iClone.setX2(img.getX2() - 25);
			iClone.setY1(img.getY1() + 25);
			iClone.setY2(img.getY2() - 25);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else if (e.getSource() == zoomOut) {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() - 25);
			iClone.setX2(img.getX2() + 25);
			iClone.setY1(img.getY1() - 25);
			iClone.setY2(img.getY2() + 25);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() + 25);
			iClone.setX2(img.getX2() - 25);
			iClone.setY1(img.getY1() + 25);
			iClone.setY2(img.getY2() - 25);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		} else {
			// test
			Image iClone = img.getclone();
			iClone.setX1(img.getX1() - 25);
			iClone.setX2(img.getX2() + 25);
			iClone.setY1(img.getY1() - 25);
			iClone.setY2(img.getY2() + 25);
			Controleur.getInstance().tempSetImage(iClone);
			// test
		}
	}
	
	// TEST
	int clickX;
	int clickY;
	

	@Override
	public void mouseDragged(MouseEvent e) {		
		// test
		Image iClone = img.getclone();
		iClone.setX1(img.getX1() - (e.getX() - clickX));
		iClone.setX2(img.getX2() - (e.getX() - clickX));
		iClone.setY1(img.getY1() - (e.getY() - clickY));
		iClone.setY2(img.getY2() - (e.getY() - clickY));
		Controleur.getInstance().tempSetImage(iClone);
		clickX = e.getX();
		clickY = e.getY();
		// test
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clickX = e.getX();
		clickY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// TEST

	public void update(Observable arg0, Object arg1) {
		img = Controleur.getInstance().getImageModeleVue();
		labelImage.setIcon(dessinerIconeImage());
	}
}
