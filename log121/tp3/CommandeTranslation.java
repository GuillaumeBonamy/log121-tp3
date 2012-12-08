package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'effectuer ou d'annuler une translation 
 * horizontale sur une image
 * @author Samuel Picard
 *
 */
public class CommandeTranslation implements Commande {
	/**
	 * Instance du receveur du patron Commande
	 */
	private Receveur receveur;
	
	/**
	 * Les 4 coordonn�es souhait�es de l'image
	 */
	private int x1, x2, y1, y2;
	
	/**
	 * Constructeur d'une commande de translation
	 * @param x1 Coordonn�e X du premier point de l'image
	 * @param x2 Coordonn�e X du deuxi�me point de l'image
	 * @param y1 Coordonn�e Y du premier point de l'image
	 * @param y2 Coordonn�e Y du deuxi�me point de l'image
	 */
	public CommandeTranslation(int x1, int x2, int y1, int y2) {
		this.receveur = new Receveur();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/**
	 * M�thode qui appelle la m�thode du receveur ex�cutant la
	 * translation
	 */
	public void executer() {
		receveur.executerTranslation(x1, x2, y1, y2);
	}
}
