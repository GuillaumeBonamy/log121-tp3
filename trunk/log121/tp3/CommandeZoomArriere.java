/**
 * Classe du patron Commande permettant de faire ou d�faire un zoom
 * arri�re sur une image
 * @author Samuel Picard
 *
 */
public class CommandeZoomArriere extends Receveur implements Commande {
	
	/**
	 * M�thode qui appelle la m�thode d'ex�cution du zoom arri�re
	 * du receveur
	 */
	public void executer() {
		executerZoomArriere();
	}
	
	/**
	 * M�thode qui annule le zoom arri�re � partir de l'�tat
	 * de l'image captur�e avec le patron Memento
	 */
	public void annuler() {
		
	}
}
