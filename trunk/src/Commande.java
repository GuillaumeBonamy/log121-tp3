/**
 * 
 * @author Samuel Picard
 * Interface commande du patron commande pour les zooms et les translations
 */
public interface Commande {
	
	/**
	 * M�thode qui d�finit la modification � effectuer sur l'image
	 */
	public void executer();
}
