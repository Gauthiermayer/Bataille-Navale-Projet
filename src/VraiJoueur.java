import java.util.*;

/**
 * Classe premettant de creer un joueur jouable qui est un Joueur
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class VraiJoueur extends Joueur {
	
		
	/**
	 constructeur du joueur
	 * @param nb_bateau nombre de bateau avec lequel on veut jouer 
	 * @param tx tailleX des grilles
	 * @param ty tailleY des grilles
	 */
	public VraiJoueur(int nb_bateau,int tx, int ty) {
		super(nb_bateau,tx,ty);
	}
	

	@Override
	public void attaquer(Joueur j2, int x, int y) throws GrilleException {
		if (j2.getGrille_bateau().estTouche(x, y)) {
			throw new GrilleException("Erreur: Case deja touchee");
		}
		
		else if (j2.getGrille_bateauTab()[x][y] instanceof CaseBateau) {
			Bateau touche = j2.getGrille_bateauTab()[x][y].getBateau();
			touche.prendreDegat();
			
			//retire de la liste des bateau si coulé 
			if (touche.estCoule()) {
				j2.getListe_bateau().remove(touche);
			}
			
			Collections.sort(j2.getListe_bateau());
			
			j2.setCaseGrilleBateau(new CaseBateauTouche(), x, y);
			this.setCaseGrilleAttaque(new CaseBateauTouche(), x, y);
			
		}
		else {
			j2.setCaseGrilleBateau(new CaseMerTouchee(), x, y);
			this.setCaseGrilleAttaque(new CaseMerTouchee(), x, y);
		}		
	}
	
	
	@Override
	public void placerBateau(Bateau b, int x, int y, char dir) throws GrilleException {
		try {
			super.getGrille_bateau().placerBateau(b, x, y, dir);
		}
		catch (GrilleException e) {
			throw e;
		}	
	}
	
	
	
}
