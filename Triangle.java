/**
 * classe Triangle
 * @author Morgane
 *
 */
public class Triangle extends Polygone{
	
	/**
	 * Ce constructeur instancie un triangle avec 
	 * des sommets al�atoires (via le constructeur de Polygone).
	 */
	public Triangle(){
		super();
	}
	
	
	/**
	 * Cette m�thode retourne en r�sultat le nombre de points de m�morisation d'un triangle.
	 */
	public int nbPoints(){
		return 3;
	}
	
	public int nbClics(){
		return 3;
	}
	

}
