package log121.tp3;

public class Image {

	private int x1, x2, y1, y2;
	private int largeurOriginale, hauteurOriginale;
	private String cheminImage;

	/**
	 * Constructeur de la classe Image
	 * 
	 * @param cheminImage
	 *            L'emplacement de l'image
	 */
	public Image(String cheminImage) {
		this.cheminImage = cheminImage;
	}

	/**
	 * @return L'emplacement de l'image
	 */
	public String getCheminImage() {
		return cheminImage;
	}

	/** @return La coordonnee x1 de l'image */
	public int getX1() {
		return x1;
	}

	/** @return La coordonnee y2 de l'image */
	public int getY2() {
		return y2;
	}

	/** @return La coordonnee x2 de l'image */
	public int getX2() {
		return x2;
	}

	/** @return La coordonnee y1 de l'image */
	public int getY1() {
		return y1;
	}
	
	/** @return La largeur originale de l'image */
	public int getLargeurOriginal() {
		return largeurOriginale;
	}

	/** @return La la heuteur originale de l'image */
	public int getHauteurOriginale() {
		return hauteurOriginale;
	}

	/**
	 * Modifie la coordonnee x1 de l'image
	 * 
	 * @param x1
	 *            La nouvelle coordonnee
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}

	/**
	 * Modifie la coordonnee x2 de l'image
	 * 
	 * @param x2
	 *            La nouvelle coordonnee
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}

	/**
	 * Modifie la coordonnee y1 de l'image
	 * 
	 * @param y1
	 *            La nouvelle coordonnee
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}

	/**
	 * Modifie la coordonnee y2 de l'image
	 * 
	 * @param y2
	 *            La nouvelle coordonnee
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	/**
	 * Modifie la coordonnee y1 de l'image
	 * 
	 * @param y1
	 *            La nouvelle coordonnee
	 */
	public void setLargeurOriginal(int largeurOriginale) {
		this.largeurOriginale = largeurOriginale;
	}

	/**
	 * Modifie la coordonnee y2 de l'image
	 * 
	 * @param y2
	 *            La nouvelle coordonnee
	 */
	public void setHauteurOriginale(int hauteurOriginale) {
		this.hauteurOriginale = hauteurOriginale;
	}
}
