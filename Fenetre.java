import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MenuContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import javax.swing.JColorChooser;
import javax.accessibility.Accessible;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;

/**
 * Cette classe déclare l'interface utilisateur 
 * et la méthode main pour executer le programme 
 * @author Morgane
 *
 */
public class Fenetre {
	
	private DessinFigures dessin;
	private Color couleur;
	private JComboBox figure;

	
	public Fenetre(){
		
		/** creation de la fenetre globale **/
		JFrame fenetre=new JFrame("Programme de dessin");
		final JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		PanneauChoix pc = new PanneauChoix();
		
		dessin=new DessinFigures();
		dessin.setPreferredSize(new Dimension(600,500));
		fenetre.setContentPane(content);
		content.add(pc, BorderLayout.NORTH);
		content.add(dessin, BorderLayout.CENTER);
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		JPanel choix = new PanneauChoix();
		
		
	}
	
	
	
	/* *******************************************************
	 * *************** classe interne ***********************
	 ******************************************************* */
	
	private class PanneauChoix extends JPanel{
		
		/**
		 * la figure à construire
		 */
		private FigureColoree fc;
		
		/**
		 * attribut supplémentaire afin de mémoriser la couleur sélectionnée
		 * dans le menu déroulant 
		 */
		private Color couleurSelect = Color.BLACK;
		
		/**
		 * constructeur
		 */
		
		public PanneauChoix(){
			final JRadioButton shape = new JRadioButton("Nouvelle figure");		
			final JRadioButton draw = new JRadioButton("Tracé à main levée");
			final JRadioButton move = new JRadioButton("Manipulations");
			final JRadioButton erase = new JRadioButton("Effacer");
			ButtonGroup group = new ButtonGroup();
			group.add(shape);
			group.add(draw);
			group.add(move);
			group.add(erase);
			
			
			final JComboBox couleurs = new JComboBox(new String[]{"Noir","Rouge","Vert","Bleu","Jaune","Rose", "Orange", 
					"Magenta","Gris","Cyan", "Blanc"});
			couleurs.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e2){
					FigureColoree f = dessin.figureSelection();
					switch(couleurs.getSelectedIndex()){
						case 0 :
							f.changeCouleur(Color.BLACK);
							couleurSelect = Color.BLACK;
							break;
						case 1 :
							f.changeCouleur(Color.RED);
							couleurSelect = Color.RED;
							break;
						case 2 :
							f.changeCouleur(Color.GREEN);
							couleurSelect = Color.GREEN;
							break;
						case 3 :
							f.changeCouleur(Color.BLUE);
							couleurSelect = Color.BLUE;
							break;
						case 4 :
							f.changeCouleur(Color.YELLOW);
							couleurSelect = Color.YELLOW;
							break;	
						case 5 :
							f.changeCouleur(Color.PINK);
							couleurSelect = Color.PINK;
							break;
						case 6 :
							f.changeCouleur(Color.ORANGE);
							couleurSelect = Color.ORANGE;
							break;
						case 7 :
							f.changeCouleur(Color.MAGENTA);
							couleurSelect = Color.MAGENTA;
							break;
						case 8 :
							f.changeCouleur(Color.GRAY);
							couleurSelect = Color.GRAY;
							break;
						case 9 :
							f.changeCouleur(Color.CYAN);
							couleurSelect = Color.CYAN;
							break;
						case 10 :
							f.changeCouleur(Color.WHITE);
							couleurSelect = Color.WHITE;
							break;	
						default : 
							f.changeCouleur(Color.GRAY);
							couleurSelect = Color.GRAY;
						}
					dessin.repaint();
				}
				
				
			});
			
			// création du menu déroulant des figures 
			String listeFigures[] = new String[5]; 
			listeFigures[0] = "Rectangle";
			listeFigures[1] = "Triangle";
			listeFigures[2] = "Carré";
			listeFigures[3] = "Cercle";
			listeFigures[4] = "Quadrilatère";
			final JComboBox choixFigure= new JComboBox(listeFigures);
			choixFigure.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e1){
					FigureColoree fc = null;
					switch (choixFigure.getSelectedIndex()){
					case 0 : 
						fc = new Rectangle();
						break;
					case 1 :
						fc = new Triangle();
						break;
					case 2 : 
						fc = new Carre();
						break;
					case 3 : 
						fc = new Cercle();
						break;
					case 4 : 
						fc = new Quadrilatere();
						break;
						
					default : 
						fc = new Rectangle();
							
					}	// fin switch
					dessin.construit(fc);
					fc.changeCouleur(couleurSelect);
					dessin.repaint();
				}
				
			});

			
			JPanel haut = new JPanel();
			this.add(shape);
			shape.setSelected(true);
			this.add(choixFigure);
			this.add(couleurs);
			this.add(draw);
			this.add(move);
			this.add(erase);
			
			ActionListener al = new ActionListener(){
				public void actionPerformed(ActionEvent e){

					if(move.isSelected()){
						dessin.removeAllListeners();
						FigureColoree f = dessin.figureSelection();
						dessin.activeManipulationsSouris();
					}
					
					if(draw.isSelected()){
						Color couleurTrait = null;
						switch(couleurs.getSelectedIndex()){
						case 0 :
							couleurTrait = Color.BLACK;
							couleurSelect = Color.BLACK;
							break;
						case 1 :
							couleurTrait = Color.RED;
							couleurSelect = Color.RED;
							break;
						case 2 :
							couleurTrait = Color.GREEN;
							couleurSelect = Color.GREEN;
							break;
						case 3 :
							couleurTrait = Color.BLUE;
							couleurSelect = Color.BLUE;
							break;
						case 4 :
							couleurTrait = Color.YELLOW;
							couleurSelect = Color.YELLOW;;
							break;
						case 5 :
							couleurTrait = Color.PINK;
							couleurSelect = Color.PINK;;
							break;
						case 6 :
							couleurTrait = Color.ORANGE;
							couleurSelect = Color.ORANGE;
							break;
						case 7 :
							couleurTrait = Color.MAGENTA;
							couleurSelect = Color.MAGENTA;
							break;
						case 8 :
							couleurTrait = Color.GRAY;
							couleurSelect = Color.GRAY;
							break;
						case 9 :
							couleurTrait = Color.CYAN;
							couleurSelect = Color.CYAN;
							break;
						case 10 :
							couleurTrait = Color.WHITE;
							couleurSelect = Color.WHITE;
							break;
						default :
							couleurTrait = Color.BLACK;
							couleurSelect = Color.BLACK;
						}
						dessin.trace(couleurTrait);
					}
					
					if(erase.isSelected()){
						dessin.removeAllListeners();
						Graphics g = dessin.getGraphics();
						if(g != null){
							g.clearRect(0,0, dessin.getWidth(),dessin.getHeight());
						}
						dessin.removeAllListeners();
						dessin.effacer();
					}
					
				}
			};
			
			
			choixFigure.addActionListener(al);
			move.addActionListener(al);
			draw.addActionListener(al);
			erase.addActionListener(al);
			
			
		}
	
			
	}

	public static void main(String[] args) throws java.io.IOException {
		Fenetre f = new Fenetre();
	
	}
}
	
	


