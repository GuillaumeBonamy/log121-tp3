package log121.tp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import log121.tp3.controleur.Controleur;
import log121.tp3.controleur.VueImageModifie;
import log121.tp3.controleur.VueStatistiques;
import log121.tp3.controleur.VueThumbnail;

public class Fenetre extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menuFichier;
	private JMenuItem ouvrir, quitter;

	/**
	 * Constructeur de la classe fenêtre
	 */
	public Fenetre() {
		setTitle("TP3");
		setLocation(0, 0);
		setSize(400, 400);

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
	public void creerMenu() {
		menuBar = new JMenuBar();

		menuFichier = new JMenu("Fichier");
		ouvrir = new JMenuItem("Ouvrir");
		quitter = new JMenuItem("Quitter");

		menuFichier.add(ouvrir);
		ouvrir.addActionListener(this);
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));

		menuFichier.add(quitter);
		quitter.addActionListener(this);
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));

		menuBar.add(menuFichier);

		this.setJMenuBar(menuBar);
	}

	/**
	 * Methode permettant de gerer les differentes actions des items
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ouvrir) {
			ouvrir();
		} else if (e.getSource() == quitter) {
			System.exit(0);
		}
	}

	/**
	 * Methode permettant d'ouvrir une image
	 */
	public void ouvrir() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FiltreImage());
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() == null)
			return;
		ImageIcon iconeImage = new ImageIcon(fc.getSelectedFile()
				.getAbsolutePath());
		Controleur c = Controleur.getInstance();

		c.creerImageInitiale(fc.getSelectedFile().getAbsolutePath(),
				iconeImage.getIconWidth(), iconeImage.getIconHeight());

		VueThumbnail vt = new VueThumbnail();
		VueStatistiques vs = new VueStatistiques();
		VueImageModifie vim = new VueImageModifie(vs);

		c.addObserverModelVue(vt);
		c.addObserverModelVue(vim);
		c.addObserverModelVue(vs);

		setVisible(true);
		vt.setVisible(true);
		vim.setVisible(true);
		vs.setVisible(true);
	}
}