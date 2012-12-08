package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'annuler une opération
 * sur une image
 * @author Samuel Picard
 *
 */
public class CommandeAnnuler implements Commande {
	
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
	public CommandeAnnuler(MementoImage mi)  {
		this.receveur = new Receveur();
		this.mi = mi;
	}
	
	/**
	 * Méthode qui appelle la méthode d'annulation du receveur
	 */
	public void executer() {
		receveur.executerAnnuler(mi);
	}
}
