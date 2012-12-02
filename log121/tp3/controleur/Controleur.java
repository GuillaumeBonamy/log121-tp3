package log121.tp3.controleur;

import java.util.Observer;

import log121.tp3.Image;

/**
 * Cette classe s'occupe de faire le lien entre la vue et le mod�le.
 * 
 * @author James Medvedovski
 * 
 */
public class Controleur {
	private static Controleur c = null;
	private ModeleVue mv = new ModeleVue();

	private Controleur() {
	}

	/**
	 * Cette m�thode ajouter un memento.
	 */
	private void addMemento() {
		// Origine.setImage(mv.getImage());
		// gc.addMemento(Origine.createMemento());
	}

	public static Controleur getInstance() {
		if (c == null) {
			c = new Controleur();
		}
		return c;
	}

	/**
	 * Cette m�thode fait une translation.
	 */
	public void faireTranslation() {
		// gc.getInsatance().faireTranslation();
		addMemento();
	}

	/**
	 * Cette m�thode fait un zoom.
	 * 
	 * @param zoomIn
	 *            d�termine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(boolean zoomIn) {
		// gc.getInsatance().faireZoom();
		addMemento();

		// test
		// mv.setImage();
	}

	/**
	 * Cette m�thode fait une annulation.
	 */
	public void annuler() {
		// mv.setImage(gc.getInsatance().annuler());

	}

	/**
	 * Cette m�thode ajouter des observeurs � la mod�le de la vue.
	 * 
	 * @param o
	 *            un observeur de la mod�le de la vue.
	 */
	public void addObserverModelVue(Observer o) {
		mv.addObserver(o);
	}

	/**
	 * Cette m�thode recherche l'image de la mod�le de la vue.
	 */
	public Image getImageModeleVue() {
		return mv.getImage();
	}

	/**
	 * M�THODE TEMPORAIRE! Il faut passer par GestionCommande.
	 * 
	 * @param i
	 */
	public void tempSetImage(Image i) {
		mv.setImage(i);
	}
}
