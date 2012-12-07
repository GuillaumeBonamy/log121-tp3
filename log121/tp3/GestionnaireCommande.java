package log121.tp3;

import java.util.ArrayList;

import log121.tp3.controleur.Receveur;

public class GestionnaireCommande {
	private ArrayList<MementoImage> states = new ArrayList<MementoImage>();
	private ArrayList<Commande> commandes = new ArrayList<Commande>();
	private static GestionnaireCommande gc = null;
	private int nbAnnuler = 0;
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
		return states.get(states.size()-1-nbAnnuler);
	}
	
	/**
	 * Retourne le N ième MementoImage contenu dans l'ArrayList
	 */
	public MementoImage getMementoImage(int i) {
		return states.get(i);
	}
	
	/**
	 * Ajoute une commande à l'arrayList pour pouvoir la traiter à la suite
	 * @param cmd commande de type CommandeTranslation ou CommandeZoom
	 */
	public void ajouterCommande(Commande cmd) {
		commandes.add(cmd);
	}
	
	/**
	 * Cette méthode execute la dernière commande
	 */
	//public void faire() {
		//commandes.get(commandes.size()-1).executer();
		//nbAnnuler = 0; //Dès qu'une action est effectuée, on repartira de la fin pour annuler els action
	//}

	public void faireTranslation(int x1, int y1, int x2, int y2) {
		commandes.get(commandes.size()-1).executer(x1, y1, x2, y2);
		nbAnnuler = 0; //Dès qu'une action est effectuée, on repartira de la fin pour annuler els action
	}
	
	public void faireZoom(int x1, int y1, int x2, int y2) {
		commandes.get(commandes.size()-1).executer(x1, y1, x2, y2);
		nbAnnuler = 0; //Dès qu'une action est effectuée, on repartira de la fin pour annuler els action
	}
	
	/**
	 * Cette méthode annule la dernière commande
	 */
	public void annuler() {
		//Si on clique 1 fois , on annuler la dernière commande, 2 cliques de suites et on annule l'avant dernier, 3 cliques et 3ème de la fin annulé...
		//commandes.get(commandes.size()-1-nbAnnuler).annuler();
		nbAnnuler++;
	}
	
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		r.creerImageInitiale(path, largeurOriginale, hauteurOriginale);
	}
	
}
