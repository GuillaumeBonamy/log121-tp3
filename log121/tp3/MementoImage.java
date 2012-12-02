import java.util.ArrayList;


public class MementoImage {
	
	private Image state;
	
	/**
	 * Constructeur de la classe MementoImage
	 * @param state l'Image du memento
	 */
	public MementoImage(Image state)
	{
		this.state=state;
	}
	
	/**
	 * @return l'Image du memento
	 */
	public Image getState()
	{
		return state;
	}
	

}
