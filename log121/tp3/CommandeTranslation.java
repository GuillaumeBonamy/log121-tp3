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
	
	public CommandeTranslation() {
		this.receveur = new Receveur();
	}
	
	/**
	 * Méthode qui appelle la méthode du receveur exécutant la
	 * translation horizontale
	 */
	public void executer(int x1, int y1, int x2, int y2) {
		receveur.executerTranslation(x1, y1, x2, y2);
	}
	
	
	/**
	 * Méthode qui annule la translation horizontale à partir de l'état
	 * de l'image capturée avec le patron Memento
	 */
	public void annuler(MementoImage m) {
		
	}
}
