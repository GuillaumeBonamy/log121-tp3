package log121.tp3.controleur;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import log121.tp3.GestionnaireCommande;
import log121.tp3.Image;

public class VueImageModifie extends JFrame implements ActionListener,
                MouseWheelListener, MouseMotionListener, MouseListener, Observer {

        private JMenuBar menuBar;
        private JMenu menuAction;
        private JMenuItem translationHaut;
        private JMenuItem translationBas;
        private JMenuItem translationDroite;
        private JMenuItem translationGauche;
        private JMenuItem zoomIn;
        private JMenuItem zoomOut;
        private JPanel panelImage;
        private JLabel labelImage;
        private ImageIcon iconeImage;
        private Image img;
        private int clickX;
        private int clickY;
     
        
        private final int DEPLACEMENT = 50;
        private final int FACTEUR_ZOOM = 25;

        /**
         * Cette fonction dessine une image et retourne un icone correspondant à
         * l'image.
         * 
         * @return l'icon de l'image.
         */
        private ImageIcon dessinerIconeImage() {
                int type = BufferedImage.TYPE_INT_RGB;

                BufferedImage bi = new BufferedImage(img.getLargeurOriginal(),
                                img.getHauteurOriginale(), type);
                Graphics2D g2 = bi.createGraphics();

                g2.drawImage(iconeImage.getImage(), 0, 0, img.getLargeurOriginal(),
                                img.getHauteurOriginale(), img.getX1(), img.getY1(),
                                img.getX2(), img.getY2(), this);

                return new ImageIcon(bi);
        }

        /**
         * Constructeur de la classe VueImageModifie
         * 
         * @param img
         *            L'image a affiche dans la fenetre
         */
        public VueImageModifie() {
                setTitle("Vue image modifie");
                setLocation(450, 450);
                setSize(400, 400);

                
                creerMenu();

                this.img = Controleur.getInstance().getImageModeleVue();
                iconeImage = new ImageIcon(img.getCheminImage());

                this.panelImage = new JPanel();
                this.labelImage = new JLabel(dessinerIconeImage());
                labelImage.addMouseWheelListener(this);
                labelImage.addMouseMotionListener(this);
                labelImage.addMouseListener(this);

                this.panelImage.add(labelImage);

                
                this.add(panelImage);
        }

        /**
         * Methode permettant de creer le menu de la fenetre
         */
        private void creerMenu() {
                menuBar = new JMenuBar();

                menuAction = new JMenu("Action");
                translationBas = new JMenuItem("Translation en bas");
                translationDroite = new JMenuItem("Translation à droite");
                translationGauche = new JMenuItem("Translation à gauche");
                translationHaut = new JMenuItem("Translation en haut");
                zoomIn = new JMenuItem("Zoom In");
                zoomOut = new JMenuItem("Zoom Out");

                menuAction.add(translationBas);
                translationBas.addActionListener(this);

                menuAction.add(translationDroite);
                translationDroite.addActionListener(this);

                menuAction.add(translationGauche);
                translationGauche.addActionListener(this);

                menuAction.add(translationHaut);
                translationHaut.addActionListener(this);

                menuAction.add(zoomIn);
                zoomIn.addActionListener(this);

                menuAction.add(zoomOut);
                zoomOut.addActionListener(this);

                menuBar.add(menuAction);

                this.setJMenuBar(menuBar);
        }

        /**
         * Methode permettant de gerer les actions sur les items
         */
        public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == translationBas) {
                        Controleur.getInstance().faireTranslation(img.getX1(), img.getX2(), 
                                        img.getY1() + DEPLACEMENT, img.getY2()+ DEPLACEMENT);
                        
                } else if (e.getSource() == translationDroite) {
                        Controleur.getInstance().faireTranslation(img.getX1() + DEPLACEMENT, img.getX2() + DEPLACEMENT, 
                                        img.getY1(), img.getY2());
                        
                } else if (e.getSource() == translationGauche) {
                        Controleur.getInstance().faireTranslation(img.getX1() - DEPLACEMENT, img.getX2() - DEPLACEMENT, 
                                        img.getY1(), img.getY2());
                        
                } else if (e.getSource() == translationHaut) {
                        Controleur.getInstance().faireTranslation(img.getX1(), img.getX2(), 
                                        img.getY1() - DEPLACEMENT, img.getY2() - DEPLACEMENT);
                        
                } else if (e.getSource() == zoomIn) {
                	
                        Controleur.getInstance().faireZoom(img.getX1() + FACTEUR_ZOOM, img.getX2() - FACTEUR_ZOOM, 
                                        img.getY1() + FACTEUR_ZOOM, img.getY2() - FACTEUR_ZOOM);
                        
                } else if (e.getSource() == zoomOut) {
                	
                    Controleur.getInstance().faireZoom(img.getX1() - FACTEUR_ZOOM, img.getX2() + FACTEUR_ZOOM, 
                                        img.getY1() - FACTEUR_ZOOM, img.getY2() + FACTEUR_ZOOM);

                }
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() < 0) {
                	
                        Controleur.getInstance().faireZoom(img.getX1() + FACTEUR_ZOOM, img.getX2() - FACTEUR_ZOOM, 
                                        img.getY1() + FACTEUR_ZOOM, img.getY2() - FACTEUR_ZOOM);
                        
                	   
                } else {
                    Controleur.getInstance().faireZoom(img.getX1() - FACTEUR_ZOOM, img.getX2() + FACTEUR_ZOOM, 
                                        img.getY1() - FACTEUR_ZOOM, img.getY2() + FACTEUR_ZOOM);
   
                }
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {                
                Controleur.getInstance().faireTranslation(img.getX1() - (e.getX() - clickX), img.getX2() - (e.getX() - clickX), 
                                img.getY1() - (e.getY() - clickY), img.getY2() - (e.getY() - clickY));
                
                clickX = e.getX();
                clickY = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mousePressed(MouseEvent e) {
                clickX = e.getX();
                clickY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
        }
        
        // TEST

        public void update(Observable obs, Object obj) {
                img = Controleur.getInstance().getImageModeleVue();
                labelImage.setIcon(dessinerIconeImage());
        }
}
