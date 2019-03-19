/**
 * Classe premettant de creer la case d'un bateau
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class CaseBateau extends Case{


	/**
	 * initialise le bateau a la case
	 * @param b bateau ou il y a la case
	 */
	public CaseBateau(Bateau b) {
		super(b);
	}
	
		
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "=";
	}

}
