package log121.tp3.controleur;

import log121.tp3.Image;
import log121.tp3.MementoImage;

/**
 * Classe du patron Commande repr�sentant le receveur 
 * pour les commandes de traitement sur les images
 * @author Samuel Picard
 *
 */
public class Receveur {
	
	/**
	 * Instance de la classe ModeleVue
	 */
	private ModeleVue mv;
	
	/**
	 * Image ouverte par l'utilisateur
	 */
	private Image i;
	
	/**
	 * Largeur maximale possible de l'image
	 */
	private int largeurMax;
	
	/**
	 * Hauteur maximale de l'image
	 */
	private int hauteurMax;
	
	/**
	 * Constructeur du receveur du patron Commande
	 */
	public Receveur() {
		this.mv = Controleur.getInstance().getModeleVue();
	}
	
	/**
	 * M�thode qui ex�cute une translation verticale sur une image.
	 * Elle re�oit en param�tre les 4 nouvelles coordon�es souhait�es
	 * de l'image. 
	 * @param x1 Valeur X du premier point de l'image
	 * @param y1 Valeur Y du premier point de l'image
	 * @param x2 Valeur X du deuxi�me point de l'image
	 * @param y2 Valeur Y du deuxi�me point de l'image
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
	 * M�thode qui ex�cute un zoom sur une image.
	 * Elle re�oit en param�tre les 4 coordonn�es souhait�es
	 * de l'image.
	 * @param x1 Valeur X pour le premier point de l'image
	 * @param y1 Valeur Y pour le premier point de l'image
	 * @param x2 Valeur X pour le deuxi�me point de l'image
	 * @param y2 Valeur Y pour le deuxi�me point de l'image
	 */
	public void executerZoom(int x1, int x2, int y1, int y2) {
		i = mv.getImage();
		largeurMax = i.getLargeurOriginal();
		hauteurMax = i.getHauteurOriginale();
		
		zoomX(x1, x2);
		zoomY(y1, y2);
		mv.setImage(i);
	}
	

	/**
	 * M�thode qui ex�cute la translation sur les valeurs X.
	 * Elle re�oit en param�tre le Memento d'une image
	 * @param x1 Valeur X du premier point de l'image
	 * @param x2 Valeur X du deuxi�me point de l'image
	 */
	public void executerAnnuler(MementoImage mi) {
		mv.setImage(mi.getState());
	}
	
	/**
	 * M�thode qui effectue la translation sur les X.
	 * Elle re�oit en param�tre les coordon�es X souhait�es
	 * de l'image
	 * @param x1 Valeur X pour le premier point de l'image
	 * @param x2 Valeur X pour le deuxi�me point de l'image
	 */
	private void translaterX(int x1, int x2) {
		
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
	
	/**
	 * M�thode qui ex�cute une translation sur les valeurs Y.
	 * Elle re�oit en param�tre les coordonn�es Y souhait�es
	 * de l'image.
	 * @param y1 Valeur Y du premier point de l'image
	 * @param y2 Valeur Y du deuxi�me point de l'image
	 */
	private void translaterY(int y1, int y2) {
		
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
	
	/**
	 * M�thode qui effectue un zoom sur les coordon�es X des 
	 * 2 points de l'image. Elle recoit en param�tre les
	 * coordonn�es X souhait�es de l'image.
	 * @param x1 Coordonn�e X du premier point de l'image
	 * @param x2 Coordonn�e X du deuxi�me point de l'image
	 */
	private void zoomX(int x1, int x2) {
		
		if (x1 >= x2) {
			// On ne fait rien si les coordonn�es sont invers�es
		}
		else if (!(verifierBornesX1(x1))) {
			if (!verifierBornesX2(i.getX1() + i.getX2())) {
				i.setX2(i.getLargeurOriginal());
			} else {
				i.setX2(i.getX1() + i.getX2());
			}			
			i.setX1(0);
		}
		else if (!(verifierBornesX2(x2))) {
			i.setX1(i.getX1() - (i.getLargeurOriginal() - i.getX2()));
			i.setX2(i.getLargeurOriginal());
		}
		else {
			i.setX1(x1);
			i.setX2(x2);
		}
	}
	
	/**
	 * M�thode qui effectue un zoom sur les coordonn�es Y des 2 points de l'image.
	 * Elle re�oit en param�tre les coordonn�es Y souhait�es de l'image.
	 * @param y1 Coordonn�e Y du premier point de l'image
	 * @param y2 Coordonn�e Y du deuxi�me point de l'image
	 */
	private void zoomY(int y1, int y2) {
		
		if (y1 >= y2) {
			// On ne fait rien si les coordonn�es sont invers�es
		}
		else if (!(verifierBornesY1(y1))) {
			if (!verifierBornesY2(i.getY2() + i.getY1())) {
				i.setY2(i.getHauteurOriginale());
			} else {
				i.setY2(i.getY2() + i.getY1());
			}			
			i.setY1(0);
		}
		else if (!(verifierBornesY2(y2))) {
			i.setY1(i.getY1() - (i.getHauteurOriginale() - i.getY2()));
			i.setY2(i.getHauteurOriginale());
		}
		else {
			i.setY1(y1);
			i.setY2(y2);
		}
	}
	
	/**
	 * M�thode qui v�rifit les bornes X pour le premier point de l'image
	 * Elle re�oit en param�tre la borne x1 de l'image.
	 * @param x1 Valeur X du premier point de l'image
	 * @return Si les bornes sont valide ou non
	 */
	private boolean verifierBornesX1(int x1) {
		if (x1 > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�thode qui v�rifit les bornes X pour le deuxi�me point de l'image
	 * Elle re�oit en param�tre la borne x2 de l'image.
	 * @param x2 Valeur X du deuxi�me point de l'image
	 * @return Si les bornes sont valides ou non
	 */
	private boolean verifierBornesX2(int x2) {
		if (x2 < largeurMax) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�thode qui v�rifit les bornes Y du premier point de l'image
	 * Elle re�oit en param�tre la borne Y1 de l'image
	 * @param y1 La valeur Y du premier point de l'image
	 * @return Si les bornes sont valides ou non
	 */
	private boolean verifierBornesY1(int y1) {
		if (y1 > 0) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	/**
	 * M�thode qui v�rifit si les bornes Y du deuxi�me point de l'image sont valides 
	 * Elle re�oit en param�tre la borne y2 de l'image
	 * @param y2 
	 * @return Si les bornes sont valides ou non
	 */
	private boolean verifierBornesY2(int y2) {
		if (y2 < hauteurMax) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�thode qui cr�er l'image initiale s�lectionn�e par l'utilisateur
	 * Elle re�oit en param�tre le chemin d'acc�s de l'image et les
	 * 2 dimensions originales de l'image 
	 * @param path Chemin d'acc�s de l'image
	 * @param largeurOriginale Largeur de l'image initiale
	 * @param hauteurOriginale Hauteur de l'image initiale
	 */
	public void creerImageInitiale(String path, int largeurOriginale, int hauteurOriginale) {
		i = new Image(path, largeurOriginale, hauteurOriginale);
		mv.setImage(i);
	}
}
