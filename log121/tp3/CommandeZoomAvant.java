package log121.tp3;

/**
 * Classe du patron Commande permettant d'exécuter ou d'annuler un zoom
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
	 * Méthode qui appelle la méthode d'exécution du zoom
	 * avant du receveur
	 */
	public void executer() {
		receveur.executerZoomAvant();
	}
	
	/**
	 * Méthode qui annule le zoom avant à partir de l'état
	 * de l'image capturée avec le patron Memento
	 */
	public void annuler() {
		
	}
	
}
