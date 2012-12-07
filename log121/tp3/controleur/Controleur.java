package log121.tp3.controleur;

import java.util.Observer;

import log121.tp3.GestionnaireCommande;
import log121.tp3.Image;

/**
 * Cette classe s'occupe de faire le lien entre la vue et le modèle.
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
	 * Cette méthode ajouter un memento.
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
	 * Cette méthode fait une translation.
	 */
	public void faireTranslation(int x1, int x2, int y1, int y2) {
		//Méthode appelé quand on clique sur le bouton
		//gc.getInstance().ajouterCommande(new CommandeTranslation(parametre));
		//gc.getInstance().faire();
		addMemento();
	}

	/**
	 * Cette méthode fait un zoom.
	 * 
	 * @param zoomIn
	 *            détermine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(boolean zoomIn) {
		//Méthode appelé quand on clique sur le bouton
		//gc.getInstance().ajouterCommande(new CommandeZoom(parametre));
		//gc.getInstance().faire();
		addMemento();

		// test
		// mv.setImage();
	}

	/**
	 * Cette méthode fait une annulation.
	 */
	public void annuler() {
		//Méthode appelé quand on clique sur le bouton
		// mv.setImage(gc.getInstance().annuler());
		//gc.getInstance().annuler();
	}

	/**
	 * Cette méthode ajouter des observeurs à la modèle de la vue.
	 * 
	 * @param o
	 *            un observeur de la modèle de la vue.
	 */
	public void addObserverModelVue(Observer o) {
		mv.addObserver(o);
	}

	/**
	 * Cette méthode recherche l'image de la modèle de la vue.
	 */
	public Image getImageModeleVue() {
		return mv.getImage();
	}
	
	public ModeleVue getModeleVue() {
		return this.mv;
	}
	
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		GestionnaireCommande.getInstance().creerImageInitiale(path, largeurOriginale, hauteurOriginale);
	}
	
}
