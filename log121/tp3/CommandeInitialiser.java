package log121.tp3;

import log121.tp3.controleur.Receveur;

public class CommandeInitialiser implements Commande {

	/**
	 * Instance du receveur du patron Commande
	 */
	private Receveur receveur;
	
	/**
	 * Memento contenant l'état d'une image
	 */
	private MementoImage mi;
	
	/**
	 * Constructeur de la commande d'annulation d'opération
	 */
	public CommandeInitialiser(MementoImage mi)  {
		this.receveur = new Receveur();
		this.mi = mi;
	}
	
	/**
	 * Méthode qui appelle la méthode d'annulation du receveur
	 */
	public void executer() {
		receveur.executerInitialiser(mi);
	}
}
