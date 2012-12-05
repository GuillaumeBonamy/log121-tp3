package log121.tp3.controleur;

import java.util.Observable;

import log121.tp3.Image;

/**
 * Cette classe garde les informations sur une image de la vue. Elle a aussi la
 * responsabilité de notifer les observeurs lorsqu'il y a un changement dans le
 * modèle.
 * 
 * @author James
 * 
 */
public class ModeleVue extends Observable {
	private Image i;

	/**
	 * Cette méthode met une image dans la vue du modèle.
	 * @param i
	 */
	void setImage(Image i) {
		this.i = i;
		setChanged();
		notifyObservers();
	}

	/**
	 * Cette fonction retourne l'image dans la vue du modèle.
	 * @return
	 */
	Image getImage() {
		return i.getclone();
	}
}
