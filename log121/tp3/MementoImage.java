package log121.tp3;

import java.io.Serializable;
import java.util.ArrayList;


public class MementoImage implements Serializable{
	
	private Image state;
	
	/**
	 * Constructeur de la classe MementoImage
	 * @param state l'Image du memento
	 */
	public MementoImage(Image state)
	{
		this.state = state;
	}
	
	/**
	 * @return l'Image du memento
	 */
	public Image getState()
	{
		return state;
	}
	

}
