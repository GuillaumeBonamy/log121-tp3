package log121.tp3;

import java.util.ArrayList;

import log121.tp3.controleur.Receveur;

public class GestionnaireCommande {
	private ArrayList<MementoImage> states;
	private Commande commande = null;
	private static GestionnaireCommande gc = null;
	private Receveur r = new Receveur();

	/**
	 * Permet de n'avoir qu'une seul objet GestionnaireCommande
	 * 
	 * @return instance du Gestionnaire
	 */
	public static GestionnaireCommande getInstance() {
		if (gc == null)
			gc = new GestionnaireCommande();

		return gc;
	}

	/**
	 * Cette méthode ajouter un memento.
	 */
	public void addMemento(MementoImage mi) {
		if (verifierImageModifiee(mi)) {
			states.add(mi);
		}
	}

	/**
	 * Cette méthode ajouter le premier memento.
	 */
	public void addMementoInitial(MementoImage mi) {
		states = new ArrayList<MementoImage>();
		states.add(mi);
	}

	/**
	 * Retourne le dernier MementoImage contenu dans l'ArrayList
	 */
	public MementoImage getMementoImage() {
		// On le supprime de l'ArrayList
		states.remove(states.size() - 1);

		// On sauvegarde le dernier élément
		MementoImage mi = states.get(states.size() - 1);

		// On renvoi l'élément
		return mi;
	}

	/**
	 * Cette fonction retourne le memento d'image initial.
	 * 
	 * @return le memento d'image initial.
	 */
	public MementoImage getMementoImageInitiale() {
		return states.get(0);
	}

	/**
	 * Ajoute une commande à l'arrayList pour pouvoir la traiter à la suite
	 * 
	 * @param cmd
	 *            commande de type CommandeTranslation ou CommandeZoom
	 */
	public void setCommande(Commande cmd) {
		commande = cmd;
	}

	/**
	 * Cette méthode execute la dernière commande
	 */
	public void faireCommande() {
		commande.executer();
	}

	public void creerImageInitiale(String path, int largeurOriginale,
			int hauteurOriginale) {
		r.creerImageInitiale(path, largeurOriginale, hauteurOriginale);
	}

	/**
	 * Cette fonction vérifie si la commande annuler peut être annulée.
	 * 
	 * @return si l'annulation est possible.
	 */
	public boolean verifierSiAnnulerPossible() {
		boolean verifierSiAnnulerPossible = true;

		if (states.size() == 1) {
			verifierSiAnnulerPossible = false;
		}
		return verifierSiAnnulerPossible;
	}

	private boolean verifierImageModifiee(MementoImage mi) {
		Image image1 = states.get(states.size() - 1).getState();
		Image image2 = mi.getState();
		boolean verifierImageModifiee = false;

		if (image1.getX1() != image2.getX1()) {
			verifierImageModifiee = true;
		} else if (image1.getX2() != image2.getX2()) {
			verifierImageModifiee = true;
		} else if (image1.getY1() != image2.getY1()) {
			verifierImageModifiee = true;
		} else if (image1.getY2() != image2.getY2()) {
			verifierImageModifiee = true;
		}
		return verifierImageModifiee;
	}
}
