package log121.tp3.controleur;

import java.util.Observable;

import log121.tp3.Image;

/**
 * Cette classe garde les informations sur une image de la vue. Elle a aussi la
 * responsabilit� de notifer les observeurs lorsqu'il y a un changement dans le
 * mod�le.
 * 
 * @author James
 * 
 */
public class ModeleVue extends Observable {
	private Image i;

	/**
	 * Cette m�thode met une image dans la vue du mod�le.
	 * @param i
	 */
	void setImage(Image i) {
		this.i = i;
		setChanged();
		notifyObservers();
	}

	/**
	 * Cette fonction retourne l'image dans la vue du mod�le.
	 * @return
	 */
	Image getImage() {
		return i.getclone();
	}
}
