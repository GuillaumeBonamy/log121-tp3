package log121.tp3.controleur;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

	public static Controleur getInstance() {
		if (c == null) {
			c = new Controleur();
		}
		return c;
	}

	/**
	 * Cette m�thode ajouter un memento.
	 */
	public void addMemento() {
		GestionnaireCommande.getInstance().addMemento(
				Origine.createMementoImage());
	}

	/**
	 * Cette m�thode ajouter le premier memento.
	 */
	private void addMementoInitial() {
		GestionnaireCommande.getInstance().addMementoInitial(
				Origine.createMementoImage());
	}

	/**
	 * Cette m�thode fait une translation.
	 */
	public void faireTranslation(int x1, int x2, int y1, int y2) {
		// M�thode appel� quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(
				new CommandeTranslation(x1, x2, y1, y2));
		GestionnaireCommande.getInstance().faireCommande();
	}

	/**
	 * Cette m�thode fait un zoom.
	 * 
	 * @param zoomIn
	 *            d�termine si le c'est un zoom in ou un zoom out.
	 */
	public void faireZoom(int x1, int x2, int y1, int y2) {
		// M�thode appel� quand on clique sur le bouton
		GestionnaireCommande.getInstance().setCommande(
				new CommandeZoom(x1, x2, y1, y2));
		GestionnaireCommande.getInstance().faireCommande();
	}

	/**
	 * Cette m�thode fait une annulation.
	 */
	public void annuler() {
		// On r�cup�re la derni�re image
		MementoImage mi = GestionnaireCommande.getInstance().getMementoImage();
		//On supprime l'image de l'arraylist en même temps
		GestionnaireCommande.getInstance().delMementoImage();
		// On cr�e la commande avec la derni�re image et on l'ajoute au
		// gestionnaire
		GestionnaireCommande.getInstance().setCommande(new CommandeAnnuler(mi));
		GestionnaireCommande.getInstance().faireCommande();
	}

	public void initialiser() {
		// On r�cup�re la premi�re image
		MementoImage mi = GestionnaireCommande.getInstance()
				.getMementoImageInitiale();
		// On cr�e la commande avec la premi�re image et on l'ajoute au
		// gestionnaire
		GestionnaireCommande.getInstance().setCommande(
				new CommandeInitialiser(mi));
		GestionnaireCommande.getInstance().faireCommande();
	}
	
	/**
	 * Cette méthode permet de sauvegarder l'état de l'objet dans un fichier
	 */
	public void sauvegarder(String chemin) {
		try {
			//On récupère le dernier MementoImage contenu dans l'arrayList du Gestionnaire
			MementoImage mi = GestionnaireCommande.getInstance().getMementoImage();
			//On enregistre à l'endroit souhaité et on ajoute l'extension .dat au fichier
			FileOutputStream fichier = new FileOutputStream(chemin+".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			//On enregistre l'objet
			oos.writeObject(mi);
			oos.flush();
			oos.close();
	    }
	    catch (java.io.IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Cette méthode restaurer l'image lorsque l'on ouvre un fichier sauvegardé
	 * @param mi
	 */
	public void restaurer(MementoImage mi) {
		Image img = mi.getState();
		//On modifie l'image pour qu'elle corresponde à ce qu'elle était quand on a enregistré
		faireTranslation(img.getX1(), img.getX2(), img.getY1(), img.getY2());
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

	public void creerImageInitiale(String path, int largeurOriginale,
			int hauteurOriginale) {
		GestionnaireCommande.getInstance().creerImageInitiale(path,
				largeurOriginale, hauteurOriginale);
		addMementoInitial();
	}

}
