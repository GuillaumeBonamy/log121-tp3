/**
 * Classe du patron Commande permettant d'ex�cuter ou d'annuler un zoom
 * avant sur une image
 * @author Samuel Picard
 *
 */
public class CommandeZoomAvant extends Receveur implements Commande {
	
	/**
	 * Receveur de la commande de zoom avant
	 */
	private Receveur receveur;
	
	/**
	 * Constructeur de la commande de zoom avant
	 */
	public CommandeZoomAvant()  {
		this.receveur = new Receveur();
	}
	
	/**
	 * M�thode qui appelle la m�thode d'ex�cution du zoom
	 * avant du receveur
	 */
	public void executer() {
		receveur.executerZoomAvant();
	}
	
	/**
	 * M�thode qui annule le zoom avant � partir de l'�tat
	 * de l'image captur�e avec le patron Memento
	 */
	public void annuler() {
		
	}
	
}
