package log121.tp3.controleur;

import log121.tp3.Image;
import log121.tp3.MementoImage;

/**
 * Classe du patron Commande représentant le receveur 
 * pour les commandes de traitement sur les images
 * @author Samuel Picard
 *
 */
public class Receveur {
	
	private ModeleVue mv;
	private Image i;
	private int largeurMax;
	private int hauteurMax;
	
	/**
	 * Constructeur du receveur du patron Commande
	 */
	public Receveur() {
		this.mv = Controleur.getInstance().getModeleVue();
	}
	
	/**
	 * Méthode qui exécute une translation sur une image
	 */
	public void executerTranslation(int x1, int x2, int y1, int y2) {
		i = mv.getImage();
		largeurMax = i.getLargeurOriginal();
		hauteurMax = i.getHauteurOriginale();
		
		translaterX(x1, x2);
		translaterY(y1, y2);
		mv.setImage(i);
	}
	
	/**
	 * Méthode qui exécute un zoom sur une image
	 */
	public void executerZoom(int x1, int x2, int y1, int y2) {
		i = mv.getImage();
		largeurMax = i.getLargeurOriginal();
		hauteurMax = i.getHauteurOriginale();
		
		// Test
		i.setX1(x1);
		i.setX2(x2);
		i.setY1(y1);
		i.setY2(y2);
		// Test
		
		mv.setImage(i);
	}
	
	/**
	 * Méthode qui annuler la commande précédente
	 */
	public void executerAnnuler(MementoImage mi) {
		//A FAIRE
	}
	
	public void translaterX(int x1, int x2) {
		
		int largeurActuelle = i.getX2() - i.getX1();
		
		if (!(verifierBornesX1(x1))) {
			i.setX1(0);
			i.setX2(largeurActuelle);
		}
		else if (!(verifierBornesX2(x2))) {
			i.setX2(largeurMax);
			i.setX1(largeurMax - largeurActuelle);
		}
		else {
			i.setX1(x1);
			i.setX2(x2);
		}
	}
	
	public void translaterY(int y1, int y2) {
		
		int hauteurActuelle = i.getY2() - i.getY1();
		
		if (!(verifierBornesY1(y1))) {
			i.setY1(0);
			i.setY2(hauteurActuelle);
		}
		else if (!(verifierBornesY2(y2))) {
		   i.setY2(hauteurMax);
		   i.setY1(hauteurMax - hauteurActuelle);
		}
		else {
			i.setY1(y1);
			i.setY2(y2);
		}
	}
	
	public boolean verifierBornesX1(int x1) {
		if (x1 > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifierBornesX2(int x2) {
		if (x2 < largeurMax) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifierBornesY1(int y1) {
		if (y1 > 0) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean verifierBornesY2(int y2) {
		if (y2 < hauteurMax) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		i = new Image(path, largeurOriginale, hauteurOriginale);
		mv.setImage(i);
	}
}
