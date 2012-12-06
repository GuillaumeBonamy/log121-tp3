package log121.tp3;

/** 
 * Classe du patron Commande permettant d'effectuer ou d'annuler une translation 
 * horizontale sur une image
 * @author Samuel Picard
 *
 */
public class CommandeTranslationVerticale extends Receveur implements Commande {
	
	/**
	 * Méthode qui appelle la méthode du receveur exécutant la
	 * translation verticale
	 */
	public void executer() {
		executerTranslationVerticale();	
	}
	
	/**
	 * Méthode qui annule la translation verticale à partir de l'état
	 * de l'image capturée avec le patron Memento
	 */
	public void annuler()
	{
		
	}
}
