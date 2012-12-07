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
	private Image img;
	
	private void modifierStatistiques() {
		tf.setText("x1:"+img.getX1()+ " x2: "+img.getX2()+"\ny1: "+img.getY1()+" y2: "+img.getY2());
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
		panel.add(slider);
		tf=new JTextField("");
		modifierStatistiques();
		panel.add(tf);
		
		this.add(panel);
	}
	
	private JSlider ajouterSlider()
	{
		slider = new JSlider(SwingConstants.HORIZONTAL,-100,100,0); // Debute a -100, finit a 100, valeur initiale a 0.
		slider.setMajorTickSpacing(10); // Afficher les tirets tous les 10 pixels
		slider.setPaintTicks(true); // Afficher les tirets
		
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		        
		labelTable.put(new Integer( 0 ), new JLabel("Zoom normal") );         
		labelTable.put(new Integer(-100), new JLabel("Zoom min") );               
		labelTable.put(new Integer( 100 ),  new JLabel("Zoom max") );
		                  
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);
		
		return slider;
	}
	
	/**
	 * 
	 */
	 public void update(Observable obs, Object obj) {
		 img = Controleur.getInstance().getImageModeleVue();
		 modifierStatistiques();
	 }
}
