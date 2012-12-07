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
	public void executer(int x1, int y1, int x2, int y2);
	
	/**
	 * M�thode qui d�finit annule la modification effectu�e sur l'image
	 */
	public void annuler(MementoImage m);
}
