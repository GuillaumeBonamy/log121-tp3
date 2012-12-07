package log121.tp3;

import java.util.ArrayList;

import log121.tp3.controleur.Receveur;

public class GestionnaireCommande {
	private ArrayList<MementoImage> states = new ArrayList<MementoImage>();
	private Commande commande = null;
	private static GestionnaireCommande gc = null;
	private Receveur r = new Receveur();
	
	/** 
	 * Permet de n'avoir qu'une seul objet GestionnaireCommande
	 * @return instance du Gestionnaire
	 */
	public static GestionnaireCommande getInstance() {
		if(gc == null)
			gc = new GestionnaireCommande();
		
		return gc;
	}
	
	/**
	 * Cette méthode ajouter un memento.
	 */
	public void addMemento(MementoImage mi) {
		states.add(mi);
	}

	/**
	 * Retourne le dernier MementoImage contenu dans l'ArrayList
	 */
	public MementoImage getMementoImage() {
		//On sauvegarde le dernier élément
		MementoImage mi = states.get(states.size()-1);
		//On le supprime de l'ArrayList
		states.remove(states.size()-1);
		//On renvoi l'élément
		return mi;
	}
	
	/**
	 * Ajoute une commande à l'arrayList pour pouvoir la traiter à la suite
	 * @param cmd commande de type CommandeTranslation ou CommandeZoom
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
	
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		r.creerImageInitiale(path, largeurOriginale, hauteurOriginale);
	}
	
}
