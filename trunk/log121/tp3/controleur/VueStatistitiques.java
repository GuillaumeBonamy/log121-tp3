import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VueStatistiques extends JFrame implements Observer {
	
	private JPanel panel;
	private JTextField tf;
	
	/**
	 * Constructeur de la classe VueStatistiques
	 * @param img L'image dont on doit afficher les statistiques
	 */
	public VueStatistiques(Image img)
	{
		setTitle("Vue statistique");
		setLocation(850,450);
		setSize(200,200);
	
		panel=new JPanel(new GridLayout(1,2));
		tf=new JTextField("x1:"+img.getX1()+ " x2: "+img.getX2()+"\ny1: "+img.getY1()+" y2: "+img.getY2());
		panel.add(tf);
		
		this.add(panel);
		
		setVisible(true);
	}
	
	/**
	 * 
	 */
	 public void update(Observable arg0, Object arg1) {
         // TODO Auto-generated method stub
         
	 }
}
