/**
 * 
 * @author Samuel Picard
 * Interface commande du patron commande pour les zooms et les translations
 */
public interface Commande {
	
	/**
	 * Méthode qui définit la modification à effectuer sur l'image
	 */
	public void executer();
}
