package log121.tp3;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Image implements Cloneable, Serializable {

        private int x1, x2, y1, y2;
        private int largeurOriginale, hauteurOriginale;
        private String cheminImage;
        private int zoom;
        private final int FACTEUR_ZOOM = 25;
        private int nbZoom;
        
        private final double RAPPORT_DE_ZOOM=2.155;
        //2.155 a été trouvé en faisant la moyenne sur 5 images de la taille diviser par le nombre de zoom trouvé manuellement.
        
        /**
         * Constructeur de la classe Image
         * 
         * @param cheminImage
         *            L'emplacement de l'image
         */
        public Image(String cheminImage, int largeurOriginale, int hauteurOriginale) {
                this.cheminImage = cheminImage;
                this.largeurOriginale = largeurOriginale;
                this.hauteurOriginale = hauteurOriginale;
                this.x2 = largeurOriginale;
                this.y2 = hauteurOriginale;
                this.zoom=0;
                calculerZoomMax();
        }

        
        /**
         * Methode permettant de calculer le nombre de fois que l'on pourra zoomer
         */
        public void calculerZoomMax()
        {
        	
        	double zoomDouble;
        	//Si l'image est plus haute que large
			if(this.largeurOriginale < this.hauteurOriginale) {
				
					zoomDouble = ((this.hauteurOriginale/RAPPORT_DE_ZOOM)/FACTEUR_ZOOM);
				
			} else {
        		
        			zoomDouble = (this.largeurOriginale/RAPPORT_DE_ZOOM)/FACTEUR_ZOOM;
				
			}
        	
        	DecimalFormat df = new DecimalFormat () ; 
    		df.setMaximumFractionDigits (0); //arrondi le chiffre
    		df.setMinimumFractionDigits (0); 
    		 
    		this.nbZoom=Integer.parseInt(df.format(zoomDouble));

        }
        
        /**
         * Methode modifiant le nombre de zoom max de l'image
         * @param nbZoom le nouveau nombre de zoom
         */
        public void setNbZoom(int nbZoom) {
			this.nbZoom=nbZoom;
        }
		
        /**
         * @return le nombre de zoom max sur l'image
         */
        public int getNbZoom()
        {
        	return nbZoom;
        }
        /**
         * @return le zoom de l'image
         */
        public int getZoom() { return zoom;}
        
        /**
         * Modifie le zoom de l'image
         * @param newZoom le nombre a ajouté pour avoir le nouveau zoom
         */
        public void setZoom(int newZoom) { this.zoom = newZoom; }
        
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
         * Cette fonction retourne un clone d'une image.
         * @return
         */
        public Image getclone() {
                Image i = null;
                
                try {
                        i = (Image) this.clone();
                } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                }
                return i;
        }
}