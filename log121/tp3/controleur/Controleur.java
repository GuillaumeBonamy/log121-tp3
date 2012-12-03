package log121.tp3.controleur;

import java.util.Observer;

import log121.tp3.CommandeTranslation;
import log121.tp3.CommandeZoom;
import log121.tp3.Image;
import log121.tp3.Origine;

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
		//Origine.setState(mv.getImage());
		//gc.addMemento(Origine.createMementoImage());
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
		//M�thode appel� quand on clique sur le bouton
		//gc.getInstance().ajouterCommande(new CommandeTranslation(parametre));
		//gc.getInstance().faire();
		addMemento();
	}

	/**
	 * Cette m�thode fait un zoom.
	 * 
	 * @param zoomIn
	 *            d�termine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(boolean zoomIn) {
		//M�thode appel� quand on clique sur le bouton
		//gc.getInstance().ajouterCommande(new CommandeZoom(parametre));
		//gc.getInstance().faire();
		addMemento();

		// test
		// mv.setImage();
	}

	/**
	 * Cette m�thode fait une annulation.
	 */
	public void annuler() {
		//M�thode appel� quand on clique sur le bouton
		// mv.setImage(gc.getInstance().annuler());
		//gc.getInstance().annuler();
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
