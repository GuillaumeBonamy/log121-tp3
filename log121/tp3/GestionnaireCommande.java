package log121.tp3;

import java.util.ArrayList;

public class GestionnaireCommande {
	private ArrayList<MementoImage> states = new ArrayList<MementoImage>();
	private ArrayList<Commande> commandes = new ArrayList<Commande>();
	private static GestionnaireCommande gc = null;
	private int nbAnnuler = 0;
	
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
	 * Cette m�thode ajouter un memento.
	 */
	public void addMemento(MementoImage mi) {
		states.add(mi);
	}

	/**
	 * Retourne le dernier MementoImage contenu dans l'ArrayList
	 */
	public MementoImage getMementoImage() {
		return states.get(states.size()-1-nbAnnuler);
	}
	
	/**
	 * Retourne le N i�me MementoImage contenu dans l'ArrayList
	 */
	public MementoImage getMementoImage(int i) {
		return states.get(i);
	}
	
	/**
	 * Ajoute une commande � l'arrayList pour pouvoir la traiter � la suite
	 * @param cmd commande de type CommandeTranslation ou CommandeZoom
	 */
	public void ajouterCommande(Commande cmd) {
		commandes.add(cmd);
	}
	
	/**
	 * Cette m�thode execute la derni�re commande
	 */
	public void faire() {
		commandes.get(commandes.size()-1).executer();
		nbAnnuler = 0; //D�s qu'une action est effectu�e, on repartira de la fin pour annuler els action
	}

	/**
	 * Cette m�thode annule la derni�re commande
	 */
	public void annuler() {
		//Si on clique 1 fois , on annuler la derni�re commande, 2 cliques de suites et on annule l'avant dernier, 3 cliques et 3�me de la fin annul�...
		commandes.get(commandes.size()-1-nbAnnuler).annuler();
		nbAnnuler++;
	}
}
