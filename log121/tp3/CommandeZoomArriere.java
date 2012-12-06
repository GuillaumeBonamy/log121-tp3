/**
 * Classe du patron Commande permettant de faire ou défaire un zoom
 * arrière sur une image
 * @author Samuel Picard
 *
 */
public class CommandeZoomArriere extends Receveur implements Commande {
	
	/**
	 * Méthode qui appelle la méthode d'exécution du zoom arrière
	 * du receveur
	 */
	public void executer() {
		executerZoomArriere();
	}
	
	/**
	 * Méthode qui annule le zoom arrière à partir de l'état
	 * de l'image capturée avec le patron Memento
	 */
	public void annuler() {
		
	}
}
