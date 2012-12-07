package log121.tp3.controleur;

import java.util.Observer;

import log121.tp3.CommandeAnnuler;
import log121.tp3.CommandeTranslation;
import log121.tp3.CommandeZoom;
import log121.tp3.GestionnaireCommande;
import log121.tp3.Image;
import log121.tp3.MementoImage;

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
		//GestionnaireCommande.addMemento(Origine.createMementoImage());
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
	public void faireTranslation(int x1, int x2, int y1, int y2) {
		//M�thode appel� quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(new CommandeTranslation(x1,x2,y1,y2));
		GestionnaireCommande.getInstance().faireCommande();
		addMemento();
	}

	/**
	 * Cette m�thode fait un zoom.
	 * 
	 * @param zoomIn
	 *            d�termine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(int x1, int x2, int y1, int y2) {
		//M�thode appel� quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(new CommandeZoom(x1,x2,y1,y2));
		GestionnaireCommande.getInstance().faireCommande();
		addMemento();

		// test
		// mv.setImage();
	}

	/**
	 * Cette m�thode fait une annulation.
	 */
	public void annuler() {
		//On r�cup�re la derni�re image
		MementoImage mi = GestionnaireCommande.getInstance().getMementoImage();
		//On cr�e la commande avec la derni�re image et on l'ajoute au gestionnaire
		GestionnaireCommande.getInstance().setCommande(new CommandeAnnuler(mi));
		GestionnaireCommande.getInstance().faireCommande();
		//M�thode appel� quand on clique sur le bouton
		//mv.setImage(GestionnaireCommande.getInstance().annuler());
		//GestionnaireCommande.getInstance().annuler();
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
	
	public ModeleVue getModeleVue() {
		return this.mv;
	}
	
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		GestionnaireCommande.getInstance().creerImageInitiale(path, largeurOriginale, hauteurOriginale);
	}
	
}
