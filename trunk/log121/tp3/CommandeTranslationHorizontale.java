/**
 * Classe du patron Commande permettant d'effectuer ou d'annuler une translation 
 * horizontale sur une image
 * @author Samuel Picard
 *
 */
public class CommandeTranslationHorizontale extends Receveur implements Commande{
	
	/**
	 * M�thode qui appelle la m�thode du receveur ex�cutant la
	 * translation horizontale
	 */
	public void executer() {
		executerTranslationHorizontale();
	}
	
	
	/**
	 * M�thode qui annule la translation horizontale � partir de l'�tat
	 * de l'image captur�e avec le patron Memento
	 */
	public void annuler() {
		
	}
}
