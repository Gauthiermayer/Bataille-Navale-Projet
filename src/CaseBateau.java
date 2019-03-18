/**
 * Classe premettant de creer la case d'un bateau
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class CaseBateau extends Case{
	
	/*
	 * bateau a l emplacement de la case
	 */
	private Bateau bateau;
	/*
	 * 
	 * @param b bateau ou il y a la case
	 */
	public CaseBateau(Bateau b) {
		this.bateau = b;
	}
	
		
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "=";
	}

}
