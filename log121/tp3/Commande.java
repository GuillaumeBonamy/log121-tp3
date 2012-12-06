/**
 * 
 * @author Samuel Picard
 * Interface Commande du patron Commande pour les zooms et les translations
 */
public interface Commande {
	
	/**
	 * M�thode qui d�finit la modification � effectuer sur l'image
	 */
	public void executer();
	
	/**
	 * M�thode qui d�finit annule la modification effectu�e sur l'image
	 */
	public void annuler();
}
