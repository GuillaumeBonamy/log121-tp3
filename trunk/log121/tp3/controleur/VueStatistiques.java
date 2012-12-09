package log121.tp3.controleur;

import java.awt.GridLayout;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import log121.tp3.Image;


public class VueStatistiques extends JFrame implements Observer {
        
        private JPanel panel;
        private JTextField tf;
        private JSlider slider;
        private Image img, imgTemp;
        private final int FACTEUR_ZOOM=25;
        private int compteurZoomEffectue=0;
        
        private void modifierStatistiques() {
                tf.setText("x1:"+img.getX1()+ " x2: "+img.getX2()+"\ny1: "+img.getY1()+" y2: "+img.getY2());
                slider.setValue(img.getZoom());
        }
        

        /**
         * Constructeur de la classe VueStatistiques
         * @param img L'image dont on doit afficher les statistiques
         */
        public VueStatistiques()
        {
                setTitle("Vue statistique");
                setLocation(850,450);
                setSize(600,250);
        
                img = Controleur.getInstance().getImageModeleVue();
                
                panel=new JPanel(new GridLayout(1,2));
               
                slider = ajouterSlider();
                slider.setEnabled(false);
                
                tf=new JTextField("");
               
                modifierStatistiques();
                
                panel.add(slider);
                panel.add(tf);
                
                this.add(panel);
        }
        
        private JSlider ajouterSlider()
        {
                slider = new JSlider(SwingConstants.HORIZONTAL,0,img.getNbZoom()*FACTEUR_ZOOM,0); // Debute a 0, finit a 325, valeur initiale a 0.
                slider.setMajorTickSpacing(25); // Afficher les tirets tous les 25 pixels
                slider.setPaintTicks(true); // Afficher les tirets
                
                Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
                        
                labelTable.put(new Integer( 0 ), new JLabel("Zoom normal") );                     
                labelTable.put(new Integer( img.getNbZoom()*FACTEUR_ZOOM ),  new JLabel("Zoom max") );
                                  
                slider.setLabelTable(labelTable);
                slider.setPaintLabels(true);
                
                return slider;
        }
        
        
        public void modifierZoom(Image imgTemp, Image img)
        {
        	//si l'image est plus haute que large
        	if(img.getLargeurOriginal() <= img.getHauteurOriginale()) {
        		//si on zoom on incrémente le compteur de zoom
	        	if(compteurZoomEffectue >= 0 &&compteurZoomEffectue < imgTemp.getNbZoom() && imgTemp.getY1() < img.getY1())
	        	{
	        		compteurZoomEffectue++;
	        		
	        	}
	        	//si on dézoome on décrémente le compteur de zoom
	        	else if(compteurZoomEffectue > 0 && compteurZoomEffectue <= imgTemp.getNbZoom() && imgTemp.getY1() > img.getY1())
	        	{
	        		compteurZoomEffectue--;
	        	}
        	}
        	else {
        		//si on zoome on incrémente le compteur de zoom
        		if(compteurZoomEffectue >= 0 &&compteurZoomEffectue < imgTemp.getNbZoom() && imgTemp.getX1() < img.getX1())
	        	{
	        		compteurZoomEffectue++;
	        		
	        	}
        		//si on dézoome on décrémente le compteur de zoom
	        	else if(compteurZoomEffectue > 0 && compteurZoomEffectue <= imgTemp.getNbZoom() && imgTemp.getX1() > img.getX1())
	        	{
	        		compteurZoomEffectue--;
	        	}
        	}
        		
        	//on multiplie le compteur de zoom par le facteur de zoom, pour savoir quel est le zoom actuelle
        	img.setZoom(compteurZoomEffectue*FACTEUR_ZOOM);
        	//on modifie le nbZoom de l'image  actuel pour ne pas perdre la donnée
        	img.setNbZoom(imgTemp.getNbZoom());	
        }
        /**
         * Methode servant à vérifier si l'image a été dézoomée ou zoomée ou aucun des deux
         * @param imgTemp l'image précédente
         * @param img l'image actuelle
         */
        public void verifierZoom(Image imgTemp, Image img)
        {
        	if(img.getX1() > imgTemp.getX1() && img.getX2() < imgTemp.getX2() && img.getY1() > imgTemp.getY1() && img.getY2() < imgTemp.getY2())
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else if(img.getX1() < imgTemp.getX1() && img.getX2() > imgTemp.getX2() && img.getY1() < imgTemp.getY1() && img.getY2() > imgTemp.getY2())
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else if(img.getX1() == imgTemp.getX1() && img.getX2() == imgTemp.getX2() && img.getY1() > imgTemp.getY1() && img.getY2() < imgTemp.getY2())
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else if(img.getX1() == imgTemp.getX1() && img.getX2() == imgTemp.getX2() && img.getY1() < imgTemp.getY1() && img.getY2() > imgTemp.getY2() )
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else if(img.getX1() < imgTemp.getX1() && img.getX2() > imgTemp.getX2() && img.getY1() == imgTemp.getY1() && img.getY2() == imgTemp.getY2())
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else if(img.getX1() > imgTemp.getX1() && img.getX2() < imgTemp.getX2() && img.getY1() == imgTemp.getY1() && img.getY2() == imgTemp.getY2() )
        	{
        		modifierZoom(imgTemp, img);
        		
        	}
        	else
        	{
        		img.setZoom(compteurZoomEffectue*FACTEUR_ZOOM);
        		img.setNbZoom(imgTemp.getNbZoom());	
        	}
        	
        }
        
        /**
         * 
         */
         public void update(Observable arg0, Object arg1) {
        	 	 this.imgTemp=img;
                 img = Controleur.getInstance().getImageModeleVue();
                 verifierZoom(imgTemp,img);
                 modifierStatistiques();
         }
}