package log121.tp3;

import log121.tp3.controleur.Receveur;

public class CommandeInitialiser implements Commande {

	/**
	 * Instance du receveur du patron Commande
	 */
	private Receveur receveur;
	
	/**
	 * Memento contenant l'�tat d'une image
	 */
	private MementoImage mi;
	
	/**
	 * Constructeur de la commande d'annulation d'op�ration
	 */
	public CommandeInitialiser(MementoImage mi)  {
		this.receveur = new Receveur();
		this.mi = mi;
	}
	
	/**
	 * M�thode qui appelle la m�thode d'annulation du receveur
	 */
	public void executer() {
		receveur.executerInitialiser(mi);
	}
}
