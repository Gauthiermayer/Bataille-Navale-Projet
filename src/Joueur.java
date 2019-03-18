import java.util.*;

/**
 * Classe premettant de creer un joueur
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class Joueur {
	
	/**
	 * liste des bateaux que possede le joueur 
	 */
	private ArrayList<Bateau> liste_bateau;
	
	/**
	 * grille dans laquelle le jouer place les bateau
	 * grille dans laquelle le joueur fait des attaque (memes emplacements de bateau que l'autre joeur)
	 */
	private Grille grille_bateau, grille_attaque;
	
	/**
	 constructeur du joueur
	 * @param nb_bateau nombre de bateau avec lequel on veut jouer 
	 * @param tx tailleX des grilles
	 * @param ty tailleY des grilles
	 */
	public Joueur(int nb_bateau,int tx, int ty) {
		
		this.grille_attaque = new Grille(tx,ty);
		this.grille_bateau = new Grille(tx,ty);
		
		this.liste_bateau = new ArrayList<Bateau>();
		for (int i = 1; i <= nb_bateau; i++) {
			this.liste_bateau.add(new Bateau(i));
		} 
	}
}
