package log121.tp3;

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
}
