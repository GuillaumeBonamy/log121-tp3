/**
 * Classe du patron Commande permettant d'effectuer ou d'annuler une translation 
 * horizontale sur une image
 * @author Samuel Picard
 *
 */
public class CommandeTranslationHorizontale extends Receveur implements Commande{
	
	/**
	 * Méthode qui appelle la méthode du receveur exécutant la
	 * translation horizontale
	 */
	public void executer() {
		executerTranslationHorizontale();
	}
	
	
	/**
	 * Méthode qui annule la translation horizontale à partir de l'état
	 * de l'image capturée avec le patron Memento
	 */
	public void annuler() {
		
	}
}
