package log121.tp3;

/**
 * 
 * @author Samuel Picard
 * Interface Commande du patron Commande pour les zooms et les translations
 */
public interface Commande {
	
	/**
	 * Méthode qui définit la modification à effectuer sur l'image
	 */
	public void executer(int x1, int y1, int x2, int y2);
	
	/**
	 * Méthode qui définit annule la modification effectuée sur l'image
	 */
	public void annuler(MementoImage m);
}
