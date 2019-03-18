/**
 * Classe premettant de creer une grille contenant des cases
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class Grille {

	/**
	 * tailles de la grille
	 */
	private int tailleX,tailleY;
	
	
	/**
	 * tableau 2D represantant la grille  
	 */
	private Case[][] grille;
	
	/*
	 * constructeur creant une grille de cases de base
	 * @param x taille en X
	 * @param y taille en Y
	 */
	public Grille(int x, int y) {
		this.tailleX = x;
		this.tailleY = y;
		this.grille = new Case[y][x];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grille[j][i] = new Case();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < this.tailleX; i++) {
			for (int j = 0; j < this.tailleY; j++) {
				res += grille[j][i];
			}
			res += "\n";
		}
		return res;
	}
	
	/*
	 * place le bateau a l endroit souhaite 
	 * @param b bateau a placer
	 * @param position x du bateau
	 * @param position y du bateau
	 * @param dir direction du bateau, h = horizontalement, v = verticalement
	 */
	public void placerBateau(Bateau b, int x, int y, char dir) throws GrilleException{
		
		if (dir == 'v') {
			for (int i = x; i < x+b.getSize();i++) {
				this.grille[x][i] = new CaseBateau(b);
			}			
		}
		else if (dir == 'h') {
			for (int i = x; i < x+b.getSize();i++) {
				this.grille[i][y] = new CaseBateau(b);
			}
		}
		else {
			throw new GrilleException("Erreur: mauvaise direction");
		}
		
	}
	
	/**
	 * verifie si on a deja tire sur la case
	 * @param x coordone x de la case
	 * @param y coordone y de la case
	 * @return true si la case a deja ete touchee
	 */
	public boolean estTouche(int x, int y) {
		return (this.grille[x][y] instanceof CaseBateauTouche || this.grille[x][y] instanceof CaseMerTouchee); 
	}
	
	/*
	 * getteur tailleX
	 * @return tailleX
	 */
	public int getTailleX() {
		return tailleX;
	}
	
	/*
	 * getteur tailleY
	 * @return tailleY
	 */
	public int getTailleY() {
		return tailleY;
	}
	
	/*
	 * getteur grille
	 * @return grille
	 */
	public Case[][] getGrille() {
		return grille;
	}
	
	
	
}
