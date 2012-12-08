package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'exécuter ou d'annuler un zoom
 * avant sur une image
 * @author Samuel Picard
 *
 */
public class CommandeZoom extends Receveur implements Commande {
	
	/**
	 * Receveur de la commande de zoom avant
	 */
	private Receveur receveur;
	
	/**
	 * Les 4 coordonnées souhaitées de l'image
	 */
	private int x1, x2, y1, y2;
	
	/**
	 * Constructeur de la commande de zoom avant
	 */
	public CommandeZoom(int x1, int x2, int y1, int y2)  {
		this.receveur = new Receveur();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/**
	 * Méthode qui appelle la méthode d'exécution du zoom
	 * avant du receveur
	 */
	public void executer() {
		receveur.executerZoom(x1, x2, y1, y2);
	}
}
