import java.awt.*;

/**
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Morgane
 *
 */
public abstract class Polygone extends FigureColoree{

	private Polygon p;
	
	/**
	 * Constructeur vide : fabrique un polygone aux sommets al�atoires.
	 */
	public Polygone(){
		super();
	}
	
	/**
	 * Cette m�thode retourne vrai si le point 
	 * dont les coordonn�es sont pass�es en param�tre se trouve � l'int�rieur du polygone.
	 */
	public boolean estDedans(int a, int b){
		
		if(p.contains(a, b)){
			return true;
		}
		else
			return false;
	} 
	
	/**
	 * M�thode affichant un polygone (fait appel � drawPolygon de la classe Java Polygon).
	 * @param g - contexte graphique.
	 */
	public void affiche(Graphics g){
		p = new Polygon();
			for(int i = 0; i < tab_mem.length; i++){
				p.addPoint(tab_mem[i].rendreX(), tab_mem[i].rendreY());
			}
			g.setColor(this.getCouleur());
			g.fillPolygon(p);
			super.affiche(g);
	}
	
	/**
	 * Cette m�thode modifie le polygone conform�ment � un ensemble 
	 * de points de saisie (ses nouveaux sommets).
	 */
	 public void modifierPoints(Point[] tab_saisie){
		 if(tab_saisie!=null){
			 for(int i = 0; i < tab_mem.length; i++)
				 this.tab_mem = tab_saisie;
		 }
	 }
	 
	 
}
