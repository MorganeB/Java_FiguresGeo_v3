import java.awt.*;


/**
 * Classe "Quadrilatere". Permet de faire des rectangles
 * et des quadrilat�res quelconques 
 * @author Morgane
 *
 */
public class Quadrilatere  extends Polygone{
	
	
	/**
	 * Ce constructeur instancie un quadrilat�re avec 
	 * des sommets al�atoires (via le constructeur de Polygone).
	 */
	public Quadrilatere(){
		super();
	}
	
	/**
	 * Cette m�thode retourne en r�sultat le nombre de points dont on a besoin, en g�n�ral, pour la saisie d'un polygone.
	 */
	public int nbClics(){
		return 4;
	}
	
	/**
	 * Cette m�thode retourne en r�sultat le nombre de points de m�morisation d'un quadrilat�re.
	 */
	public int nbPoints(){
		return 4;
	}
	

}
