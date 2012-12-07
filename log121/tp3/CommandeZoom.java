package log121.tp3;

import log121.tp3.controleur.Receveur;

/**
 * Classe du patron Commande permettant d'ex�cuter ou d'annuler un zoom
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
	 * Constructeur de la commande de zoom avant
	 */
	public CommandeZoom()  {
		this.receveur = new Receveur();
	}
	
	/**
	 * M�thode qui appelle la m�thode d'ex�cution du zoom
	 * avant du receveur
	 */
	public void executer(int x1, int y1, int x2, int y2) {
		receveur.executerZoom(x1, y1, x2, y2);
	}
	
	/**
	 * M�thode qui annule le zoom avant � partir de l'�tat
	 * de l'image captur�e avec le patron Memento
	 */
	public void annuler(MementoImage m) {
		
	}
	
}
