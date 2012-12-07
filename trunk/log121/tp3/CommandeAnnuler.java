package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'exécuter ou d'annuler un zoom
 * avant sur une image
 * @author Samuel Picard
 *
 */
public class CommandeAnnuler extends Receveur implements Commande {
	
	/**
	 * Receveur de la commande de zoom avant
	 */
	private Receveur receveur;
	private MementoImage mi;
	
	/**
	 * Constructeur de la commande de zoom avant
	 */
	public CommandeAnnuler(MementoImage mi)  {
		this.receveur = new Receveur();
		this.mi = mi;
	}
	
	/**
	 * Méthode qui appelle la méthode d'exécution du zoom
	 * avant du receveur
	 */
	public void executer() {
		receveur.executerAnnuler(mi);
	}
}
