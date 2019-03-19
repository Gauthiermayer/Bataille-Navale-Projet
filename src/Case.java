/**
 * Classe premettant de creer des cases 
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class Case {

	/**
	 * bateau a l emplacement de la case (null si pas CaseBateau)
	 */
	private Bateau bateau;
	
	/**
	 * constructeur case initiliase bateau a null
	 */
	public Case() {
		this.bateau = null;
	}
	
	/**
	 * initialise le bateau a la case
	 * @param b bateau ou il y a la case
	 */
	public Case(Bateau b) {
		this.bateau = b;
	}
	
	/**
	 * getteur de bateau
	 * @return bateau a la case 
	 */
	public Bateau getBateau() {
		return bateau;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return " ";
	}
}
