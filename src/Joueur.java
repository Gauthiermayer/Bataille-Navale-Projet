import java.util.*;

/**
 * Classe premettant de creer un joueur
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public abstract class Joueur {
	
	/**
	 * liste des bateaux que possede le joueur 
	 */
	private ArrayList<Bateau> liste_bateau;
	
	/**
	 * grille dans laquelle le jouer place les bateau
	 * grille dans laquelle le joueur fait des attaque (memes emplacements de bateau que l'autre joeur)
	 */
	private Grille grille_bateau, grille_attaque;
	
	
	public Joueur(int nb_bateau,int tx, int ty) {
		
		this.grille_attaque = new Grille(tx,ty);
		this.grille_bateau = new Grille(tx,ty);
		
		this.liste_bateau = new ArrayList<Bateau>();
		for (int i = 2; i <= nb_bateau+1; i++) {
			this.liste_bateau.add(new Bateau(i));
		} 
	}
	
	
	/**
	 * fonction qui permet de bombarder une case 
	 * @param j2 joueur à attaquer 
	 * @param x coordonne x a attaquer (ignore si bot) 
	 * @param y coordonne y a attaquer (ignore si bot)
	 */
	public abstract void attaquer(Joueur j2, int x, int y) throws Exception;
	
	/**
	 * place le bateau a l endroit souhaite (parametres ignores si le joueur est un bot)
	 * @param b bateau a placer
	 * @param position x du bateau
	 * @param position y du bateau
	 * @param dir direction du bateau, h = horizontalement, v = verticalement
	 */
	public abstract void placerBateau(Bateau b, int x, int y, char dir) throws Exception;
	
	
	/**
	 * permet de mettre a jour une case de la grille des bateaux
	 */
	public void setCaseGrilleBateau(Case c, int x, int y) {
		this.grille_bateau.setCase(c, x, y);
	}
	
	/**
	 * permet de mettre a jour une case de la grille d attaque
	 */
	public void setCaseGrilleAttaque(Case c, int x, int y) {
		this.grille_attaque.setCase(c, x, y);
	}
	
		
	public Grille getGrille_bateau() {
		return grille_bateau;
	}


	public Grille getGrille_attaque() {
		return grille_attaque;
	}
	
	/**
	 * renvoie la grille sous forme de tab2D ou sont places les bateaux du joueur
	 * @return grille_bateau
	 */
	public Case[][] getGrille_bateauTab() {
		return grille_bateau.getGrille();
	}

	/**
	 * renvoie grille sous forme de tab2D des ataques effectuee
	 * @return grille_attaque
	 */
	public Case[][] getGrille_attaqueTab() {
		return grille_attaque.getGrille();
	}
	
	
	/**
	 * getteur liste de bateau
	 * @return liste_bateau
	 */
	public ArrayList<Bateau> getListe_bateau() {
		return liste_bateau;
	}

	
	/**
	 * verifie si tous les bateaux ont coule 
	 * @return true si le joueur a perdu
	 */
	public boolean aPerdu() {
		boolean perdu = true;
		for (Bateau b : liste_bateau) {
			if (!b.estCoule()) {
				perdu = false;
			}
		}
		
		return perdu;		
	}
}
