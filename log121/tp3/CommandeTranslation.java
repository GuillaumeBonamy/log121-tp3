package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'effectuer ou d'annuler une translation 
 * horizontale sur une image
 * @author Samuel Picard
 *
 */
public class CommandeTranslation implements Commande {
	
	private Receveur receveur;
	private int x1, x2, y1, y2;
	
	public CommandeTranslation(int x1, int x2, int y1, int y2) {
		this.receveur = new Receveur();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/**
	 * Méthode qui appelle la méthode du receveur exécutant la
	 * translation horizontale
	 */
	public void executer() {
		receveur.executerTranslation(x1, x2, y1, y2);
	}
}
