package log121.tp3.controleur;

import java.util.Observer;

import log121.tp3.CommandeAnnuler;
import log121.tp3.CommandeInitialiser;
import log121.tp3.CommandeTranslation;
import log121.tp3.CommandeZoom;
import log121.tp3.GestionnaireCommande;
import log121.tp3.Image;
import log121.tp3.MementoImage;
import log121.tp3.Origine;

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

	public static Controleur getInstance() {
		if (c == null) {
			c = new Controleur();
		}
		return c;
	}

	/**
	 * Cette méthode ajouter un memento.
	 */
	public void addMemento() {
		GestionnaireCommande.getInstance().addMemento(
				Origine.createMementoImage());
	}

	/**
	 * Cette méthode ajouter le premier memento.
	 */
	private void addMementoInitial() {
		GestionnaireCommande.getInstance().addMementoInitial(
				Origine.createMementoImage());
	}

	/**
	 * Cette méthode fait une translation.
	 */
	public void faireTranslation(int x1, int x2, int y1, int y2) {
		// Méthode appelé quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(
				new CommandeTranslation(x1, x2, y1, y2));
		GestionnaireCommande.getInstance().faireCommande();
	}

	/**
	 * Cette méthode fait un zoom.
	 * 
	 * @param zoomIn
	 *            détermine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(int x1, int x2, int y1, int y2) {
		// Méthode appelé quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(
				new CommandeZoom(x1, x2, y1, y2));
		GestionnaireCommande.getInstance().faireCommande();
	}

	/**
	 * Cette méthode fait une annulation.
	 */
	public void annuler() {
		// On récupère la dernière image
		MementoImage mi = GestionnaireCommande.getInstance().getMementoImage();
		// On crée la commande avec la dernière image et on l'ajoute au
		// gestionnaire
		GestionnaireCommande.getInstance().setCommande(new CommandeAnnuler(mi));
		GestionnaireCommande.getInstance().faireCommande();
	}

	public void initialiser() {
		// On récupère la première image
		MementoImage mi = GestionnaireCommande.getInstance()
				.getMementoImageInitiale();
		// On crée la commande avec la première image et on l'ajoute au
		// gestionnaire
		GestionnaireCommande.getInstance().setCommande(
				new CommandeInitialiser(mi));
		GestionnaireCommande.getInstance().faireCommande();
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

	public void creerImageInitiale(String path, int largeurOriginale,
			int hauteurOriginale) {
		GestionnaireCommande.getInstance().creerImageInitiale(path,
				largeurOriginale, hauteurOriginale);
		addMementoInitial();
	}

}
